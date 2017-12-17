package cakes;

import junit.framework.TestCase;
import org.junit.Test;

public class StockPickingTest extends TestCase {

    @Test
    public void testStockPicking() {
        int[] prices = new int[]{4, 5, 7, 2, 3, 10, 1};
        assertEquals(10 - 2, StockPicking.getMaxProfit(prices));
    }
}
