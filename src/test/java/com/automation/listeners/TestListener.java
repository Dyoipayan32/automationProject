package com.automation.listeners;
import com.automation.utility.reportUtils.LogUtil;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    @Override
    public void onTestSuccess(ITestResult result) {
        LogUtil.logInfo("Test Passed: " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        LogUtil.logInfo("Test Failed: " + result.getName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        LogUtil.logInfo("Test Skipped: " + result.getName());
    }
}