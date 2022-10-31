package model; 

public class AutonomousCar extends Car{

	private double possition;
	private double speed;

	public AutonomousCar(String id, String plate, String model, double possition, double speed) {
		super(id,plate,model); 
		this.possition = possition;
		this.speed = speed;
	}

	public double getPossition(){
		return this.possition; 
	}
	public double getSpeed(){
		return speed;
	}
	public String getType(){
		return "AutonomousCar";
	}


}