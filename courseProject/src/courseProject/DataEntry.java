package courseProject;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
public class DataEntry {
	//methods for entering string without validation conditions
	static public boolean enterString(Customer c,  String field, Scanner input) throws Exception {
		System.out.print("Enter customer " + field +":  ");
		String val = input.nextLine();
		if (!isStringNoLimit(val)) {
			throw new Exception("Invalid input.");
		}
		if (field == "id") {c.setId(val);}
		else if(field == "ssn") {
			if(!isNumericString(val)) {
				throw new Exception("Invalid input.");
			}
			c.setSsn(val);
		} 	
		else if(field == "lastName") {c.setLastName(val);}
		else if(field == "firstName") {c.setFirstName(val);}
		else if(field == "street") {c.setStreet(val);}
		else if(field == "city") {c.setCity(val);}
		else if(field == "state") {c.setState(val);}
		else if(field == "zip") {
			if(!isNumericString(val)) {
				throw new Exception("Invalid input.");
			}
			c.setZip(Integer.parseInt(val));
			}
		else if(field == "phone") {
			if(!isNumericString(val)) {
				throw new Exception("Invalid input.");
			}
			c.setPhone(val);
			}
		
		return true;
	}
	static public boolean enterString(Account c,  String field, Scanner input) throws Exception {
		System.out.print("Enter account " + field +":  ");
		String val = input.nextLine();
		if (!isStringNoLimit(val)) {
			throw new Exception("Invalid input.");
		}
		if (field == "number") {c.setAccountNumber(val);}
		else if(field == "type") {
			if (val.equals("CHK") || val.equals("SAV")) {
				c.setAccountType(val);
			}
			else {
				throw new Exception("Invalid input.");
			}
		}
		return true;
	}
	//methods for entering string with validation conditions
	static public boolean enterStringWithLimits(Customer c,  String field, Scanner input, int min,  int limit) throws Exception {
		System.out.print("Enter customer " + field + ":  ");
		String val = input.nextLine();
		if (!isStringWithinLimits(val, min, limit)) {
			throw new Exception("Invalid input.");
		}
		if (field == "id") {c.setId(val);}
		else if(field == "ssn") {
			if(!isNumericString(val)) {
				throw new Exception("Invalid input.");
			}
			c.setSsn(val);
		}
		else if(field == "lastName") {c.setLastName(val);}
		else if(field == "firstName") {c.setFirstName(val);}
		else if(field == "street") {c.setStreet(val);}
		else if(field == "city") {c.setCity(val);}
		else if(field == "state") {c.setState(val);}
		else if(field == "zip") {
			if(!isNumericString(val)) {
				throw new Exception("Invalid input.");
			}
			c.setZip(Integer.parseInt(val));
			}
		else if(field == "phone") {
			if(!isNumericString(val)) {
				throw new Exception("Invalid input.");
			}
			c.setPhone(val);
			}
		return true;
	}
	static public boolean enterStringWithLimits(Account c,  String field, Scanner input, int min,  int limit) throws Exception {
		System.out.print("Enter account " + field + ":  ");
		String val = input.nextLine();
		if (!isStringWithinLimits(val, min, limit)) {
			throw new Exception("Invalid input.");
		}
		if (field == "number") {c.setAccountNumber(val);}
		else if(field == "type") {
			if (val.equals("CHK") || val.equals("SAV")) {
				c.setAccountType(val);
			}
			else {
				throw new Exception("Invalid input.");
			}
		}
		return true;
	}
	//overrides for entering string with validation conditions and conditions-description
	static public boolean enterStringWithLimits(Customer c,  String field, Scanner input, int min,  int limit, String conditionStr) throws Exception {
		System.out.print("Enter customer " + field + " "+ conditionStr +":  ");
		String val = input.nextLine();
		if (!isStringWithinLimits(val, min, limit)) {
			throw new Exception(conditionStr);
		}
		if (field == "id") {c.setId(val);}
		else if(field == "ssn") {
			if(!isNumericString(val)) {
				throw new Exception(conditionStr);
			}
			c.setSsn(val);
		}
		else if(field == "lastName") {c.setLastName(val);}
		else if(field == "firstName") {c.setFirstName(val);}
		else if(field == "street") {c.setStreet(val);}
		else if(field == "city") {c.setCity(val);}
		else if(field == "state") {c.setState(val);}
		else if(field == "zip") {
			if(!isNumericString(val)) {
				throw new Exception(conditionStr);
			}
			c.setZip(Integer.parseInt(val));
			}
		else if(field == "phone") {
			if(!isNumericString(val)) {
				throw new Exception(conditionStr);
			}
			c.setPhone(val);
			}
		return true;
	}
	static public boolean enterStringWithLimits(Account c,  String field, Scanner input, int min,  int limit, String conditionStr) throws Exception {
		System.out.print("Enter account " + field + " "+ conditionStr +":  ");
		String val = input.nextLine();
		if (!isStringWithinLimits(val, min, limit)) {
			throw new Exception(conditionStr);
		}
		if (field == "number") {c.setAccountNumber(val);}
		else if(field == "type") {
			if (val.equals("CHK") || val.equals("SAV")) {
				c.setAccountType(val);
			}
			else {
				throw new Exception(conditionStr);
			}
		}
		return true;
	}
	//method for entering integer
	static public boolean enterInteger(Customer c, String field, Scanner input) throws Exception {
		System.out.print("Enter customer " + field +":  ");
		int val;
		try {
			val = Integer.parseInt(input.nextLine());
		}catch (Exception e) {
			throw new Exception("Invalid input.");
		}
		if (!isInteger(val)) {
			throw new Exception("Invalid input.");
		}
		if (field == "zip") {c.setZip(val);}
		return true;
	}
	//method for entering integer within range
	static public boolean enterIntegerWithinRange(Customer c, String field, Scanner input, int min, int max) throws Exception {
		System.out.print("Enter customer " + field +":  ");
		int val;
		try {
			val = Integer.parseInt(input.nextLine());
		}catch (Exception e) {
			throw new Exception("Invalid input.");
		}
		if (!isIntegerWithinRange(val, min, max) ) {
			throw new Exception("Invalid input.");
		}
		if (field == "zip") {c.setZip(val);}
		return true;
	}
	//method for entering integer within range and condition-description
	static public boolean enterIntegerWithinRange(Customer c, String field, Scanner input, int min, int max, String conditionStr) throws Exception {
		System.out.print("Enter customer " + field + " "+ conditionStr +":  ");
		int val;
		try {
			val = Integer.parseInt(input.nextLine());
		}catch (Exception e) {
			throw new Exception(conditionStr);
		}
		if (!isIntegerWithinRange(val, min, max) ) {
			throw new Exception(conditionStr);
		}
		if (field == "zip") {c.setZip(val);}
		return true;
	}
	//method for entering decimal data
	static public boolean enterDecimal(Account a, String field, Scanner input) throws Exception {
		System.out.print("Enter account " + field +":  ");
		double val;
		try {
			val = Double.parseDouble(input.nextLine());
		}catch (Exception e) {
			throw new Exception("Invalid input.");
		}
		if (!isDecimal(val)) {
			throw new Exception("Invalid input.");
		}
		if (field == "serviceFee") {
			a.setServiceFee(val);
		}
		else if (field == "interestRate") {
			a.setInterestRate(val);
		}
		else if (field == "overdraftFee") {
			a.setOverdraftFee(val);
		}
		else if (field == "balance") {
			a.setBalance(val);
		}
		return true;
	}
	//method for entering decimal data within range
	static public boolean enterDecimalWithinRange(Account a, String field, Scanner input, double min, double max) throws Exception {
		System.out.print("Enter account " + field +":  ");
		double val;
		try {
			val = Double.parseDouble(input.nextLine());
		}catch (Exception e) {
			throw new Exception("Invalid input.");
		}
		if (!isDecimalWithinRange(val, min, max) ) {
			throw new Exception("Invalid input.");
		}
		if (field == "serviceFee") {
			a.setServiceFee(val);
		}
		else if (field == "interestRate") {
			a.setInterestRate(val);
		}
		else if (field == "overdraftFee") {
			a.setOverdraftFee(val);
		}
		else if (field == "balance") {
			a.setBalance(val);
		}
		return true;
	}
	//method for entering decimal data within range and condition-description
	static public boolean enterDecimalWithinRange(Account a, String field, Scanner input, double min, double max, String conditionStr) throws Exception {
		System.out.print("Enter account " + field + " "+ conditionStr +":  ");
		double val;
		try {
			val = Double.parseDouble(input.nextLine());
		}catch (Exception e) {
			throw new Exception(conditionStr);
		}
		if (!isDecimalWithinRange(val, min, max) ) {
			throw new Exception(conditionStr);
		}
		if (field == "serviceFee") {
			a.setServiceFee(val);
		}
		else if (field == "interestRate") {
			a.setInterestRate(val);
		}
		else if (field == "overdraftFee") {
			a.setOverdraftFee(val);
		}
		else if (field == "balance") {
			a.setBalance(val);
		}
		return true;
	}
	//method to validate is string 
	static public boolean isStringNoLimit(Object str) {
		return str instanceof String;
	}
	//method to validate is string within limits
	static public boolean isStringWithinLimits(Object str, int min, int limit) {
		return (isStringNoLimit(str) && ((String) str).length() <= limit && ((String) str).length() >= min);
	}
	//method to validate string is numeric
	static public boolean isNumericString(String str) {
		try {
			Double.parseDouble(str);
		}
		catch (Exception e) {
			return false;
		}
		return true;
	}
	// method to validate is integer
	static public boolean isInteger(Object num) {
		return num instanceof Integer;
	}
	// method to validate is integer within range
	static public boolean isIntegerWithinRange(Object num, int lower, int upper) {
		return (isInteger(num) && ((int) num) >= lower && ((int) num) <= upper);
	}
	// method to validate is decimal (float or double)
	static public boolean isDecimal(Object num) {
		try {
			if (isInteger(num)) {
				return false;
			}
			if (num instanceof Double) {
				return true;
			}
			if (num instanceof Float) {
				return true;
			}
		}
		catch (Exception e) {
			return false;
		}
		return false;
	}
	//method to validate is decimal (float or double) within range
	static public boolean isDecimalWithinRange(Object num, double lower, double upper) {
		return (isDecimal(num) && ((double) num) >= lower && ((double) num) <= upper);
	}
	//method to validate date
	static public boolean isCorrectDateFormat(Object dateStr) {
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		sdf.setLenient(false);
		try {
			Date date = sdf.parse((String) dateStr);
			System.out.println(sdf.format(date));
			if (date == null) {
				return false;
			}
		}
		catch (Exception e) {
			return false;
		}
		return true;
		
	}
}
