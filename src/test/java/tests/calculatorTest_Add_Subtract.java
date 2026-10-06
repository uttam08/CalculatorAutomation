package tests;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import pageObjects.calculatorPage;
import utilities.base;
import utilities.calculateExpectedOutput;
import utilities.commonMethods;
import testUtilities.RetryHandler;

public class calculatorTest_Add_Subtract {
	
	private static Logger log = LogManager.getLogger(calculatorTest_Add_Subtract.class.getName());

	public static WebDriver driver;
	String numberOne = "";
	String numberTwo = "";
	String operation = "";
	String calculatedAnswer = "";
	String expectedAnswer = "";
	
	calculatorPage calci;
	
	@BeforeClass(alwaysRun = true)
	public void startInstance() throws IOException {
		driver = base.InitializeBrowser();	
		log.info("Driver instance created");
		calci = new calculatorPage(driver);
	}
	

	@Test(groups = {"smoke"} , retryAnalyzer = RetryHandler.class)
	public void addNumbers() throws IOException {
		
		operation = "+";
		
		String[] numbers = commonMethods.getNumbers(operation);
		numberOne = numbers[0];
		numberTwo = numbers[1];

		calci.resetCalculator();
		log.info("Calculator is reset");

		calci.enterNumber(numberOne);
		calci.clickOnOperation(operation);
		calci.enterNumber(numberTwo);
		log.info("Numbers are entered");

		calci.clickOnEquals();

		calculatedAnswer = calci.getCalculatedAnswer();
		expectedAnswer = calculateExpectedOutput.getExpectedResult(numberOne, numberTwo, operation);

		Assert.assertEquals(calculatedAnswer, expectedAnswer);
	}
	
	
	@Test(groups = {"sanity"} , retryAnalyzer = RetryHandler.class)
	public void subtractNumbers() throws IOException {
		
		operation = "-";
		
		String[] numbers = commonMethods.getNumbers(operation);
		numberOne = numbers[0];
		numberTwo = numbers[1];

		calci.resetCalculator();
		log.info("Calculator is reset");

		calci.enterNumber(numberOne);
		calci.clickOnOperation(operation);
		calci.enterNumber(numberTwo);
		log.info("Numbers are entered");

		calci.clickOnEquals();

		calculatedAnswer = calci.getCalculatedAnswer();
		expectedAnswer = calculateExpectedOutput.getExpectedResult(numberOne, numberTwo, operation);

		Assert.assertEquals(calculatedAnswer, expectedAnswer);

	}
	
	@AfterClass(alwaysRun = true)
	public void stopInstance() {
		log.info("Killing the driver instance");
		driver.quit();		
	}
}
