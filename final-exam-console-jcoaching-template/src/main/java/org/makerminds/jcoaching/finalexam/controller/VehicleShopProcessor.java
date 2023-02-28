 package org.makerminds.jcoaching.finalexam.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.makerminds.jcoaching.finalexam.model.Manufacturer;
import org.makerminds.jcoaching.finalexam.model.Vehicle;

/**
 * responsible for processing business processes.
 * 
 * @author <anduela-nurshaba>
 *
 */
public class VehicleShopProcessor {
	
	/**
	 * responsible to sell a specified vehicle by id
	 * @param vehiclesList
	 * @param vehicleChosenId
	 * @param vehicleList 
	 * @return 
	 */
	public void sellVehicle(List<Vehicle> vehiclesList, int vehicleChosenId) {
		Iterator<Vehicle> iterator = vehiclesList.iterator();
		while(iterator.hasNext()) {
			Vehicle vehicle = iterator.next();
			int id = vehicle.getId();
			if(id == vehicleChosenId) {
				iterator.remove();
			}
			
		}

	}
	
	
	public List<String> filterdataBasedInPrice(List<Vehicle> vehicleList, double price) {
		boolean hasDataInThisPriceRange = false;
		List<String> vehicleInfoList = new ArrayList<String>();
		System.out.println(price);
		for(Vehicle vehicle : vehicleList) {
			if(vehicle.getPrice() <= price) {
				String vehicleInfo = vehicle.getId() +  "," + vehicle.getManufacturer() + "," + vehicle.getModel()
                + "," + vehicle.getHorsePower() + "," + vehicle.getPrice() + "," + vehicle.getColor() + "," 
                + vehicle.getMileage() + "," + vehicle.getProductionYear() + "," + vehicle.getFuelType()
                + "," + vehicle.getTransmission();
				System.out.println(vehicleInfo);
				vehicleInfoList.add(vehicleInfo);
				hasDataInThisPriceRange = true;
			}
		}
		if (!hasDataInThisPriceRange) {
			System.out.println("No vehicle available in (0.0-"+ price+") price range");
		}
		return vehicleInfoList;
	}

	public  List<String> filterDataBasedInManufacturer(List<Vehicle> vehicleList, Manufacturer manufacturer) {
		List<String> vehicleInfoList = new ArrayList<String>();
		for(Vehicle vehicle : vehicleList) {
			if(vehicle.getManufacturer() .equals(manufacturer)) {
				String vehicleInfo = vehicle.getId() +  "," + vehicle.getManufacturer() + "," + vehicle.getModel()
                + "," + vehicle.getHorsePower() + "," + vehicle.getPrice() + "," + vehicle.getColor() + "," 
                + vehicle.getMileage() + "," + vehicle.getProductionYear() + "," + vehicle.getFuelType()
                + "," + vehicle.getTransmission();
				vehicleInfoList.add(vehicleInfo);
			}
		}
		
		return vehicleInfoList;
	}

}
