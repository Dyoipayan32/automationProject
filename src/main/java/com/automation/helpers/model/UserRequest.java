package com.automation.helpers.model;

import com.automation.helpers.Common;

public class UserRequest extends Common {
    private String newValue = null;

    public UserRequest(String name, String job) {
        this.name = name;
        this.job = job;
        this.newValue= this.getNewValue();
//        this.newValue= "";
        System.out.println("Inside User Request Constructor");
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name+" "+this.commonValue;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job+" "+this.newValue;
    }
}
