package com.automation.helpers;

public class Common {
    protected String commonValue="Common value";
    protected String name;
    protected String job;
    protected String id;
    protected String createdAt;
    protected String updatedAt;
    public Common(){
        System.out.println("Inside common Constructor");
    }
    public String getNameValue(){
        return name;
    }
    protected String getNewValue() {
        return commonValue.replace("Common", "New");
    }
}
