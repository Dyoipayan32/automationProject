package com.automation;

import io.restassured.path.json.JsonPath;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import com.google.gson.Gson;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static org.testng.Assert.assertEquals;

public class POSTdemo {


    @BeforeSuite
    void setUp() {
        System.out.println("This is under setup method.");
    }

    @Test
    void validatePostRequest() {
        {
            System.out.println("Running current test.");
        }
        RestAssured.baseURI = "https://api.restful-api.dev/";
        RestAssured.basePath = "objects";
        RequestSpecification request = RestAssured.given();
        // Creating the main JSON object
        Map<String, Object> requestBody = new LinkedHashMap<>();
        requestBody.put("name", "Apple MacBook Pro 16");

        // Creating the nested "data" object
        Map<String, Object> dataMap = new LinkedHashMap<>();
        dataMap.put("year", 2019);
        dataMap.put("price", 1849.99);
        dataMap.put("CPU model", "Intel Core i9");
        dataMap.put("Hard disk size", "1 TB");

        // Adding nested object to the main JSON structure
        requestBody.put("data", dataMap);
        // Convert to JSON string
        Gson gson = new Gson();
        String jsonString = gson.toJson(requestBody);

        request.body(jsonString);


        Response response = RestAssured.given().post();

        System.out.println(response.jsonPath().prettyPrint());


    }


    @AfterSuite
    void tearDown() {
        System.out.println("This is under teardown method.");
    }
}
