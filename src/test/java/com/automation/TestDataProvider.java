package com.automation;

import com.automation.utility.reportUtils.LogUtil;
import com.automation.testUtils.CSVReaderUtil;
import com.opencsv.exceptions.CsvException;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.*;

import java.lang.reflect.Method;
import java.util.Iterator;
import static org.testng.Assert.assertEquals;

public class TestDataProvider {
    private boolean skipTest = true;
    @DataProvider(name = "userData")
    public Iterator<Object[]> readCSVData() throws CsvException {
        return CSVReaderUtil.getTestData("src/test/resources/TestData.csv");
    }

    @BeforeClass
    void classSetUp() {
        LogUtil.logInfo("Starting Test Class: " + this.getClass().getSimpleName());
    }

    @AfterClass
    void classTearDown() {
        LogUtil.logInfo("Completed Test Class: " + this.getClass().getSimpleName());
    }

    @BeforeMethod
    public void beforeTest(Method method) {
        LogUtil.logInfo("Starting test: " + method.getName());
    }

    @Test(dataProvider = "userData" , description = "Test data provider example")
    @Description("Validate data provider example")
    @Step("Test Step")
    public void validateDataProviderWorks(String Id, String userName, String job) {
        String value = "User";
//        Response response = RestAssured.given().filter(new AllureRestAssured())
//                .baseUri(BASE_URL)
//                .when()
//                .get(OBJECTS)
//                .then()
//                .extract().response();
//        assertEquals(response.getStatusCode(), 200);
        LogUtil.logInfo(Id+" "+userName+" "+job);

        assertEquals(value, "User");
    }

    @Test(dataProvider = "userData" , description = "Test data provider 2nd example", enabled = false)
    @Description("Duplicate Test: Validate data provider example")
    @Step("Test Step")
    public void validateDataProviderWorks2(String Id, String userName, String job) {
        String value = "User";

        LogUtil.logInfo(Id+" "+userName+" "+job);

        assertEquals(value, "User");
    }

    @Test
    public void testSkipConditionally() {
        if (skipTest) {
            throw new SkipException("Skipping this test dynamically!");
        }
        System.out.println("This test runs only when condition is false.");
    }




    @AfterMethod
    public void afterTest(ITestResult result) {
        LogUtil.logInfo("Finished test: " + result.getMethod().getMethodName());
    }

    @AfterTest
    public void attachLogs() {
//        AllureLogger.getConsoleLogs(); // Attach logs to Allure report
        LogUtil.attachLogFile(); // Attach logs to Allure report

    }

}
