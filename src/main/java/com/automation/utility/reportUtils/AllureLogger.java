package com.automation.utility.reportUtils;

import io.qameta.allure.Attachment;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class AllureLogger {
    private static final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private static final PrintStream printStream = new PrintStream(outputStream);

    static {
        System.setOut(printStream); // Redirect System.out to capture logs
    }

    @Attachment(value = "Console Output", type = "text/plain")
    public static String getConsoleLogs() {
        printStream.flush();
        return outputStream.toString();
    }
}