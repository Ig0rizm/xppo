package ru.chel.xppo;

import ru.chel.xppo.PPO.PPO_Comparator;
import ru.chel.xppo.PPO.PPO_Reader;
import ru.chel.xppo.logging.Loggers;
import ru.chel.xppo.logging.PPO_LogFormatter;
import ru.chel.xppo.settings.Arguments;
import ru.chel.xppo.settings.Prop;
import ru.chel.xppo.utils.FileChecker;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        Prop.setProp();
        if (args.length > 0) {
            FileChecker.createFolderIfNot("ppoOutput");
            if (args[0].equals("ppo")) {
                Arguments.PPO = true;
            }
        }

        Loggers.setLogger(PPO_Comparator.LOGGER, new PPO_LogFormatter());
        PPO_Reader reader = new PPO_Reader();

        File xBaseDir = new File(Prop.XBasePath);
        for (File file : xBaseDir.listFiles()) {
            PPO_Comparator.compare(reader.readPPO(Prop.XBasePath + "\\" + file.getName()),
                    reader.readPPO(Prop.XSharpPath + "\\" + file.getName()), file.getName());
        }
    }
}
