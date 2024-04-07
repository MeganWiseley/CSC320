package your.CT.name;

import java.util.Scanner; // this will allow the class to read the user input

public class TaxCalculator {
	public static double calculateTax(double income) {
		double taxRate; // this is the variable to store the class rate
		// this section determines the tax rate based on income
		if (income < 500) {
			taxRate = 0.10;
		} else if (income < 1500) {
			taxRate = 0.15;
		} else if (income < 2500) {
			taxRate = 0.20;
		} else {
			taxRate = 0.30;
		}
		
		// calculate tax being withheld 
		return income * taxRate;
	}
	// Main method
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Enter the number of weeks: ");
		int numWeeks = scanner.nextInt();
		
		double totalIncome = 0;
		
		for (int week = 1; week <= numWeeks; week++) {
			System.out.print("Enter income for week " + week + ":$");
			double weeklyIncome = scanner.nextDouble();
			totalIncome += weeklyIncome;
		}
		
		double averageIncome = totalIncome / numWeeks;
		double averageTaxWithheld = calculateTax(averageIncome);
		// Prints the results
		System.out.println("\nWeekly average income: $" + String.format("%.2f", averageIncome));
		System.out.println("Weekly average tax withheld: $" + String.format("%.2f", averageTaxWithheld));
		
		scanner.close();
	}
}