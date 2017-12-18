package cakes;

import junit.framework.TestCase;
import org.junit.Test;

public class CoinChangeTest extends TestCase {

    @Test
    public void testCoinChange() {
        assertEquals(5, CoinChangeCake.countWays(4, new int[]{1, 2, 3, 4}));
        assertEquals(0, CoinChangeCake.countWays(4, new int[]{5}));
    }
}
