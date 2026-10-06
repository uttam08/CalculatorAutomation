package testUtilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryHandler implements IRetryAnalyzer {
	
	int count = 0;
	int maxTry = 2;
	
	@Override
	public boolean retry(ITestResult result) {
		
		if(count < maxTry) {
			count++;
			return true;
		}

		return false;
	}
}

































