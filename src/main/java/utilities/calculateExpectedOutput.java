package utilities;

public class calculateExpectedOutput {
	
	static String expectedAnswer = "";
	
	public static String getExpectedResult(String numberOne, String numberTwo , String operation) {
		
		int number1 = Integer.parseInt(numberOne);
		int number2 = Integer.parseInt(numberTwo);
		int answer = 0;
		
		switch(operation){
		
		case "+":
			answer = number1 + number2;
			break;
		case "-":
			answer = number1 - number2;
			break;	
		case "*":
			answer = number1 * number2;
			break;	
		case "/":
			answer = number1 / number2;
			break;	
		 default:
	        throw new IllegalArgumentException("Invalid operation: " + operation);        
		}
		
		expectedAnswer = String.valueOf(answer);
		return expectedAnswer;		
	}
}