package com.automation.utility.reportUtils;

import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class LogUtil {
    private static final Logger logger = LogManager.getLogger(LogUtil.class);
    private static final Path LOG_FILE_PATH = Path.of("test-logs/test.log");

    static {
        try {
            Files.createDirectories(LOG_FILE_PATH.getParent()); // Ensure directory exists
            Files.write(LOG_FILE_PATH, "".getBytes(), StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
        } catch (IOException e) {
            System.err.println("Failed to initialize log file: " + e.getMessage());
        }
    }

    public static void logInfo(String message) {
//        logger.info(message);
        logStep(message);
        writeToLogFile(message); // Write log info to file
    }

    private static void writeToLogFile(String message) {
        try {
            Files.write(LOG_FILE_PATH, (message + System.lineSeparator()).getBytes(),
                    StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        } catch (IOException e) {
            System.err.println("Error writing to log file: " + e.getMessage());
        }
    }

    @Attachment(value = "Log Output", type = "text/plain")
    public static String attachLogFile() {
        try {
            return Files.readString(LOG_FILE_PATH);
        } catch (IOException e) {
            return "Failed to attach log file: " + e.getMessage();
        }
    }

    public static void logStep(String message) {
        Allure.step(message);
    }

}