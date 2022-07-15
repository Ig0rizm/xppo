package ru.chel.xppo.PPO;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PPO_Reader {

    private List<String> lines;

    public List<String> readPPO(String pathname) {
        File ppoFile = new File(pathname);
        lines = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(ppoFile), "cp866"))) {
            String availalbe;
            while ((availalbe = br.readLine()) != null) {
                lines.add(availalbe);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        preparePPO();

        return lines;
    }

    private boolean isComment(String line, int index) {
        return (line.charAt(index+1) == '/' || line.charAt(index+1) == '*');
    }

    private void removeSpaces() {
        int i = 0;

        while (i < lines.size()) {
            lines.set(i, lines.get(i).replaceAll("\\s+", ""));
            if (lines.get(i).isEmpty()) lines.remove(i);
            else i++;
        }
    }

    private void removeComments() {
        int i = 0;

        while (i < lines.size()) {
            String line = lines.get(i);
            if (!line.isEmpty() && (line.charAt(0) == '#' || line.charAt(0) == '*' || line.contains("/*") || line.contains("*/"))) {
                lines.remove(i);
            }
            else if (line.contains("//")) {
                int index = line.indexOf('/');
                while (!isComment(line, index)) {
                    index = line.indexOf('/', index+1);
                }
                if (index == 0) lines.remove(i);
                else {
                    String sub = (String) line.subSequence(0, index);
                    lines.set(i, sub);
                    i++;
                }
            }
            else i++;
        }
    }

    private void preparePPO() {
        removeSpaces();
        removeComments();
    }
}
