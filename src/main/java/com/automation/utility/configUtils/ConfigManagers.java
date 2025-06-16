package com.automation.utility.configUtils;



import com.automation.utility.reportUtils.LogUtil;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigManagers {
    private static Properties prop;

    public static String getProperty(String key) {
        if (prop == null) {
            prop = new Properties();
            try {
                FileInputStream fis = new FileInputStream("src/test/resources/config.properties");
                prop.load(fis);
            } catch (IOException e) {
                LogUtil.logInfo(e.getMessage());
            }
        }
        return prop.getProperty(key);
    }
}