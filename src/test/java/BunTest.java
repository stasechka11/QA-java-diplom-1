import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import praktikum.Bun;

import java.util.Random;

public class BunTest {
    private Bun bun;
    private String bunNameExpected;
    private Float bunPriceExpected;

    @Before
    public void setUp() {
        bunNameExpected = RandomStringUtils.randomAlphabetic(6);
        Random r = new Random();
        bunPriceExpected = r.nextFloat();
        bun = new Bun(bunNameExpected, bunPriceExpected);
    }

    @Test
    public void bunGetNameReturnsText() {
        Assert.assertEquals(bunNameExpected, bun.getName());
    }

    @Test
    public void bunGetPriceReturnsFloat() {
        Assert.assertEquals(bunPriceExpected, bun.getPrice(), 0);
    }
}
