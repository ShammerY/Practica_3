package model;

public abstract class Car{
	
	protected String id;
	protected String plate;
	protected String model;

	public Car(String id, String plate, String model) {
		this.id = id;
		this.plate = plate;
		this.model = model;
	}

	public String getId(){
		return id;
	}
	public String getPlate(){
		return plate;
	}
	public String getModel(){
		return model;
	}



	

}