package org.makerminds.jcoaching.finalexam.console;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Scanner;

import org.makerminds.jcoaching.finalexam.controller.VehicleFileManager;
import org.makerminds.jcoaching.finalexam.controller.VehicleShopPrinter;
import org.makerminds.jcoaching.finalexam.controller.VehicleShopProcessor;
import org.makerminds.jcoaching.finalexam.controller.VehicleTransformer;
import org.makerminds.jcoaching.finalexam.model.Manufacturer;
import org.makerminds.jcoaching.finalexam.model.Vehicle;

/**
 * providing main method to start the application.
 * 
 * @author Anduela Nurshaba
 * 
 * 
 *
 */
public class VehicleShop {

	private static final String VEHICLE_LIST_PATH = "/vehicle-list.txt";
	static int avaliableVehiclenr = 10;
	private static Object Vehicles;
	private static List<String> vehicleDataStringList;

	public static void main(String[] args) throws URISyntaxException, IOException {

		VehicleShopProcessor vehicleShopProcessor = new VehicleShopProcessor();
		// file reading
		VehicleFileManager vehicleFileManager = new VehicleFileManager(VEHICLE_LIST_PATH);
		List<String> vehicleDataAsStringList = vehicleFileManager.importVehiclesFromFile();

		// transformation into Vehicle Java Objects
		VehicleTransformer vehicleTransformer = new VehicleTransformer();
		List<Vehicle> vehicleList = vehicleTransformer.transformDataArrayToVehicleObjects(vehicleDataAsStringList);

		// printing available vehicles
		VehicleShopPrinter vehicleShopPrinter = new VehicleShopPrinter();
		vehicleShopPrinter.printAvailableVehicles(vehicleList);

		// user interaction - selecting a vehicle to sell
		System.out.println(
				"Please enter 1 to sale a vehicle \n Enter 2 to filter data based in price \n Enter 3 to filter data based in manufacturer:");
		Scanner scanner = new Scanner(System.in);

		int option = Integer.valueOf(scanner.next());
		switch (option) {
		case 1:
			vehicleShopPrinter.printVehicleIdToSellRequest();
			int vehicleChosenId = scanner.nextInt();
			vehicleShopProcessor.sellVehicle(vehicleList, vehicleChosenId);

			// write new vehicle list back to file
			vehicleFileManager.rewriteFile(vehicleList);

			// print sold vehicle information and new vehicle list
			vehicleShopPrinter.printVehicleSoldMessage(vehicleChosenId);
			break;
		case 2:
			System.out.println("Enter a price:");
			double price = Double.valueOf(scanner.next());
			List<String> vehicleInfo = vehicleShopProcessor.filterdataBasedInPrice(vehicleList, price);
			List<Vehicle> vehicleListPrice = vehicleTransformer.transformDataArrayToVehicleObjects(vehicleInfo);
			vehicleShopPrinter.printAvailableVehicles(vehicleListPrice);
			vehicleShopPrinter.printVehicleIdToSellRequest();
			vehicleChosenId = scanner.nextInt();
			vehicleShopProcessor.sellVehicle(vehicleList, vehicleChosenId);

			// write new vehicle list back to file
			vehicleFileManager.rewriteFile(vehicleList);
			break;
		case 3:
			System.out.println("Enter a manufacturer");
			scanner.nextLine();
			Manufacturer manufacturer = vehicleTransformer.getManufacturerfromString(scanner.nextLine());
			vehicleInfo = vehicleShopProcessor.filterDataBasedInManufacturer(vehicleList, manufacturer);
			vehicleListPrice = vehicleTransformer.transformDataArrayToVehicleObjects(vehicleInfo);
			vehicleShopPrinter.printAvailableVehicles(vehicleListPrice);
			vehicleShopPrinter.printVehicleIdToSellRequest();
			vehicleChosenId = scanner.nextInt();
			vehicleShopProcessor.sellVehicle(vehicleList, vehicleChosenId);
		

			// write new vehicle list back to file
			vehicleFileManager.rewriteFile(vehicleList);

			// print sold vehicle information and new vehicle list
			vehicleShopPrinter.printVehicleSoldMessage(vehicleChosenId);
			break;
		default:
			scanner.close();
			throw new IllegalArgumentException("Our program dosn't support this action.");
		
		}

		vehicleShopPrinter.printAvailableVehicles(vehicleList);
		scanner.close();
	}
	
	//methods
	public static Object getVehicles() {
		return Vehicles;
	}

	public static void setVehicles(Object vehicles) {
		Vehicles = vehicles;
	}

	public static List<String> getVehicleDataStringList() {
		return vehicleDataStringList;
	}

	public static void setVehicleDataStringList(List<String> vehicleDataStringList) {
		VehicleShop.vehicleDataStringList = vehicleDataStringList;
	}
}
