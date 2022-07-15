package ru.chel.xppo;

import org.junit.Assert;
import org.junit.Test;
import ru.chel.xppo.PPO.PPO_Reader;

import java.net.URL;
import java.util.List;

public class PPO_ReaderTest {

    @Test
    public void readPPOTest() {
        URL url = PPO_ReaderTest.class.getClassLoader().getResource("b_rlock.ppo");

        PPO_Reader reader = new PPO_Reader();
        List<String> lines = reader.readPPO(url.getPath());
        Assert.assertEquals("MEMVARCurrent_File", lines.get(0));
    }
}
