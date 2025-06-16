package com.automation.testUtils;

import com.automation.utility.reportUtils.LogUtil;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryFailedTests implements IRetryAnalyzer {
    private int retryCount = 0;
    private static final int maxRetryCount = 2; // Retry failed test up to 2 times

    @Override
    public boolean retry(ITestResult result) {
        if (retryCount < maxRetryCount) {
            retryCount++;
            LogUtil.logInfo("Retrying to run again......");
            return true; // Retry test
        }
        return false; // Stop retrying
    }
}