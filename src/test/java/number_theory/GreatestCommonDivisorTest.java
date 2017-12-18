package number_theory;

import junit.framework.TestCase;
import org.junit.Test;

public class GreatestCommonDivisorTest extends TestCase {

    @Test
    public void testGCD() {
        assertEquals(3, GreatestCommonDivisor.gcd(9, 15));
    }
}
