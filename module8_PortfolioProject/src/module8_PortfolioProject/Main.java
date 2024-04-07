package module8_PortfolioProject;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	// Nested class representing Automobile Inventory
	private static class Automobile_Inventory {
		private String make;
		private String model;
		private String color;
		private int year;
		private int mileage;
		// Constructor to initialize default values 
		public Automobile_Inventory() {
			this.make = "";
			this.model = "";
			this.color = "";
			this.year = 0;
			this.mileage = 0;
		}
		// Method to add new vehicle 
		public String addVehicle(String make, String model, String color, int year, int mileage) {
			try {
				this.make = make;
				this.model = model;
				this.color = color;
				this.year = year;
				this.mileage = mileage;
				return "Vehicle added";
			} catch (Exception e) {
				return "Error occured, try again: " + e.getMessage();	
			}
		}
		public String[] listVehicleInformation() {
			try {
				String[] vehicleInfo = {this.make, this.model, this.color, Integer.toString(this.year), Integer.toString(this.mileage)};
				return vehicleInfo;
			} catch (Exception e) {
				return new String[]{"Unable to list vehicle information: " + e.getMessage()};	
			}
		}
		// Method to remove vehicle 
		public String removeVehicle() {
			try {
				this.make = "";
				this.model = "";
				this.color = "";
				this.year = 0;
				this.mileage = 0;
				return "Vehicle removed.";
			} catch (Exception e) {
				return "Failed to remove vehicle, try again: " + e.getMessage();		
			}
		}
		// Method to update vehicle attributes 
		public String updateVehicleAttributes(String make, String model, String color, int year, int mileage) {
			try {
				this.make = make;
				this.model = model;
				this.color = color;
				this.year = year;
				this.mileage = mileage;
				return "Vehicle attributes updated.";
			} catch (Exception e) {
				return "Unable to update attributes, try again. " + e.getMessage();				
			}
		}
		// Method to print vehicle to file
		public String printToFile(String filePath, List<String[]> vehicleList) {
			try {
				FileWriter writer = new FileWriter(filePath);
				for (String[] vehicle : vehicleList) {
					for (String info : vehicle) {
						writer.write(info + ",");
					}
					writer.write("\n");
				}
				writer.close();
				return "Information printed to a file.";
			} catch (IOException e) {
				return "Failed to print information to file, try again: " + e.getMessage();
			}
		}
	}
	// Main Method
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Automobile_Inventory inventory = new Automobile_Inventory();
		List<String[]> vehicleList = new ArrayList<>();
		// Loop for a menu driven program
		while (true) {
			System.out.println("\nChoose an option: ");
			System.out.println("1. Add Vehicle");
			System.out.println("2. Remove Vehicle");
			System.out.println("3. Update Vehicle Attributes");
			System.out.println("4. Print Information to File");
			System.out.println("5. View Inventory");
			System.out.println("6. Exit Program");
			
			System.out.print("Enter your choice: ");
			int choice;
			try {
				choice = Integer.parseInt(scanner.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("Invalid input, try again.");
				continue;
			}
			// Using a switch case to use different menu options			
			switch (choice) {
				case 1:
					 // Add Vehicle
				    System.out.println("Enter the following information regarding the vehicle:");
				    System.out.print("Make: ");
				    String make = scanner.nextLine();
				    System.out.print("Model: ");
				    String model = scanner.nextLine();
				    System.out.print("Color: ");
				    String color = scanner.nextLine();
				    System.out.print("Year: ");
				    int year = scanner.nextInt();
				    scanner.nextLine(); // consume newline character
				    System.out.print("Mileage: ");
				    String mileageStr = scanner.nextLine(); // read mileage as a string
				    // Remove commas from the mileage string and parse it into an integer
				    int mileage = Integer.parseInt(mileageStr.replaceAll(",", ""));
				    String addStatus = inventory.addVehicle(make, model, color, year, mileage);
				    System.out.println(addStatus);
				    vehicleList.add(inventory.listVehicleInformation()); // Add vehicle to the list
				    break;
				case 2:
					String removeStatus = inventory.removeVehicle();
					System.out.println(removeStatus);
					break;
				case 3:
                    System.out.println("Enter updated information regarding the vehicle:");
                    System.out.print("Make: ");
                    String updatedMake = scanner.nextLine();
                    System.out.print("Model: ");
                    String updatedModel = scanner.nextLine();
                    System.out.print("Color: ");
                    String updatedColor = scanner.nextLine();
                    System.out.print("Year: ");
                    int updatedYear = scanner.nextInt();
                    System.out.print("Mileage: ");
                    int updatedMileage = scanner.nextInt();
                    scanner.nextLine(); // newline character
                    String updateStatus = inventory.updateVehicleAttributes(updatedMake, updatedModel, updatedColor, updatedYear, updatedMileage);
                    System.out.println(updateStatus);
                    break;
				case 4:
                   vehicleList.add(inventory.listVehicleInformation());
                   String printStatus = inventory.printToFile("C:\\Temp\\Autos.txt", vehicleList);
                   System.out.println(printStatus);
                   break;
				case 5:
					   // View Inventory
				    if (vehicleList.isEmpty()) {
				        System.out.println("Inventory Empty.");
				    } else {
				        System.out.println("Current Inventory:");
				        for (String[] vehicleInfo : vehicleList) {
				            System.out.println("Make: " + vehicleInfo[0]);
				            System.out.println("Model: " + vehicleInfo[1]);
				            System.out.println("Color: " + vehicleInfo[2]);
				            System.out.println("Year: " + vehicleInfo[3]);
				            // Format mileage with commas
				            String formattedMileage = String.format("%,d", Integer.parseInt(vehicleInfo[4]));
				            System.out.println("Mileage: " + formattedMileage);
				            System.out.println();
				        }
				    }
				    break;
				case 6:
					System.out.println("Exiting");
					scanner.close();
					System.exit(0);
				default:
					System.out.println("Invalid Choice, try again.");
			}
		}
	}
}


