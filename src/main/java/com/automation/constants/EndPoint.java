package com.automation.constants;

import com.automation.utility.configUtils.ConfigManagers;

public class EndPoint {
    public static final String BASE_URL = ConfigManagers.getProperty("BASE_URI");
    public static final String OBJECTS = ConfigManagers.getProperty("OBJECTS");
}
