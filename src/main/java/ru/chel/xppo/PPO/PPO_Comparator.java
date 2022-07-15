package ru.chel.xppo.PPO;

import ru.chel.xppo.logging.LogHandler;
import ru.chel.xppo.logging.PPO_LogFormatter;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class PPO_Comparator {
    public static Logger LOGGER = Logger.getLogger("xppo");

    public static void compare(List<String> xbasePPO, List<String> xsharpPPO, String fileName) {
        if (xbasePPO.size() == xsharpPPO.size()) {
            for (int i = 0; i < xbasePPO.size(); i++) {
                String lineXBase = xbasePPO.get(i);
                String lineXSharp = xsharpPPO.get(i);
                if (!lineXBase.equals(lineXSharp)) {
                    LOGGER.log(Level.WARNING, '[' +fileName + ']' + "\nXbase: " + xbasePPO.get(i) + "\nXSharp: " + xsharpPPO.get(i));
                }
            }
        }
        else {
            LOGGER.log(Level.WARNING, '[' +fileName + ']' + " size");
        }
    }

    public static void setLogger() {
        try {
            LogManager.getLogManager().reset();
            LOGGER.addHandler(new LogHandler("logs/log_%g.txt", new PPO_LogFormatter()));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
