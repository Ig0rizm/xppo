package ru.chel.xppo.logging;

import java.util.logging.Formatter;
import java.util.logging.LogRecord;

public class PPO_LogFormatter extends Formatter {
    @Override
    public String format(LogRecord record) {
        return record.getLevel().toString() + ' ' +
                formatMessage(record) +
                "\n\n";
    }
}
