package com.automation;

import com.automation.utility.reportUtils.LogUtil;
import io.qameta.allure.Description;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;


import static com.automation.constants.EndPoint.*;
import static org.testng.Assert.assertEquals;

public class TestGETPerson {

    @Test(description = "Test OBJECT Information using GET API")
    @Description("Test to validate OBJECT Information using GET request")
    public void testGetUser() {
        Response response = RestAssured.given().filter(new AllureRestAssured())
                .baseUri(BASE_URL)
                .when()
                .get(OBJECTS)
                .then()
                .extract().response();

        assertEquals(response.getStatusCode(), 200);
        LogUtil.logInfo("GET OBJECT Response:\n" + response.asPrettyString());
    }
}