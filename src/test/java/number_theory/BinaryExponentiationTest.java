package number_theory;

import junit.framework.TestCase;
import org.junit.Test;

public class BinaryExponentiationTest extends TestCase {

    @Test
    public void testBinExp() {
        assertEquals(1024, BinaryExponentiation.binExp(2, 10));
        assertEquals(2048, BinaryExponentiation.binExp(2, 11));
    }

}
