package org.makerminds.jcoaching.finalexam.controller;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;

import org.makerminds.jcoaching.finalexam.model.Vehicle;

/**
 * managing the file.
 * 
 * @author Anduela Nurshaba
 *
 */
public class VehicleFileManager {
	
	private String filePath;
	
	
	public VehicleFileManager(String filePath) {
		this.filePath = filePath;
	}

	public List<String> importVehiclesFromFile(){
		

		try {
			return Files.readAllLines(Paths.get(getClass().getResource(filePath).toURI()));
		} catch (IOException | URISyntaxException e ) {
		
			throw new RuntimeException("An error occured while importing.", e );
		}
	}
	
	public void rewriteFile(List<Vehicle> vehicleList) {
		StringBuffer vehicleStringForRewrite = new StringBuffer();
		Iterator<Vehicle> iterator = vehicleList.iterator();
		while(iterator.hasNext()) {
			Vehicle vehicle = iterator.next();
			prepareTheVehicleForRewriting(vehicleStringForRewrite, vehicle);
			vehicleStringForRewrite.append("\r\n");
		}
	   try {
		Path path = Paths.get(getClass().getResource(filePath).toURI());
		Files.writeString(path, vehicleStringForRewrite);
		
	} catch ( IOException | URISyntaxException e) {
		e.printStackTrace();
	}
	   
	}
	
	private void prepareTheVehicleForRewriting(StringBuffer vehicleStringForRewrite, Vehicle vehicle) {
		// added vehicle attribute information to StringBuffer
	
		vehicleStringForRewrite.append(vehicle.getId() + ",");
		vehicleStringForRewrite.append(vehicle.getManufacturer() + ",");
		vehicleStringForRewrite.append(vehicle.getModel() + ",");
		vehicleStringForRewrite.append(vehicle.getHorsePower() + ",");
		vehicleStringForRewrite.append(vehicle.getPrice() + ",");
		vehicleStringForRewrite.append(vehicle.getColor() + ",");
		vehicleStringForRewrite.append(vehicle.getMileage() + ",");
		vehicleStringForRewrite.append(vehicle.getProductionYear() + ",");
		vehicleStringForRewrite.append(vehicle.getFuelType() + ",");
		vehicleStringForRewrite.append(vehicle.getTransmission() + "\n");
	
	}

}
