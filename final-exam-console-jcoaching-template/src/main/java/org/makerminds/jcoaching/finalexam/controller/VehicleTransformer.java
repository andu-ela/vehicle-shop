package org.makerminds.jcoaching.finalexam.controller;

import java.util.ArrayList;
import java.util.List;

import org.makerminds.jcoaching.finalexam.model.Color;
import org.makerminds.jcoaching.finalexam.model.FuelType;
import org.makerminds.jcoaching.finalexam.model.Manufacturer;
import org.makerminds.jcoaching.finalexam.model.Transmission;
import org.makerminds.jcoaching.finalexam.model.Vehicle;

/**
 * responsible for transforming vehicle data into {@link Vehicle} objects.
 * 
 * @author Anduela Nurshaba
 
 */
public class VehicleTransformer {

	/**
	 * transforms a data array into a {@link Vehicle} list
	 * 
	 * @param vehicle data array
	 * @return list of {@link Vehicle} objects
	 */
	
	 

	
	public List<Vehicle> transformDataArrayToVehicleObjects(List<String> vehicleDataArray) {
		List<Vehicle> vehicleList = new ArrayList<Vehicle>();
		for (String VehicleAsString : vehicleDataArray) {
			Vehicle vehicle = transformToVehicleObject(VehicleAsString);
			vehicleList.add(vehicle);
		}
		return vehicleList;
	}

	/**
	 * transforms a vehicle data record as String into a {@link Vehicle} object
	 * 
	 * @param vehicle data record as String
	 * @return {@link Vehicle} object
	 */
	  
		
	  
	

	public Vehicle transformToVehicleObject(String vehicleAsString) {
		String[] vehicleInfo = vehicleAsString.split(",");
		
		
		int Id = Integer.parseInt(vehicleInfo[0]);
		Manufacturer manufacturer = getManufacturerfromString(vehicleInfo[1]);
		String model = vehicleInfo[2];
		int horsePower = Integer.parseInt(vehicleInfo[3]);
		double price = Double.parseDouble(vehicleInfo[4]);
		Color color = getColorFromString(vehicleInfo[5]);
		int mileage = (Integer.parseInt(vehicleInfo[6]));
		int productionYear = Integer.parseInt(vehicleInfo[7]);
		FuelType fuelType = getFuelTypeFromString (vehicleInfo[8]);
		Transmission transmission = getTransmissionFromString(vehicleInfo[9]);
		
		
		Vehicle vehicle = new Vehicle(productionYear, manufacturer, model, productionYear, price, color, productionYear, productionYear, fuelType, transmission);
		vehicle.setId(Id);
		vehicle.setManufacturer(manufacturer);
		vehicle.setModel(model);
		vehicle.setHorsePower(horsePower);
		vehicle.setPrice(price);
		vehicle.setColor(color);
		vehicle.setMileage(mileage);
		vehicle.setProductionYear(productionYear);
		vehicle.setFuelType(fuelType);
        vehicle.setTransmission(transmission);
		
		return vehicle;	
		
		
	}
	
	
   //method for transmission
	public Transmission getTransmissionFromString(String transmissionAsString) {
		for(Transmission transmission : Transmission.values()) {
			if(transmission.name().equals(transmissionAsString)) {
				return transmission;
		}
	}
	  throw new IllegalArgumentException("Transmission not supported" + transmissionAsString);
	}
	
	
	//method for fueltype
	public FuelType getFuelTypeFromString(String fuelTypeAsString) {
		for(FuelType fuelType : FuelType.values()) {
			if(fuelType.name().equals(fuelTypeAsString)) {
		return fuelType;
			}
		}
		throw new IllegalArgumentException("FuelaType bot supported" + fuelTypeAsString);
	}

	
	//method for color
	public Color getColorFromString(String colorAsString) {
		for(Color color : Color.values()) {
			if(color.name().equals(colorAsString)) {
		return color;
	  }
		}
	
	throw new IllegalArgumentException("Color not supported" + colorAsString);
	
}

	//method for manufacturer
	public Manufacturer getManufacturerfromString(String manufacturerAsString) {
		for(Manufacturer manufacturer : Manufacturer.values()) {
			if(manufacturer.name().equals(manufacturerAsString)) {
				return manufacturer;
			}
		}
		
		throw new IllegalArgumentException("Manufacturer not supported" + manufacturerAsString);
	}

	public static void initializeVehicleInfo() {
		
		
	}


	
}