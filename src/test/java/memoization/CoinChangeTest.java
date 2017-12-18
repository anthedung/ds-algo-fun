package memoization;

import dynamic_programming.CoinChange;
import junit.framework.TestCase;
import org.junit.Test;

public class CoinChangeTest extends TestCase {

    @Test
    public void testCoinChange() {
        assertEquals(5, CoinChange.coinChangeRecursive(10, new int[]{2, 5, 3, 6}));
        assertEquals(4, CoinChange.coinChangeRecursive(4, new int[]{1, 2, 3}));
    }

    @Test
    public void testCoinChangeBottom() {
        assertEquals(5, CoinChange.coinChangeBottomUp(10, new int[]{2, 5, 3, 6}));
        assertEquals(4, CoinChange.coinChangeBottomUp(4, new int[]{1, 2, 3}));
    }
}
