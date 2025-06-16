package com.automation.helpers;

import com.automation.helpers.model.UserRequest;
import com.automation.helpers.model.UserResponse;

public class TestYourPOJO {
    public static void main(String[] args) {
        Common common = new Common();
        UserRequest request = new UserRequest("John Doe", "Lead Engineer");
        UserResponse response = new UserResponse();
        System.out.println("Before Setter: "+request.name);
        System.out.println("Before Setter: "+request.job);
        request.setName("Jane Smith");
        request.setJob("Developer");
        System.out.println(request.name);
        System.out.println(request.job);

        System.out.println(response.name);
        System.out.println(common.name);

        response.setName("Jane Smith");
        System.out.println(response.getName());
        response.setJob("Developer");
        response.setId("569");
        System.out.println(response.getJob());
        System.out.println(response.getId());
        System.out.println(common.getNameValue());
    }
}
