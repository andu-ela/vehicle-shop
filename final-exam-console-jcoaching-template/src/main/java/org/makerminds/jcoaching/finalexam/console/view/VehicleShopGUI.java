package org.makerminds.jcoaching.finalexam.console.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.makerminds.jcoaching.finalexam.controller.VehicleFileManager;
import org.makerminds.jcoaching.finalexam.controller.VehicleShopProcessor;
import org.makerminds.jcoaching.finalexam.controller.VehicleTransformer;
import org.makerminds.jcoaching.finalexam.model.Vehicle;


public class VehicleShopGUI {

	private JFrame frame;
	private JTable table;
	private DefaultTableModel dataModel;

	private static final String VEHICLE_LIST_PATH = "/vehicle-list.txt";
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VehicleShopGUI window = new VehicleShopGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VehicleShopGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(0, 0, 1200, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		frame.add(createTablePanel());
		frame.add(createButton());
	}
	
	private JPanel createTablePanel() {
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(0,0,1180,300);
		createTable();
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(20,20,1160,300);
		panel.add(scrollPane);
		return panel;
		
	}

	private void createTable() {
		table = new JTable();
		table.setBounds(20,20,1140,300);
		createDataModel();
		
	}
	
	private void createDataModel() {
		dataModel = new DefaultTableModel();
		String[] arr ={"ID", "Manufacturer", "Model", "HorsePower", "Price", "Color", "Mileage", "ProductionYear", "FuelType", "Transmission" };
		dataModel.setColumnIdentifiers(arr);
		getData();
		table.setModel(dataModel);
	}
	
	private void getData() {
		VehicleFileManager v = new VehicleFileManager(VEHICLE_LIST_PATH);
		List<String> list = v.importVehiclesFromFile();
		for(String l : list) {
			String[] arr = l.split(",");
			dataModel.addRow(arr);
		}
	}
	//creating button ( Sell Vehicle)
	private JButton createButton() {
		JButton bt = new JButton("Sell Vehicle");
		bt.setBounds(00, 350, 150, 50);
		bt.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				int selectedRow = table.getSelectedRow();
				int id = Integer.valueOf ( (String)table.getValueAt(selectedRow, 0));
				
				VehicleShopProcessor vehicleShopProcessor = new VehicleShopProcessor();
				
				VehicleFileManager v = new VehicleFileManager(VEHICLE_LIST_PATH);
				List<String> list = v.importVehiclesFromFile();
				VehicleTransformer vehicleTransformer = new VehicleTransformer();
				List<Vehicle> vehicleList =vehicleTransformer.transformDataArrayToVehicleObjects(list);
				vehicleShopProcessor.sellVehicle(vehicleList, id);
				dataModel.removeRow(selectedRow);
				
			}
			
		});
		return bt;
				
	}
	
}
