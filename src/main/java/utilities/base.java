package utilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.google.common.io.Files;

public class base {
	
	private static Logger log = LogManager.getLogger(base.class.getName());	
	public static WebDriver driver;
		
	public static WebDriver InitializeBrowser() throws IOException {
		
		String browserName = commonMethods.getDataFromPropertyFile("browser");
		
		if(browserName.equalsIgnoreCase("chrome")) {
			
			driver =  new ChromeDriver();
			log.info("Starting the ChromeDriver instance");
		}
		else if(browserName.equalsIgnoreCase("firefox")){
			
			driver =  new FirefoxDriver();		
			log.info("Starting the FirefoxDriver instance");
		}
		
		driver.get(commonMethods.getDataFromPropertyFile("url"));
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		return driver;
	}
	
	public String getScreenShotWithPath(String testCaseName, WebDriver driver) throws IOException {
		
		String destinationFile = System.getProperty("user.dir") + "\\ExecutionReports\\" + testCaseName + ".png";
		
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		Files.copy(src, new File(destinationFile));
		return destinationFile;		
	}
}