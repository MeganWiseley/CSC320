package module4_CriticalThinking;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		float[] values = readValues(scanner); // Read the five floating-point values
		float total = calculateTotal(values); // Calculate the total of the five values
		float average = calculateAverage(values); // Calculate the average of the five values
		float maximum = findMaximum(values); // Find the Maximum values  
		float minimum = findMinimum(values); // Find the Minimum values
		float interest = 0.0f; // Declare and initialize the interest variable
		interest = calculateInterest(total); // Calculate the interest on the total
		
		// Print out the results of the above calculations
		System.out.println("Total: " + formatWithCommas(total));
		System.out.println("Average: " + formatWithCommas(average));
		System.out.println("Maximum: " + formatWithCommas(maximum));
		System.out.println("Minimum: " + formatWithCommas(minimum));
		System.out.println("Interest on total at 20%: " + formatWithCommas(interest));
		
	}
	// Method to read the five floating-point values from the user, using a while loop
	public static float[] readValues(Scanner scanner) {
		float[] values = new float [5];
		int count = 0;
		System.out.println("Enter five floating-point values:");
		while (count < 5) {
			try {
				values[count] = scanner.nextFloat();
				count++;
			} catch (Exception e) {
				System.out.println("Invalid Input. Please Try again.");
				scanner.next(); // clear input buffer
			}
		}
		return values;
	}
	// Method to calculate the total of the values
	public static float calculateTotal(float[] values) {
		float total = 0;
		for (float value : values) {
			total += value;
		}
		return total;
	}
	// Method to calculate the average of the values
	public static float calculateAverage(float[] values) {
		float total = calculateTotal(values);
		return total / values.length;
	}
	// Method to find the Maximum of the values
	public static float findMaximum(float[] values) {
		float max = values[0];
		for (int i = 1; i <values.length; i++) {
			if (values[i] > max) {
				max = values[i];
			}
		}
		return max;
	}
	// Method to find the minimum of the values
	public static float findMinimum(float[] values) {
		float min = values[0];
		for (int i = 1; i < values.length; i++) {
			if (values[i] < min) {
				min = values[i];
			}
		}
		return min;
	}
	// Method to calculate the interest at 20% of the total
	public static float calculateInterest(float total) {
		return total * 0.20f;
	}
	// Method to format a float with commas
	public static String formatWithCommas(float value) {
		String[] parts = String.valueOf(value).split("\\.");
		
		String integerPart = addCommas(parts[0]);
		
		if (parts.length > 1) {
			return integerPart + "." + parts[1];
		} else {
			return integerPart;
		}
	}
	// Method to add commas to a string representing an integer
	public static String addCommas(String str) {
		StringBuilder result = new StringBuilder();
		int len = str.length();
		int commaCount = 0;
		for (int i = len - 1; i >= 0; i--) {
			result.append(str.charAt(i)); // Append character to StringBuilder
			commaCount++;
			if (commaCount % 3 == 0 && i != 0) {
				result.append(","); // Append comma after every third digit
			}
		}
		return result.reverse().toString(); // Reverse StringBuilder and convert to String
	}
}
