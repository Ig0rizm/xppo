package ru.chel.xppo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.chel.xppo.PPO.PPO_Reader;

import java.net.URL;
import java.util.List;

public class PPO_ReaderTest {

    public PPO_Reader reader;

    @Before
    public void prepare() {
        reader = new PPO_Reader();
    }

    @Test
    public void readPPOTest1() {
        URL url = PPO_ReaderTest.class.getClassLoader().getResource("b_rlock.ppo");

        List<String> lines = reader.readPPO(url.getPath());
        Assert.assertEquals("MEMVARCurrent_File", lines.get(0));
    }
}
