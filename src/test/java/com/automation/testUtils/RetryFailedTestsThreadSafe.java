package com.automation.testUtils;
import com.automation.utility.reportUtils.LogUtil;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryFailedTestsThreadSafe implements IRetryAnalyzer {
    private static final int maxRetryCount = 2; // Set max retry attempts
    private static ThreadLocal<Integer> retryCount = ThreadLocal.withInitial(() -> 0);

    @Override
    public boolean retry(ITestResult result) {
        if (retryCount.get() < maxRetryCount) {
            retryCount.set(retryCount.get() + 1);
            LogUtil.logInfo("Retrying to run again......");
            return true; // Retry the test
        }
        return false; // Stop retrying
    }
}
