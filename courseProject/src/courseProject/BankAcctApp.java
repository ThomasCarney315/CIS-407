package courseProject;
import java.util.Date;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.ArrayList;
public class BankAcctApp {

	public static void main(String[] args) {
		char sentinal = 'Y';
		ArrayList<Customer> customers = new ArrayList<Customer>();
		ArrayList<Account> accounts = new ArrayList<Account>();
		Scanner input = new Scanner(System.in);

		//Adding Customers
		while (Character.toUpperCase(sentinal) == 'Y') {
			boolean entered = false;

			System.out.println("Add a Customer\n\n");
			Customer c = new Customer();
			//enterStringWithLimits(Customer, field, Scanner, min, limit, condition string--optional)
			//enterIntegerWithinRange(Customer, field, Scanner, min, max, condition string--optional)
			do {
				try {
					entered = DataEntry.enterStringWithLimits(c, "id", input, 1, 5, "(max length 5, not blank)");
				}
				catch (Exception e) {
					System.out.println("Input Error, try again.");
					entered = false;
				}
			} while (!entered);
			do {
				try {
					entered = DataEntry.enterStringWithLimits(c, "ssn", input, 9, 9, "(9 characters, non-blank, numbers only)");
				}
				catch (Exception e) {
					System.out.println("Input Error, try again.");
					entered = false;
				}
			} while (!entered);
			do {
				try {
					entered = DataEntry.enterStringWithLimits(c, "lastName", input, 1, 20, "(max length 20, not blank)");
				}
				catch (Exception e) {
					System.out.println("Input Error, try again.");
					entered = false;
				}
			} while (!entered);
			do {
				try {
					entered = DataEntry.enterStringWithLimits(c, "firstName", input, 1, 15, "(max length 15, not blank)");
				}
				catch (Exception e) {
					System.out.println("Input Error, try again.");
					entered = false;
				}
			} while (!entered);
			do {
				try {
					entered = DataEntry.enterStringWithLimits(c, "street", input, 1, 20, "(max length 20, not blank)");
				}
				catch (Exception e) {
					System.out.println("Input Error, try again.");
					entered = false;
				}
			} while (!entered);
			do {
				try {
					entered = DataEntry.enterStringWithLimits(c, "city", input, 1, 20, "(max length 20, not blank)");
				}
				catch (Exception e) {
					System.out.println("Input Error, try again.");
					entered = false;
				}
			} while (!entered);
			do {
				try {
					entered = DataEntry.enterStringWithLimits(c, "state", input, 2, 2, "(2 characters, not blank)");
				}
				catch (Exception e) {
					System.out.println("Input Error, try again.");
					entered = false;
				}
			} while (!entered);
			do {
				try {
					entered = DataEntry.enterStringWithLimits(c, "zip", input, 5, 5, "(5 characters, not blank, numbers only)");
				}
				catch (Exception e) {
					System.out.println("Input Error, try again.");
					entered = false;
				}
			} while (!entered);
			do {
				try {
					entered = DataEntry.enterStringWithLimits(c, "phone", input, 10, 10, "(10 characters, numbers only, no punctuation)" );
				}
				catch (Exception e) {
					System.out.println("Input Error, try again.");
					entered = false;
				}
			} while (!entered);
			//add customer to ArrayList
			customers.add(c);
			System.out.println(c);

			System.out.print("Add another customer? (y/n):  ");
			sentinal = input.next().charAt(0);
			String x = input.nextLine();
		}

		//Adding accounts
		sentinal = 'Y';
		while (Character.toUpperCase(sentinal) == 'Y') {
			System.out.println("\nAdd an Account\n\n");
			Account a = new SavingsAccount();
			boolean entered = false;
			String id = "#";
			Customer currentCustomer = new Customer();

			//For which customer
			do {
				try {
					System.out.print("Enter customer id:  ");
					id = input.nextLine();
					boolean customerExists = false;
					for (Customer customer : customers) {
						if (customer.getId().equals(id)) {
							customerExists = true;
							currentCustomer = customer;
							break;
						}
					}
					if (!customerExists) {
						throw new NoSuchElementException();
					}
					entered = true;
				}catch (NoSuchElementException e) {
					System.out.println("Customer does not exist, try again.");
					entered = false;
				}
				catch (Exception e) {
					System.out.println("Input Error, try again.");
					entered = false;
				}
			} while (!entered);
			//Which account type
			do {
				try {
					System.out.print("Enter account type (CHK or SAV):  ");
					String type = input.nextLine().toUpperCase();
					if(type.equals("CHK")) {
						a = new CheckingAccount();
					}
					else if(type.equals("SAV")) {
						a = new SavingsAccount();
					}
					else {
						throw new RuntimeException();
					}
					entered = true;
				} catch (Exception e) {
					System.out.println("Input Error, try again.");
					entered = false;
				}
			} while (!entered);
			//Account number
			do {
				try {
					entered = DataEntry.enterStringWithLimits(a,"number", input, 1, 5, "(string max 5)");
				} catch (Exception e) {
					System.out.println("Input Error, try again.");
					entered = false;
				}
			} while (!entered);
			//add account to ArrayList
			accounts.add(a);
			//add an account to given Customer's list of accounts
			currentCustomer.addAccount(a.getAccountNumber());
			//set account holder id on given Account
			a.setAccountHolder(id);
			//display account details
			System.out.println(a);

			System.out.print("Add another account? (y/n):  ");
			sentinal = input.next().charAt(0);
			String x = input.nextLine();
		}

		//Transactions
		sentinal = 'Y';
		while (Character.toUpperCase(sentinal) == 'Y') {
			System.out.println("\nConduct a Transaction\n\n");
			boolean entered = false;
			String id;
			String date;
			Date currentDate = null;
			String account;
			Account currentAccount = null;
			String transactionType = null;
			double transactionAmount = 0;
			Customer currentCustomer = null;
			//Which customer
			do {
				try {
					System.out.print("Enter customer id:  ");
					id = input.nextLine();
					boolean customerExists = false;
					for (Customer customer : customers) {
						if (customer.getId().equals(id)) {
							customerExists = true;
							currentCustomer = customer;
							break;
						}
					}
					if (!customerExists) {
						throw new NoSuchElementException();
					}
					entered = true;
				}catch (NoSuchElementException e) {
					System.out.println("Customer does not exist, try again.");
					entered = false;
				}
				catch (Exception e) {
					System.out.println("Input Error, try again.");
					entered = false;
				}
			} while (!entered);
			//which account of customer
			do {
				try {
					System.out.print("Enter account number:  ");
					account = input.nextLine();
					boolean customerHasAccount = false;

					ArrayList<String> customerAccounts = currentCustomer.getAccounts();

					for (String acct : customerAccounts) {
						if (acct.equals(account)) {
							customerHasAccount = true;
							for (Account a : accounts) {
								if (a.getAccountNumber().equals(account)) {
									currentAccount = a;
								}
							}
							break;
						}
					}
					if (!customerHasAccount) {
						throw new NoSuchElementException();
					}
					entered = true;
				}catch (NoSuchElementException e) {
					System.out.println("Customer has no such account, try again.");
					entered = false;
				}
				catch (Exception e) {
					System.out.println("Input Error, try again.");
					entered = false;
				}
			} while (!entered);
			//loop for transactions on chosen account
			String keepTransacting = "y";
			while (keepTransacting.equalsIgnoreCase("y")) {
				//date of transaction
				do {
					try {
						System.out.print("Enter current date(MM/dd/yyyy):  ");
						date = input.nextLine();
						if (!DataEntry.isCorrectDateFormat(date)) {
							throw new RuntimeException();
						}
						currentDate = DataEntry.formatDate(date);
						entered = true;
					} catch (Exception e) {
						System.out.println("Incorrect date format, try again.");
						entered = false;
					}
				} while (!entered);
				//transaction type
				do {
					try {
						System.out.print("Enter transaction type (DEP or WTH):  ");
						transactionType = input.nextLine().toUpperCase();
						if(!(transactionType.equals("DEP") || transactionType.equals("WTH"))) {
							throw new RuntimeException();
						}
						entered = true;
					} catch (Exception e) {
						System.out.println("Input Error, try again.");
						entered = false;
					}
				} while (!entered);
				//transaction amount
				do {
					try {
						System.out.print("Enter transaction amount:  ");
						transactionAmount = Double.parseDouble(input.nextLine());
						if(transactionAmount < 0) {
							throw new RuntimeException();
						}
						entered = true;
					} catch (Exception e) {
						System.out.println("Input Error, try again.");
						entered = false;
					}
				} while (!entered);
				//process transaction
				if (transactionType.equals("WTH")) {
					currentAccount.withdrawal(transactionAmount, currentDate);
				} else {
					currentAccount.deposit(transactionAmount, currentDate);
				}

				System.out.print("Would you like to conduct another transaction for this account (y/n):  ");
				keepTransacting = input.nextLine();
			}
			//add interest?
			do {
				try	{
					System.out.print("Add interest to account? (y/n):  ");
					String answer = input.nextLine().toLowerCase();
					if(answer.equals("y")) {
						currentAccount.addInterest();
						System.out.println("New account balance:  " + currentAccount.getBalance());
					}
					else if(!answer.equals("n")) {
						throw new RuntimeException();
					}
					entered = true;
				}
				catch (Exception e) {
					System.out.println("Input Error, try again.");
					entered = false;
				}
			} while (!entered);

			System.out.print("Conduct another transaction? (y/n):  ");
			sentinal = input.next().charAt(0);
			String x = input.nextLine();
		}

		input.close();
		System.out.println("\nGoodbye");

	}
	
}
