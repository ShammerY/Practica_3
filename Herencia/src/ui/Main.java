package ui; 

import model.*; 
import java.util.Scanner;


public class Main{

	public static final int TOTAL_CAR = 10;
	private Scanner reader;
	private CarSystem carSystem;

	public Main(){
		reader = new Scanner(System.in);
		carSystem = new CarSystem();

	}

	public static void main(String[] args) {
		Main main = new Main();
		String option = "";
		do{
			option = main.showMenu();
			main.executeOption(option);
		}while(option.equals("0")==false);

	}
	public void print(String text){
		System.out.println(text);
	}
	public String showMenu(){
		String option = "";
		print("\n----------------------------------------------\n"+
			"               CAR SYSTEM              \n"+
			"----------------------------------------------\n"+
			"(1)  Register Autonomous Car \n"+
			"(2)  Register Electric Car  \n"+
			"(3)  Calculate battery level \n"+
			"(4)  Calculate Colission \n"+
			"(0)  Exit Program");
		option = reader.next();
		return option;
	}
	public void executeOption(String option){
		String msj = "";
		int pos = -1;
		int pos2 = -1;

		String id = "";
		String id2 = "";
		String plate = "";
		String model = "";
		double possition = 0;
		double speed = 0;
		double batteryCapacity = 0;

		double distance = 0;

		switch(option){
			case "1":
				print("\n Autonomous car Registration \n \n Enter ID :");
				id = reader.next();
				pos = carSystem.searchCar(id);
				if(pos==-1){
					print("\n Enter Plate :");
					plate = reader.next();
					print("\n Enter Model :");
					model = reader.next();
					print("\n Enter Car possition :");
					do{
						if(reader.hasNextDouble()){
							possition = reader.nextDouble();
							if(possition < 0){print("\n INVALID POSSITION");}
						}else{print("\n INVALID POSSITION");possition = -1; reader.next();}
					}while(possition<0);
					print("\n Enter Car Speed :");
					do{
						if(reader.hasNextDouble()){
							speed = reader.nextDouble();
							if(speed < 0){print("\n INVALID SPEED");}
						}else{print("\n INVALID SPEED");speed = -1; reader.next();}
					}while(speed<0);
						
					msj = carSystem.addAutonomousCar(id, plate, model, possition, speed);
				}else{msj = "\n Car ID Already exists";}
				print(msj);
				break;
			case "2":
				print("\n Electric Car Registration \n \n Enter ID :");
				id = reader.next();
				pos = carSystem.searchCar(id);
				if(pos==-1){
					print("\n Enter Plate :");
					plate = reader.next();
					print("\n Enter Model :");
					model = reader.next();
					print("\n Enter Car Battery Capacity :");
					do{
						if(reader.hasNextDouble()){
							batteryCapacity = reader.nextDouble();
							if(batteryCapacity < 0){print("\n INVALID BATTERY CAPACITY");}
						}else{print("\n INVALID BATTERY CAPACITY");batteryCapacity = -1; reader.next();}
					}while(batteryCapacity<0);
					
					msj = carSystem.addElectricCar(id, plate, model, batteryCapacity);
				}else{msj = "\n Car ID Already exists";}
				
				print(msj);
				
				break;
			case "3":
				print("\n BATTERY CALCULATION \n \n Enter Car ID :");
				id = reader.next();
				pos = carSystem.searchCar(id);
				if(pos!=-1){
					print("\n Enter distance Traveled");
					do{
						if(reader.hasNextDouble()){
							distance = reader.nextDouble();
							if(distance < 0){print("\n INVALID distance");}
						}else{print("\n INVALID distance");distance = -1; reader.next();}
					}while(distance<0);
					msj = carSystem.calculateBattery(pos, distance);
				}else{msj = "\n CAR NOT FOUND";}
					
				print(msj);
				break;
				
			case "4":
				print("\n Car Colission Probability \n \n Enter 1st car ID :");
				id = reader.next();
				pos = carSystem.searchCar(id);
				if(pos!=-1){
					print("\n Enter seccond Car Id");
					id2 = reader.next();
					pos2 = carSystem.searchCar(id2);
					if(pos!=-1){
						msj = carSystem.calculateColission(pos, pos2);
					}else{msj = "\n CAR NOT FOUND";}
				}else{msj = "\n CAR NOT FOUND";}
				print(msj);
				break;
			case "0":
				print("\n SEE YOU NEXT TIME :)");
		}
	}
	

}