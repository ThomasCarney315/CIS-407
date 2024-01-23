package courseProject;

public class DataEntry {
	//a
	static public boolean isStringNoLimit(Object str) {
		return str instanceof String;
	}
	//b
	static public boolean isStringWithinLimit(Object str, int limit) {
		return (isStringNoLimit(str) && ((String) str).length() <= limit);
	}
	//c
	static public boolean isNumericString(String str) {
		try {
			Double.parseDouble(str); 
		}
		catch (Exception e) {
			return false;
		}
		return true;
	}
	//d
	
}
