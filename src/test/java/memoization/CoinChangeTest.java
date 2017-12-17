package memoization;

import dynamic_programming.CoinChange;
import junit.framework.TestCase;
import org.junit.Test;

public class CoinChangeTest extends TestCase {

    @Test
    public void testCoinChange() {
        assertEquals(5, CoinChange.coinChangeRecursive(10, new int[]{2, 5, 3, 6}));
    }
}
