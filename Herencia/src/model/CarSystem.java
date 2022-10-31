package model;

public class CarSystem{

	public static final int TOTAL_CARS = 10;
	private ElectricCar[] electricCars;
	private AutonomousCar[] autonomousCars;
	private int carCont;
	private String[] carTypes;

	public CarSystem(){
		autonomousCars = new AutonomousCar[TOTAL_CARS];
		electricCars = new ElectricCar[TOTAL_CARS];
		carTypes = new String[TOTAL_CARS*2];
		carCont = 0;
	}

	public int searchCar(String carId){
		int pos = -1;
		boolean isFound = false;
		for(int i= 0; i<TOTAL_CARS && isFound==false; i++){
			if(electricCars[i]!= null){
				if(carId.equals(electricCars[i].getId())){
					pos = i;
					isFound = true;
				}
			}
		}
		for(int i= 0; i<TOTAL_CARS && isFound==false; i++){
			if(autonomousCars[i]!= null){
				if(carId.equals(autonomousCars[i].getId())){
					pos = i;
					isFound = true;
				}
			}
		}
		return pos;
	}
	public String addAutonomousCar(String id,String plate,String model,double possition,double speed){
		String msj = "";
		int pos = -1;
		pos = searchAutonomouscarEmptyPos();
		if(pos!=-1){
			autonomousCars[pos] = new AutonomousCar(id, plate, model, possition, speed);
			msj = "\n AUTONOMOUS CAR REGISTERED SUCCESFULLY";
			carTypes[carCont]="AutonomousCar";
			carCont++;
		}else{msj = "\n REACHED LIMIT AMOUNT OF AUTONOMOUS CARS";}
		return msj;
	}
	public int searchAutonomouscarEmptyPos(){
		int pos = -1;
		boolean isFound = false;
		for(int i=0; i<TOTAL_CARS && isFound == false; i++){
			if(autonomousCars[i]==null){
				pos = i;
				isFound = true;
			}
		}
		return pos;
	}
	public String addElectricCar(String id,String plate,String model,double batteryCapacity){
		String msj = "";
		int pos = -1;
		pos = searchElectricCarEmptyPos();
		if(pos!=-1){
			electricCars[pos]=new ElectricCar(id, plate, model, batteryCapacity);
			msj = "\n ELECTRIC CAR REGISTERED SUCCESFULLY";
			carTypes[carCont]="ElectricCar";
			carCont++;
		}else{msj = "\n ELECTRIC CAR LIMIT AMOUNT REACHED";}
		return msj;
	}
	public int searchElectricCarEmptyPos(){
		int pos = -1;
		boolean isFound = false;
		for(int i=0; i<TOTAL_CARS && isFound == false; i++){
			if(electricCars[i]==null){
				pos = i;
				isFound = true;
			}
		}
		return pos;
	}
	public String calculateBattery(int pos, double distance){
		String msj = "";
		double battery = 0;
		double batteryUsed = 0;
		if(electricCars[pos]!=null){
			if(electricCars[pos].getType().equals("ElectricCar")){
				batteryUsed = distance*0.02;
				battery = electricCars[pos].getBatteryCapacity() - batteryUsed;
				msj = "\n PREVIOUS BATTERY CAPACITY : "+electricCars[pos].getBatteryCapacity()+" KW";
				electricCars[pos].setBatteryCapacity(battery);
				msj += "\n NEW BATTERY CAPACITY : "+electricCars[pos].getBatteryCapacity()+" KW";
			}else{msj = "\n This is not an Electric car";}
		}else{msj = "\n Not an Electric Car";}
			
		return msj;
		
	}
	public String calculateColission(int pos1, int pos2){
		String msj = "";
		if(autonomousCars[pos1].getPossition()==autonomousCars[pos2].getPossition()){
			msj = "\n CARS CAN CRASH !!";
		}else{msj = "\n CARS ARE SAFE";}
		return msj;
	}
}