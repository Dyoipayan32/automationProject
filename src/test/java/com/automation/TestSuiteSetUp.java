package com.automation;

import com.automation.utility.reportUtils.LogUtil;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import static com.automation.testUtils.FileOperations.deleteFolder;

public class TestSuiteSetUp {
    @BeforeSuite
    void setUp() {
        LogUtil.logInfo("This is under setup method-BeforeSuite.");
        String allureResultsFolder = "target/allure-results";
        deleteFolder(allureResultsFolder);
        LogUtil.logInfo("Reports folder cleared successfully");
    }

    @AfterSuite
    void tearDown() {
        LogUtil.logInfo("This is under teardown method-AfterSuite.");
    }
}

