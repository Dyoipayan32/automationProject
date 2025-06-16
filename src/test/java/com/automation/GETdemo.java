package com.automation;

import com.automation.utility.reportUtils.LogUtil;
import io.restassured.path.json.JsonPath;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.lang.reflect.Method;

import io.qameta.allure.Step;
import io.qameta.allure.restassured.AllureRestAssured;
import java.util.List;
import java.util.Map;

import static org.testng.Assert.assertEquals;

public class GETdemo {

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

    @Test(priority = 2)
    @Step("Validate Google Pixel Capacity")
    void validateGetRequest1() {
        {
            LogUtil.logInfo("Running current test.");
        }
        RestAssured.baseURI = "https://api.restful-api.dev/";
        RestAssured.basePath = "objects";

        Response response = RestAssured.given().filter(new AllureRestAssured()).get();
        // Print the 'capacity' of phone named 'Google Pixel 6 Pro' from response.
        LogUtil.logInfo("captured response:\n{}"+response.jsonPath().prettyPrint());
        JsonPath jsonPath = new JsonPath(response.asPrettyString());
        List<Map<String, Object>> deviceList = jsonPath.getList("$");
                // Find the device and extract its capacity
        // Find the device and extract its capacity
        String deviceCapacity = deviceList.stream()
                .filter(device -> "Google Pixel 6 Pro".equals(device.get("name")))
                .map(device -> ((Map<String, Object>) device.get("data")).get("capacity").toString())
                .findFirst()
                .orElse(null);
        // Intentionally failing this test.
        assertEquals(deviceCapacity, "128 GB", "device capacity value did not match");

    }

    @Test(priority = 1)
    @Step("Validate Samsung Z Flips Color")
    void validateGetRequest2() {
        {
            LogUtil.logInfo("Running current test.");
        }
        RestAssured.baseURI = "https://api.restful-api.dev/";
        RestAssured.basePath = "objects";

        Response response = RestAssured.given().filter(new AllureRestAssured()).get();
        // Print the 'capacity' of phone named 'Google Pixel 6 Pro' from response.
        LogUtil.logInfo("captured response:\n{}"+response.jsonPath().prettyPrint());
        JsonPath jsonPath = new JsonPath(response.asPrettyString());
        List<Map<String, Object>> deviceList = jsonPath.getList("$");
        // Find the device and extract its color
        String deviceColor = deviceList.stream()
                .filter(device -> "Samsung Galaxy Z Fold2".equals(device.get("name")))
                .map(device -> ((Map<String, Object>) device.get("data")).get("color").toString())
                .findFirst()
                .orElse(null);

        assertEquals(deviceColor, "Brown", "device color did not match");

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

