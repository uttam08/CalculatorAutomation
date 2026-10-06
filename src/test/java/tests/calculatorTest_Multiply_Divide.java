package tests;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.calculatorPage;
import testUtilities.RetryHandler;
import utilities.base;
import utilities.calculateExpectedOutput;
import utilities.commonMethods;

public class calculatorTest_Multiply_Divide {
	
	private static Logger log = LogManager.getLogger(calculatorTest_Multiply_Divide.class.getName());
	
	public static WebDriver driver;
	calculatorPage calci;
	
	String numberOne = "";
	String numberTwo = "";
	String operation = "";
	String calculatedAnswer = "";
	String expectedAnswer = "";
	
	@BeforeClass(alwaysRun = true)
	public void startInstance() throws IOException {
		driver = base.InitializeBrowser();
		calci = new calculatorPage(driver);
		log.info("Driver instance created");
	}
	
	
	@Test(groups = {"sanity"} , retryAnalyzer = RetryHandler.class)
	public void mulNumbers() throws IOException {
		
		operation = "*";
		
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
	public void divNumbers() throws IOException {
		
		operation = "/";
		
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
