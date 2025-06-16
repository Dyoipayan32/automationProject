package com.automation;


import com.automation.helpers.model.UserRequest;
import com.automation.helpers.model.UserResponse;
import io.qameta.allure.Description;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import org.testng.annotations.Test;


import static com.automation.constants.EndPoint.*;
import static io.restassured.RestAssured.given;
import static org.testng.Assert.*;

public class TestPOSTUser {

    @Test(description = "Create a new user using POST API")
    @Description("Test to validate creation of user using POST request")
    public void createUser() {
        UserRequest user = new UserRequest("Ravi", "Tester");
        /*
         * As Rest Assured automatically handles serialization when passing a Java object,
         * No additional serialization steps are written to convert pojo --> 'user' to json string.
         * Rest Assured automatically serializes Java objects (POJOs) to JSON - under the hood.
         * If the input is not in json string while sending request,
         * Rest Assured ensures that the conversion happens before sending the request.
         * - Behind the Scenes Serialization: Internally, Jackson does something like:
            ObjectMapper mapper = new ObjectMapper();
            String jsonPayload = mapper.writeValueAsString(user); // Converts POJO to JSON string
         *
         * OR
         * String jsonPayload = new Gson().toJson(user);  // Converts POJO to JSON string
         */

        // You can verify serialization by printing the actual request body before sending it.
        // You can verify serialization by printing the actual request body before sending it.
        System.out.println("Serialized JSON: " + RestAssured.given().body(user).log().body());

        UserResponse response = given().filter(new AllureRestAssured())
            .baseUri(BASE_URL)
            .header("Content-Type", "application/json")
            .body(user)
        .when()
            .post(OBJECTS)
        .then()
            .statusCode(201)
            .extract().as(UserResponse.class);

        assertEquals(response.getName(), "Ravi");
        assertEquals(response.getJob(), "Tester");
        assertNotNull(response.getId());
        assertNotNull(response.getCreatedAt());
    }
}