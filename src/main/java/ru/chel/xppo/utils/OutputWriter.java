package ru.chel.xppo.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class OutputWriter {

    public static void write(File file, List<String> lines) {
        try (FileWriter fr = new FileWriter(file); BufferedWriter br = new BufferedWriter(fr)){
            for (String line : lines) {
                br.write(line);
                br.write('\n');
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
