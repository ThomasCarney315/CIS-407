package courseProject;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
public class DataEntry {
	
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
		else if(field == "phone") {c.setPhone(val);}
		
		return true;
	}
	static public boolean enterStringWithLimit(Customer c,  String field, Scanner input, int min,  int limit) {
		System.out.print("Enter customer " + field +":  ");
		String val = input.nextLine();
		if (!isStringWithinLimit(val, min, limit)) {
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
		else if(field == "phone") {c.setPhone(val);}
			
		return true;
		
	}
	static public boolean isStringNoLimit(Object str) {
		return str instanceof String;
	}
	static public boolean isStringWithinLimit(Object str, int min, int limit) {
		return (isStringNoLimit(str) && ((String) str).length() <= limit && ((String) str).length() >= min);
	}
	static public boolean isNumericString(String str) {
		try {
			Double.parseDouble(str); 
		}
		catch (Exception e) {
			return false;
		}
		return true;
	}
	
	static public boolean isInteger(Object num) {
		return num instanceof Integer;
	}
	
	static public boolean isIntegerWithinRange(Object num, int lower, int upper) {
		return (isInteger(num) && ((int) num) >= lower && ((int) num) <= upper);
	}
	
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

	static public boolean isDecimalWithinRange(Object num, double lower, double upper) {
		return (isDecimal(num) && ((double) num) >= lower && ((double) num) <= upper);
	}
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
