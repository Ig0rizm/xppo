package ru.chel.xppo.settings;

import ru.chel.xppo.utils.FileChecker;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Prop {
    public static String XBasePath;
    public static String XSharpPath;

    public static void setProp() {
        Properties properties = new Properties();
        FileChecker.createFolderIfNot("configs");

        try {
            properties.load(new FileInputStream("./configs/path.properties"));
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        XBasePath = properties.getProperty("xbase");
        XSharpPath = properties.getProperty("xsharp");
    }
}
