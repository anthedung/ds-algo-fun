package cakes;

import junit.framework.TestCase;
import org.junit.Test;

public class OkErosDatingTest extends TestCase {

    @Test
    public void testOkErosDating() {
        OkErosDating.Rectangle a = new OkErosDating.Rectangle(1, 1, 3, 2);
        OkErosDating.Rectangle b = new OkErosDating.Rectangle(2, 0, 3, 12);

        assertEquals(2, OkErosDating.findIntersection(a, b).getHeight());
        assertEquals(2, OkErosDating.findIntersection(a, b).getWidth());
    }

    @Test
    public void testOkErosDatingNonOverlap() {
        OkErosDating.Rectangle a = new OkErosDating.Rectangle(1, 1, 1, 1);
        OkErosDating.Rectangle b = new OkErosDating.Rectangle(3, 3, 3, 12);

        assertNull(OkErosDating.findIntersection(a, b));
    }
}
