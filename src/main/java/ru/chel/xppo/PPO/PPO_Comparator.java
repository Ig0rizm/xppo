package ru.chel.xppo.PPO;

import java.util.List;
import java.util.logging.Level;
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
            String lastLineXBase = "";
            String lastLineXSharp = "";
            for (int i = 0; i < xbasePPO.size() && i < xsharpPPO.size(); i++) {
                String lineXBase = xbasePPO.get(i);
                String lineXSharp = xsharpPPO.get(i);
                if (!lineXBase.equals(lineXSharp)) {
                    break;
                }
                lastLineXBase = (i+1 < xbasePPO.size()) ? xbasePPO.get(i+1) : "";
                lastLineXSharp = (i+1 < xsharpPPO.size()) ? xsharpPPO.get(i+1) : "";
            }
            LOGGER.log(Level.WARNING, '[' +fileName + ']' + " size" + "\nXbase: " + lastLineXBase + "\nXSharp: " + lastLineXSharp);
        }
    }
}
