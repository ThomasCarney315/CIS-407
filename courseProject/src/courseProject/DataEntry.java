package courseProject;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
public class DataEntry {
	//method for entering string without validation conditions
	static public boolean enterString(Customer c,  String field, Scanner input) {
		System.out.print("Enter customer " + field +":  ");
		String val = input.nextLine();
		if (!isStringNoLimit(val)) {
			return false;
		}
		if (field == "id") {c.setId(val);}
		else if(field == "ssn") {
			if(!isNumericString(val)) {
				return false;
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
				return false;
			}
			c.setZip(Integer.parseInt(val));
			}
		else if(field == "phone") {
			if(!isNumericString(val)) {
				return false;
			}
			c.setPhone(val);
			}
		
		return true;
	}
	//method for entering string with validation conditions
	static public boolean enterStringWithLimits(Customer c,  String field, Scanner input, int min,  int limit) {
		System.out.print("Enter customer " + field + ":  ");
		String val = input.nextLine();
		if (!isStringWithinLimits(val, min, limit)) {
			return false;
		}
		if (field == "id") {c.setId(val);}
		else if(field == "ssn") {
			if(!isNumericString(val)) {
				return false;
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
				return false;
			}
			c.setZip(Integer.parseInt(val));
			}
		else if(field == "phone") {
			if(!isNumericString(val)) {
				return false;
			}
			c.setPhone(val);
			}
		return true;
	}
	//override for entering string with validation conditions and conditions-description
	static public boolean enterStringWithLimits(Customer c,  String field, Scanner input, int min,  int limit, String conditionStr) {
		System.out.print("Enter customer " + field + " "+ conditionStr +":  ");
		String val = input.nextLine();
		if (!isStringWithinLimits(val, min, limit)) {
			return false;
		}
		if (field == "id") {c.setId(val);}
		else if(field == "ssn") {
			if(!isNumericString(val)) {
				return false;
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
				return false;
			}
			c.setZip(Integer.parseInt(val));
			}
		else if(field == "phone") {
			if(!isNumericString(val)) {
				return false;
			}
			c.setPhone(val);
			}
		return true;
	}
	//method for entering integer
	static public boolean enterInteger(Customer c, String field, Scanner input) {
		System.out.print("Enter customer " + field +":  ");
		int val;
		try {
			val = Integer.parseInt(input.nextLine());
		}catch (Exception e) {
			return false;
		}
		if (!isInteger(val)) {
			return false;
		}
		if (field == "zip") {c.setZip(val);}
		return true;
	}
	//method for entering integer within range
	static public boolean enterIntegerWithinRange(Customer c, String field, Scanner input, int min, int max) {
		System.out.print("Enter customer " + field +":  ");
		int val;
		try {
			val = Integer.parseInt(input.nextLine());
		}catch (Exception e) {
			return false;
		}
		if (!isIntegerWithinRange(val, min, max) ) {
			return false;
		}
		if (field == "zip") {c.setZip(val);}
		return true;
	}
	//method for entering integer within range and condition-description
	static public boolean enterIntegerWithinRange(Customer c, String field, Scanner input, int min, int max, String conditionStr) {
		System.out.print("Enter customer " + field + " "+ conditionStr +":  ");
		int val;
		try {
			val = Integer.parseInt(input.nextLine());
		}catch (Exception e) {
			return false;
		}
		if (!isIntegerWithinRange(val, min, max) ) {
			return false;
		}
		if (field == "zip") {c.setZip(val);}
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
