package courseProject;
import java.util.Scanner;
public class BankAcctApp {

	public static void main(String[] args) {
		char sentinal = 'Y';
		Scanner input = new Scanner(System.in);
		
		while (Character.toUpperCase(sentinal) == 'Y') {
			String id = null;
			System.out.println("Add Customer\n\n");
			System.out.print("Enter Customer ID:  ");
			id = input.nextLine();
			while (!DataEntry.isStringWithinLimit(id, 3)) {
				id = input.nextLine();
			}
			
			
			Customer c1 = new Customer(id, "4041221234", "Carney", "Thomas", "Main St.", "Coolville", "CO", 41071, "9234565555");
			System.out.println(c1.toString());
			
			System.out.println(DataEntry.isStringNoLimit("t"));
			System.out.println(DataEntry.isStringWithinLimit(1, 3));
			System.out.println(DataEntry.isStringWithinLimit("ttt", 3));
			System.out.println(DataEntry.isNumericString("9234565555"));
			
			System.out.print("Add another customer? (y/n):  ");
			sentinal = input.next().charAt(0);
			String x = input.nextLine();
		}
		
		input.close();

	}
	
}
