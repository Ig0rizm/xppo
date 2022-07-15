package ru.chel.xppo;

import org.junit.Before;
import org.junit.Test;
import ru.chel.xppo.PPO.PPO_Comparator;
import ru.chel.xppo.PPO.PPO_Reader;

import java.net.URL;
import java.util.List;

public class PPO_ComparatorTest {

    public List<String> xbase, xsharp;

    @Before
    public void prepare() {
        URL url_base = PPO_ReaderTest.class.getClassLoader().getResource("other_xbase.ppo");
        URL url_sharp = PPO_ReaderTest.class.getClassLoader().getResource("other_xsharp.ppo");

        PPO_Reader reader = new PPO_Reader();

        xbase = reader.readPPO(url_base.getPath());
        xsharp = reader.readPPO(url_sharp.getPath());

        System.out.println(xbase);
        System.out.println(xsharp);
    }

    @Test
    public void compareTest() {
        PPO_Comparator.compare(xbase, xsharp, "other.ppo");
    }
}
