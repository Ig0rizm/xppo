package ru.chel.xppo;

import ru.chel.xppo.PPO.PPO_Comparator;
import ru.chel.xppo.PPO.PPO_Reader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Main {

    public static void main(String args[]) throws IOException {
        PPO_Reader reader = new PPO_Reader();
        PPO_Comparator.setLogger();

        Properties properties = new Properties();
        properties.load(new FileInputStream("./configs/path.properties"));
        String XBasePath = properties.getProperty("xbase");
        String XSharpPath = properties.getProperty("xsharp");

        File xBaseDir = new File(XBasePath);
        for (File file : xBaseDir.listFiles()) {
            PPO_Comparator.compare(reader.readPPO(XBasePath + "\\" + file.getName()),
                    reader.readPPO(XSharpPath + "\\" + file.getName()), file.getName());
        }
    }
}
