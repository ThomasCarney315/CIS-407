package courseProject;
import java.util.Scanner;
public class BankAcctApp {

	public static void main(String[] args) {
		char sentinal = 'Y';
		Scanner input = new Scanner(System.in);
		
		while (Character.toUpperCase(sentinal) == 'Y') {
			String id = "id";
			String ssn = "ssn";
			String lastName = "lastName";
			String firstName = "firstName";
			String street = "street";
			String city = "city";
			String state = "state";
			String zip = "zip";
			String phone = "phone";
			
			boolean entered = false;
			
			System.out.println("Add 2 Customers\n\n");
			
			Customer c3 = new Customer();
			//enterStringWithLimit(Customer c,  String field, Scanner input, int min,  int limit)
			do {
				entered = DataEntry.enterStringWithLimit(c3, id, input, 1, 5);
			} while (!entered);
			do {
				entered = DataEntry.enterStringWithLimit(c3, ssn, input, 9, 9);
			} while (!entered);
			do {
				entered = DataEntry.enterString(c3, lastName, input);
			} while (!entered);
			do {
				entered = DataEntry.enterString(c3, firstName, input);
			} while (!entered);
			do {
				entered = DataEntry.enterString(c3, street, input);
			} while (!entered);
			do {
				entered = DataEntry.enterString(c3, city, input);
			} while (!entered);
			do {
				entered = DataEntry.enterString(c3, state, input);
			} while (!entered);
			//do {
			//	entered = DataEntry.enterInterger(c3, zip, input);
			//} while (!entered);
			do {
				entered = DataEntry.enterString(c3, phone, input);
			} while (!entered);
			
			System.out.print("Add another customer? (y/n):  ");
			sentinal = input.next().charAt(0);
			String x = input.nextLine();
			
		}
		
		input.close();
		System.out.println("Goodbye");

	}
	
}
