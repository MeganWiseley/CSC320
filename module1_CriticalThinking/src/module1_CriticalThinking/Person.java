package module1_CriticalThinking;

public class Person {
	String firstName;
	String lastName;
	String streetAddress;
	String city;
	String zipCode;
	
	Person(String firstName, String lastName, String streetAddress, String city, String zipCode) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.streetAddress = streetAddress;
		this.city = city;
		this.zipCode = zipCode;
	}
	
	void printInfo() {
		System.out.println("First Name: " + firstName);
		System.out.println("Last Name: " + lastName);
		System.out.println("Street Address: " + streetAddress);
		System.out.println("City: " + city);
		System.out.println("Zip Codee: " + zipCode);
	}
}

class Main {
	public static void main(String[] args) {
		Person person = new Person("Lex", "Luther", "1835 Park Ridge Lane", "Metropolis", "33862");
		person.printInfo();
	}
}
