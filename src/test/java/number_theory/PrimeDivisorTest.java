package number_theory;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * find all prime divisor of n
 */
public class PrimeDivisorTest extends TestCase {

    @Test
    public void testPrimeDivisor() {
        assertEquals(3, PrimeDivisor.primDivisor(18)[1]);
    }
}
