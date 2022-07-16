package ru.chel.xppo.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FolderChecker {
    public static Path createFolderIfNot(String folderPath) {
        File file = new File(folderPath);
        if (!file.exists()) {
            try {
                return Files.createDirectory(Paths.get(folderPath));
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
