package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class calculatorPage {
	
	private WebDriver driver;
	
	public calculatorPage(WebDriver driver) {
		this.driver = driver;
	}
	
	private By equalsBtn =  By.cssSelector("span[onclick=\"r('=')\"]");
	private By resetBtn =  By.cssSelector("span[onclick=\"r('C')\"]");
	
	private By getAnswer =  By.id("sciOutPut");
	
	private By addBtn =  By.cssSelector("span[onclick=\"r('+')\"]");
	private By subBtn =  By.cssSelector("span[onclick=\"r('-')\"]");
	private By mulBtn =  By.cssSelector("span[onclick=\"r('*')\"]");
	private By divBtn =  By.cssSelector("span[onclick=\"r('/')\"]");
	
	private By digit0 =  By.cssSelector("span[onclick=\"r(0)\"]");
	private By digit1 =  By.cssSelector("span[onclick=\"r(1)\"]");
	private By digit2 =  By.cssSelector("span[onclick=\"r(2)\"]");
	private By digit3 =  By.cssSelector("span[onclick=\"r(3)\"]");
	private By digit4 =  By.cssSelector("span[onclick=\"r(4)\"]");
	private By digit5 =  By.cssSelector("span[onclick=\"r(5)\"]");
	private By digit6 =  By.cssSelector("span[onclick=\"r(6)\"]");	
	private By digit7 =  By.cssSelector("span[onclick=\"r(7)\"]");
	private By digit8 =  By.cssSelector("span[onclick=\"r(8)\"]");
	private By digit9 =  By.cssSelector("span[onclick=\"r(9)\"]");
	
	
	public void clickOnEquals() {
		driver.findElement(equalsBtn).click();
	}
	
	public void resetCalculator() {
	    driver.findElement(resetBtn).click();
	}

	public String getCalculatedAnswer() {
	    return driver.findElement(getAnswer).getText().trim();
	}
	
	public void clickOnOperation(String operation) {

	    if(operation.equals("+")) {
	        driver.findElement(addBtn).click();
	    }
	    else if(operation.equals("-")) {
	        driver.findElement(subBtn).click();
	    }
	    else if(operation.equals("*")) {
	        driver.findElement(mulBtn).click();
	    }
	    else if(operation.equals("/")) {
	        driver.findElement(divBtn).click();
	    }
	    else {
	        throw new IllegalArgumentException("Invalid operation: " + operation);
	    }
	}
	
	public void clickOnDigit(char digit) {

	    switch(digit) {

	    case '0':
	        driver.findElement(digit0).click();
	        break;

	    case '1':
	        driver.findElement(digit1).click();
	        break;

	    case '2':
	        driver.findElement(digit2).click();
	        break;

	    case '3':
	        driver.findElement(digit3).click();
	        break;

	    case '4':
	        driver.findElement(digit4).click();
	        break;

	    case '5':
	        driver.findElement(digit5).click();
	        break;

	    case '6':
	        driver.findElement(digit6).click();
	        break;

	    case '7':
	        driver.findElement(digit7).click();
	        break;

	    case '8':
	        driver.findElement(digit8).click();
	        break;

	    case '9':
	        driver.findElement(digit9).click();
	        break;

	    default:
	        throw new IllegalArgumentException("Invalid digit: " + digit);
	    }
	}
	
	public void enterNumber(String number) {
		
		for(int i=0;i<number.length();i++) {
			
			 char digit = number.charAt(i); 
			 clickOnDigit(digit);
		}	
	}
}
