package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class commonMethods {
	
	public static String getDataFromPropertyFile(String propertyName) throws IOException {
		
		FileInputStream fin = new FileInputStream("D:\\SeleniumWorkspaces\\Selenium-2.0\\CalculatorAutomation\\src\\main\\resources\\data.properties"); 
		Properties prop = new Properties();
		prop.load(fin);
		
		String propertyValue = prop.getProperty(propertyName);		
		return propertyValue;		
	}
	
	
	public static String[] getNumbers(String operation) throws IOException {
		
		String numberOne = "";
		String numberTwo = "";
		
		if(operation.equalsIgnoreCase("+")) {

			numberOne = commonMethods.getDataFromPropertyFile("a1");
			numberTwo = commonMethods.getDataFromPropertyFile("a2");		
		}
		else if(operation.equalsIgnoreCase("-")) {
			
			numberOne = commonMethods.getDataFromPropertyFile("s1");
			numberTwo = commonMethods.getDataFromPropertyFile("s2");		
		}
		else if(operation.equalsIgnoreCase("*")) {
			
			numberOne = commonMethods.getDataFromPropertyFile("m1");
			numberTwo = commonMethods.getDataFromPropertyFile("m2");		
		}
		else if(operation.equalsIgnoreCase("/")) {
			
			numberOne = commonMethods.getDataFromPropertyFile("d1");
			numberTwo = commonMethods.getDataFromPropertyFile("d2");		
		}	
		
		return new String[] {numberOne, numberTwo};		
	}
}
