package ru.chel.xppo.logging;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Formatter;
import java.util.logging.Level;
import java.util.logging.LogRecord;

public class LogHandler extends FileHandler {
    public LogHandler(String pattern, Formatter formatter) throws IOException, SecurityException {
        super(pattern);
        setFormatter(formatter);
        setLevel(Level.INFO);
    }

    @Override
    public void publish(LogRecord record) {
        super.publish(record);
    }

    @Override
    public void flush() {
        super.flush();
    }

    @Override
    public void close() throws SecurityException {
        super.close();
    }
}
