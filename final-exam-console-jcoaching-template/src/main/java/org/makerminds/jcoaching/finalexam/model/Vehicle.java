package org.makerminds.jcoaching.finalexam.model;

/**
 * class for vehicle objects.
 * 
 * @author <anduela-nurshaba>
 *
 */
public class Vehicle {
	
			
	
	//Vehicle implementation
	private int Id;
	private Manufacturer manufacturer;
	private String model; 
	private int horsePower;
	private Color color;
	private double price;
	private int mileage;
	private int productionYear;
	private Transmission transmission;
	private FuelType fuelType;
	
	// attributes
	public Vehicle (int Id, Manufacturer manufacturer, String model ,  int horsePower,double price,Color color, int mileage, int productionYear, FuelType fuelType,Transmission transmission) {
		this.Id = Id;
		this.manufacturer = manufacturer;
		this.model = model;
		this.horsePower = horsePower;
		this.color = color;
		this.price = price;
		this.mileage = mileage;
		this.productionYear = productionYear;
		this.transmission = transmission;
		this.fuelType = fuelType;
	}
    

	
	




	// getters and setters for attributes
	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public Manufacturer getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(Manufacturer manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getHorsePower() {
		return horsePower;
	}

	public void setHorsePower(int horsePower) {
		this.horsePower = horsePower;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getMileage() {
		return mileage;
	}

	public void setMileage(int mileage) {
		this.mileage = mileage;
	}

	public int getProductionYear() {
		return productionYear;
	}

	public void setProductionYear(int productionYear) {
		this.productionYear = productionYear;
	}

	public Transmission getTransmission() {
		return transmission;
	}

	public void setTransmission(Transmission transmission) {
		this.transmission = transmission;
	}

	public FuelType getFuelType() {
		return fuelType;
	}

	public void setFuelType(FuelType fuelType) {
		this.fuelType = fuelType;
	}


	
	
}
