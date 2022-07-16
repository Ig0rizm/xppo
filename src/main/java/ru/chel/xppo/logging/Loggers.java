package ru.chel.xppo.logging;

import ru.chel.xppo.utils.FileChecker;

import java.io.IOException;
import java.util.logging.Formatter;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class Loggers {

    public static void setLogger(Logger LOGGER, Formatter formatter) {
        try {
            FileChecker.createFolderIfNot("logs");
            LogManager.getLogManager().reset();
            LOGGER.addHandler(new LogHandler("logs/log_%g.txt", formatter));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
