package com.automation.testUtils;

import java.io.File;
import java.util.Objects;

public class FileOperations {

    public static boolean deleteFolder(String  pathToFolder) {
        File folder = new File(pathToFolder);
        if (folder.isDirectory()) {
            for (File file : Objects.requireNonNull(folder.listFiles())) {
                deleteFolder(String.valueOf(file)); // Recursive call
            }
        }
        return folder.delete(); // Deletes file or empty folder
    }
}
