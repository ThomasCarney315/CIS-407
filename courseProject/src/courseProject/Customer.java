package courseProject;

import java.util.ArrayList;

public class Customer {
	//instance variables
	private String id;
	private String ssn;
	private String lastName;
	private String firstName;
	private String street;
	private String city;
	private String state;
	private Integer zip;
	private String phone;
	private ArrayList<String> accounts = new ArrayList<String>();
	//constructor for initializing with values
	public Customer(String id, String ssn, String lastName, String firstName,
					String street, String city, String state,
					Integer zip, String phone) {
		this.id = id;
		this.ssn = ssn;
		this.lastName = lastName;
		this.firstName = firstName;
		this.street = street;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.phone = phone;
	}
	//constructor for initializing a blank customer instance
	public Customer() {
		
	}
	public void addAccount(String id) {
		accounts.add(id);
	}
	//setters
	public void setId(String id) {
		this.id = id;
	}
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName ;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public void setCity(String val) {
		this.city = val;
	}
	public void setState(String val) {
		this.state = val;
	}
	public void setZip(int val) {
		this.zip = val;
	}
	public void setPhone(String val) {
		this.phone = val;
	}
	//getters
	public String getId() {
		return this.id;
	}
	public String getSsn() {
		return this.ssn;
	}
	public String getLastName() {
		return this.lastName;
	}
	public String getFirstName() {
		return this.firstName;
	}
	public String getStreet() {
		return this.street;
	}
	public String getCity() {
		return this.city;
	}
	public String getState() {
		return this.state;
	}
	public Integer getZip() {
		return this.zip;
	}
	public String getPhone() {
		return this.phone;
	}
	public ArrayList<String> getAccounts() {
		return accounts;
	}
	//toString method
	public String toString() {
		String res = String.format("Customer Details:\n\n"
				+ "        ID:  %s\n"
				+ "       SSN:  %s\n"
				+ " Last Name:  %s\n"
				+ "First Name:  %s\n"
				+ "    Street:  %s\n"
				+ "      City:  %s\n"
				+ "     State:  %s\n"
				+ "       Zip:  %s\n"
				+ "     Phone:  %s\n",id, ssn, lastName, firstName, street, city, state, zip, phone);
		return res;
	}
}
