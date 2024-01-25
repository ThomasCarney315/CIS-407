package courseProject;
import java.util.Scanner;
import java.util.ArrayList;
public class BankAcctApp {

	public static void main(String[] args) {
		char sentinal = 'Y';
		ArrayList<Customer> customers = new ArrayList<Customer>();
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
			
			System.out.println("Add a Customer\n\n");
			Customer c = new Customer();
			//enterStringWithLimits(Customer, field, Scanner, min, limit, condition string--optional)
			//enterIntegerWithinRange(Customer, field, Scanner, min, max, condition string--optional)
			do {
				entered = DataEntry.enterStringWithLimits(c, id, input, 1, 5, "(max length 5, not blank)");
			} while (!entered);
			do {
				entered = DataEntry.enterStringWithLimits(c, ssn, input, 9, 9, "(9 characters, non-blank, numbers only)");
			} while (!entered);
			do {
				entered = DataEntry.enterStringWithLimits(c, lastName, input, 1, 20, "max length 20, not blank");
			} while (!entered);
			do {
				entered = DataEntry.enterStringWithLimits(c, firstName, input, 1, 15, "max length 15, not blank");
			} while (!entered);
			do {
				entered = DataEntry.enterStringWithLimits(c, street, input, 1, 20, "max length 20, not blank");
			} while (!entered);
			do {
				entered = DataEntry.enterStringWithLimits(c, city, input, 1, 20, "max length 20, not blank");
			} while (!entered);
			do {
				entered = DataEntry.enterStringWithLimits(c, state, input, 2, 2, "2 characters, not blank");
			} while (!entered);
			do {
				entered = DataEntry.enterStringWithLimits(c, zip, input, 5, 5, "5 characters, not blank, numbers only");
			} while (!entered);
			do {
				entered = DataEntry.enterStringWithLimits(c, phone, input, 10, 10, "10 characters, numbers only, no punctuation" );
			} while (!entered);
			
			customers.add(c);
			
			System.out.println( "        ID:  " + c.getId());
			System.out.println( "       SSN:  " + c.getSsn());
			System.out.println( " Last Name:  " + c.getLastName());
			System.out.println( "First Name:  " + c.getFirstName());
			System.out.println( "    Street:  " + c.getStreet());
			System.out.println( "      City:  " + c.getCity());
			System.out.println( "     State:  " + c.getState());
			System.out.println( "       Zip:  " + c.getZip());
			System.out.println( "     Phone:  " + c.getPhone());
			
			System.out.print("Add another customer? (y/n):  ");
			sentinal = input.next().charAt(0);
			String x = input.nextLine();
		}
		//print array of customers to demonstrate Customer.toString()
		System.out.println(customers);
		
		input.close();
		System.out.println("Goodbye");

	}
	
}
