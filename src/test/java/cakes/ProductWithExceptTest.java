package cakes;

import junit.framework.TestCase;
import org.junit.Test;

public class ProductWithExceptTest extends TestCase {

    @Test
    public void testGetProductsOfAllIntsExceptAtIndex() {
        long[] prices = new long[]{1, 2, 3, 4, 5};
        long[] res = ProductWithExcept.getProductsOfAllIntsExceptAtIndex(prices);

        assertEquals(120, res[0]);
    }

    @Test
    public void testGetProductsOfAllIntsExceptAtIndexWithZero() {
        long[] prices = new long[]{0, 2, 3, 4, 5};
        long[] res = ProductWithExcept.getProductsOfAllIntsExceptAtIndex(prices);

        assertEquals(120, res[0]);
        assertEquals(0, res[1]);
    }
}
