package AjinkyaProject.TestComponents;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer {

	private int retryCount = 0;
	private static final int maxRetryCount = 2; // Number of retries

	@Override
	public boolean retry(ITestResult result) {
		if (retryCount < maxRetryCount) {
			retryCount++;
			return true; // Retry the test
		}
		return false; // Do not retry
	}

	

}
