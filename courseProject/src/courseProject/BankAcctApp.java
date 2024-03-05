package courseProject;
import java.security.spec.ECField;
import java.util.Date;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class BankAcctApp extends JFrame implements ActionListener {
	static Customer c;
	static Account a;

	static ArrayList<Customer> customers = new ArrayList<Customer>();
	static ArrayList<Account> accounts = new ArrayList<Account>();

	JButton addButton;
	JButton displayButton;
	JButton clearButton;
	JButton addTransaction;
	JButton clearButton2;
	JButton addInterest;

	JLabel status;
	JTextField idField;
	JTextField ssnField;
	JTextField lastNameField;
	JTextField firstNameField;
	JTextField streetField;
	JTextField cityField;
	JTextField zipField;
	JTextField phoneField;

	JComboBox<String> statesDropdown;
	JTextField accountNumberField;
	JRadioButton checkingRadio;
	JRadioButton savingsRadio;

	JLabel transactionStatus;
	JTextField idFieldTransaction;
	JTextField accountNumberFieldTransaction;
	JTextField transactionDate;
	JTextField transactionAmountField;
	JRadioButton depositRadio;
	JRadioButton withdrawRadio;

	JPanel transactionPane;
	GridBagLayout gridbag;

	public BankAcctApp() {
		super("Bank Account App");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(530, 500);
		setLocationRelativeTo(null);
		JPanel acctsMainPane = new JPanel();
		BoxLayout boxY = new BoxLayout(acctsMainPane,BoxLayout.Y_AXIS);
		acctsMainPane.setLayout(boxY);

		//Customer and Accounts pane
		JPanel customerPane = new JPanel();
		customerPane.setLayout(new FlowLayout(FlowLayout.RIGHT));

		JLabel idLabel = new JLabel("Customer ID (max length 5, not blank):  ");
		idField = new JTextField(15);
		JLabel ssnLabel = new JLabel("SSN (9 characters, non-blank, numbers only):  ");
		ssnField = new JTextField(15);
		JLabel lastNameLabel = new JLabel("Last Name (max length 20, not blank):  ");
		lastNameField = new JTextField(15);
		JLabel firstNameLabel = new JLabel("First Name (max length 15, not blank):  ");
		firstNameField = new JTextField(15);
		JLabel streetLabel = new JLabel("Street (max length 20, not blank):  ");
		streetField = new JTextField(15);
		JLabel cityLabel = new JLabel("City (max length 20, not blank):  ");
		cityField = new JTextField(15);
		JLabel zipLabel = new JLabel("Zip (5 characters, not blank, numbers only):  ");
		zipField = new JTextField(15);
		JLabel phoneLabel = new JLabel("Phone (10 characters, numbers only, no punctuation):  ");
		phoneField = new JTextField(15);
		JLabel stateLabel = new JLabel("State (2 characters, not blank):                                          ");
		String[] states = { "KY", "OH", "IN", "VA", "WV" };
		statesDropdown = new JComboBox<>(states);
		JLabel accountNumberLabel = new JLabel("Account Number (string max 5, not blank):  ");
		accountNumberField = new JTextField(15);
		JLabel accountTypeLabel = new JLabel("Account Type:       ");
		ButtonGroup accountTypeRadios = new ButtonGroup();
		checkingRadio = new JRadioButton("Checking");
		checkingRadio.setSelected(true);
		savingsRadio = new JRadioButton("Savings");
		accountTypeRadios.add(checkingRadio);
		accountTypeRadios.add(savingsRadio);

		JPanel acctsButtonPane = new JPanel();
		acctsButtonPane.setLayout(new BoxLayout(acctsButtonPane, BoxLayout.Y_AXIS));
		addButton = new JButton("Add New Customer and Account");
		addButton.addActionListener(this);
		displayButton = new JButton("Display Customer and Account Data");
		displayButton.addActionListener(this);
		clearButton = new JButton("Clear");
		clearButton.addActionListener(this);
		status = new JLabel("Input Status");

		customerPane.add(idLabel);
		customerPane.add(idField);
		customerPane.add(ssnLabel);
		customerPane.add(ssnField);
		customerPane.add(lastNameLabel);
		customerPane.add(lastNameField);
		customerPane.add(firstNameLabel);
		customerPane.add(firstNameField);
		customerPane.add(streetLabel);
		customerPane.add(streetField);
		customerPane.add(cityLabel);
		customerPane.add(cityField);
		customerPane.add(stateLabel);
		customerPane.add(statesDropdown);
		customerPane.add(zipLabel);
		customerPane.add(zipField);
		customerPane.add(phoneLabel);
		customerPane.add(phoneField);
		customerPane.add(accountNumberLabel);
		customerPane.add(accountNumberField);
		customerPane.add(accountTypeLabel);
		customerPane.add(checkingRadio);
		customerPane.add(savingsRadio);

		acctsButtonPane.add(addButton);
		acctsButtonPane.add(displayButton);
		acctsButtonPane.add(clearButton);
		acctsButtonPane.add(status);

		acctsMainPane.add(customerPane);
		acctsMainPane.add(acctsButtonPane);

		//Transaction Pane
		transactionPane = new JPanel();
		gridbag = new GridBagLayout();
		GridBagConstraints constraints;
		transactionPane.setLayout(gridbag);

		JLabel idLabelTransaction = new JLabel("Customer ID:  ");
		idFieldTransaction = new JTextField(15);
		JLabel accountNumberLabelTransaction = new JLabel("Account Number:  ");
		accountNumberFieldTransaction = new JTextField(15);
		JLabel transactionDateLabel = new JLabel("Transaction Date:  ");
		transactionDate = new JTextField(15);
		JLabel transactionAmountLabel = new JLabel("Transaction Amount:  ");
		transactionAmountField = new JTextField(15);
		JLabel transactionTypeLabel = new JLabel("Transaction Type:  ");
		ButtonGroup transactionTypeRadio = new ButtonGroup();
		depositRadio = new JRadioButton("Deposit");
		withdrawRadio = new JRadioButton("Withdraw");
		transactionTypeRadio.add(depositRadio);
		transactionTypeRadio.add(withdrawRadio);
		transactionStatus = new JLabel("Transaction Status");

		addTransaction = new JButton("Perform Transaction");
		addTransaction.addActionListener(this);
		clearButton2 = new JButton("Clear");
		clearButton2.addActionListener(this);
		addInterest = new JButton("Add Interest");
		addInterest.addActionListener(this);

		int east = GridBagConstraints.EAST;
		int west = GridBagConstraints.WEST;
		int center = GridBagConstraints.CENTER;
		addComponent(idLabelTransaction,0,0,1,1,10,100,0,east);
		addComponent(idFieldTransaction,1,0,9,1,90,100,0,west);
		addComponent(accountNumberLabelTransaction,0,1,1,1,10,100,0,east);
		addComponent(accountNumberFieldTransaction,1,1,9,1,90,100,0,west);
		addComponent(transactionDateLabel,0,2,1,1,10,100,0,east);
		addComponent(transactionDate,1,2,9,1,90,100,0,west);
		addComponent(transactionAmountLabel,0,3,1,1,10,100,0,east);
		addComponent(transactionAmountField,1,3,9,1,90,100,0,west);
		addComponent(transactionTypeLabel,0,4,1,1,10,100,0,east);
		addComponent(depositRadio,1,4,1,1,10,100,0,center);
		addComponent(withdrawRadio,2,4,1,1,10,100,0,west);
		addComponent(addTransaction,0,5,2,1,10,100,0,center);
		addComponent(addInterest,1,5,2,1,10,100,0,center);
		addComponent(clearButton2,2,5,2,1,10,100,0,center);
		addComponent(transactionStatus,0,6,10,1,100,100,0,center);


		JTabbedPane tabs = new JTabbedPane();
		tabs.addTab("Customer & Account", acctsMainPane);
		tabs.addTab("Transaction", transactionPane);

		add(tabs);
		setVisible(true);
	}
	private void addComponent(Component component, int gridx, int gridy,
							  int gridwidth, int gridheight, int weightx, int weighty, int fill,
							  int anchor) {

		GridBagConstraints constraints = new GridBagConstraints();
		constraints.gridx = gridx;
		constraints.gridy = gridy;
		constraints.gridwidth = gridwidth;
		constraints.gridheight = gridheight;
		constraints.weightx = weightx;
		constraints.weighty = weighty;
		constraints.fill = fill;
		constraints.anchor = anchor;
		gridbag.setConstraints(component, constraints);
		transactionPane.add(component);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		//add Account and Customer
		if(source == addButton) {
			try {
				c = new Customer();
				a = new SavingsAccount();

				DataEntry.enterStringWithLimits(c, "id", idField.getText(),1, 5);
				DataEntry.enterStringWithLimits(c, "ssn", ssnField.getText(), 9, 9);
				DataEntry.enterStringWithLimits(c, "lastName", lastNameField.getText(), 1, 20);
				DataEntry.enterStringWithLimits(c, "firstName", firstNameField.getText(), 1, 15);
				DataEntry.enterStringWithLimits(c, "street", streetField.getText(), 1, 20);
				DataEntry.enterStringWithLimits(c, "city", cityField.getText(), 1, 20);
				DataEntry.enterStringWithLimits(c, "state", statesDropdown.getSelectedItem().toString(), 2, 2);
				DataEntry.enterStringWithLimits(c, "zip", zipField.getText(), 5, 5);
				DataEntry.enterStringWithLimits(c, "phone", phoneField.getText(), 10, 10);

				//add customer to ArrayList
				customers.add(c);

				if (savingsRadio.isSelected()) {
					a = new SavingsAccount();
				}
				else if (checkingRadio.isSelected()) {
					a = new CheckingAccount();
				}

				DataEntry.enterStringWithLimits(a,"number", accountNumberField.getText(), 1, 5);

				//add account to ArrayList
				accounts.add(a);
				//add an account to given Customer's list of accounts
				c.addAccount(a.getAccountNumber());
				//set account holder id on given Account
				a.setAccountHolder(c.getId());

				status.setText("Success!");
			} catch (Exception ex) {
				status.setText("Input Error, try again.");
			}
		}
		else if (source == displayButton) {
			//display account details
			JOptionPane.showMessageDialog(null,c + "\n" + a, "", JOptionPane.PLAIN_MESSAGE);
		}
		else if (source == clearButton) {
			status.setText("Input Status");
			idField.setText("");
			ssnField.setText("");
			lastNameField.setText("");
			firstNameField.setText("");
			streetField.setText("");
			cityField.setText("");
			zipField.setText("");
			phoneField.setText("");
			statesDropdown.setSelectedIndex(0);
			accountNumberField.setText("");
		}
		else if (source == clearButton2) {
			transactionStatus.setText("Transaction Status");
			idFieldTransaction.setText("");
			accountNumberFieldTransaction.setText("");
			transactionDate.setText("");
			transactionAmountField.setText("");
		}
		//add transaction
		else if (source == addTransaction) {
			String date = transactionDate.getText();
			Date currentDate = null;
			String account = accountNumberFieldTransaction.getText();
			Account currentAccount = null;
			double transactionAmount = 0;
			Customer currentCustomer = null;

			try {
				//Which Customer
				boolean customerExists = false;
				for (Customer customer : customers) {
					if (customer.getId().equals(idFieldTransaction.getText())) {
						customerExists = true;
						currentCustomer = customer;
						break;
					}
				}
				if (!customerExists) {
					throw new NoSuchElementException("Customer does not exist, try again.");
				}

				//which account of customer
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
					throw new NoSuchElementException("Customer has no such account, try again.");
				}

				//transaction date
				if (!DataEntry.isCorrectDateFormat(date)) {
					throw new RuntimeException("Incorrect date format, try again.");
				}
				currentDate = DataEntry.formatDate(date);

				//transaction amount

				if (!DataEntry.isNumericString(transactionAmountField.getText())) {
					throw new RuntimeException("Transaction amount must be a number.");
				}
				transactionAmount = Double.parseDouble(transactionAmountField.getText());
				if(transactionAmount < 0) {
					throw new RuntimeException("Transaction amount must be positive number.");

				}

				//process transaction
				if (withdrawRadio.isSelected()) {
					currentAccount.withdrawal(transactionAmount, currentDate);
				} else if (depositRadio.isSelected()){
					currentAccount.deposit(transactionAmount, currentDate);
				} else {
					throw new RuntimeException("Must select transaction type");
				}

			} catch (Exception ex) {
				transactionStatus.setText(ex.getMessage());
			}
			transactionStatus.setText("Success!");

		}
		//add interest
		else if (source == addInterest) {
			//add interest
			Account currentAccount = null;
			try	{
				for (Account acct : accounts) {
					if (acct.getAccountNumber().equals(accountNumberFieldTransaction.getText())) {
						currentAccount = acct;
						break;
					}

				}
				currentAccount.addInterest();
				JOptionPane.showMessageDialog(null, "New account balance:  " + currentAccount.getBalance(), "Interest Added", JOptionPane.PLAIN_MESSAGE);

			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null,"Error, interest not added.","Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	public static void main(String[] args) {
		BankAcctApp GUI = new BankAcctApp();
	}
}
