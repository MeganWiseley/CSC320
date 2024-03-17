package module5_CriticalThinking;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.text.DecimalFormat;


public class TemperatureTracker {
	private ArrayList<String> daysOfWeek;
	private ArrayList<Double> temperatures;
	
	// Construct to initialize ArrayLists
	public TemperatureTracker() {
		daysOfWeek = new ArrayList<>();
		temperatures = new ArrayList<>();
		
	}
	
	// Method to add a day and its temperature to the lists
	public void addTemperature(String day, double temperature) {
		daysOfWeek.add(day);
		temperatures.add(temperature);
		
	}
	
	// Method to display all recorded temperatures
	public void displayTemperature() {
		for (int i = 0; i < daysOfWeek.size(); i++) {
			System.out.println("Day: " + daysOfWeek.get(i) + ", Temperature:" + temperatures.get(i));
					
		}
	}
	
	// Method to calculate and display the weekly average temperature
	public void calculateWeeklyAverage() {
		double sum = 0;
		for (double temp : temperatures) {
			sum += temp;
		}
		double average = sum / temperatures.size();
		
		// Format the average temperature to the hundredth of a decimal point 
		DecimalFormat df = new DecimalFormat("#.##");
		String formattedAverage = df.format(average);
		
		System.out.println("Weekly average temperature: " + formattedAverage);
	}
	
	// Main method that runs the program including user input
	public static void main(String[] args) {
		TemperatureTracker tracker = new TemperatureTracker();
		Scanner scanner = new Scanner(System.in);
		String inputDay;
		double inputTemperature;
		
		// Loop to interact with the user
		while(true) {
			try {
				// Prompt user for day of the week or week 
				System.out.println("Enter a day of the week (Monday to Sunday) or 'week' to display weekly average: ");
				inputDay = scanner.nextLine().trim();
				
				// If week is entered, display the recorded temperature and the average
				if (inputDay.equalsIgnoreCase("week")) {
					tracker.displayTemperature();
					tracker.calculateWeeklyAverage();
					break;
				} else {
					inputDay = inputDay.toLowerCase(); // Convert input to lowercase for a case-insensitve comparison 
					
					// Check for valid day of the week and temperature
					if (inputDay.equals("monday") || inputDay.equals("tuesday") || inputDay.equals("wednesday") ||
							inputDay.equals("thursday") || inputDay.equals("friday") || inputDay.equals("saturday") ||
							inputDay.equals("sunday")) {
						System.out.println("Enter the average temperature for " + inputDay + ":");
						inputTemperature = scanner.nextDouble();
						tracker.addTemperature(inputDay, inputTemperature);
						scanner.nextLine(); // Add a new line
					} else {
						// Handles invalid day of the week
						System.out.println("Invalid input. Please enter a valid day of the week.");		
					}
				}
			} catch (InputMismatchException e) {
				// Handles invalid temperature
				System.out.println("Invalid input. Please enter a valid temperature (numeric value).");
				scanner.nextLine();
			} catch (Exception e) {
				// Handles other exceptions
				System.out.println("An error occurred: " + e.getMessage());				
			}
		}
		scanner.close(); // Closes the Scanner Object
	}

}
