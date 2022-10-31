package model; 

public class ElectricCar extends Car{

	private double batteryCapacity;

	public ElectricCar(String id, String plate, String model, double batteryCapacity) {
		super(id,plate,model); 
		this.batteryCapacity = batteryCapacity;
	}

	public double getBatteryCapacity(){
		return batteryCapacity;
	}

	public String getType(){
		return "ElectricCar";
	}
	public void setBatteryCapacity(double battery){
		this.batteryCapacity = battery;
	}


}