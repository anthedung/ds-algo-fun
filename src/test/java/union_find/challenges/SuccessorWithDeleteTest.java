package union_find.challenges;

import junit.framework.TestCase;
import org.junit.Test;

public class SuccessorWithDeleteTest extends TestCase {

    @Test
    public void testSuccessor() {
        SuccessorWithDelete s = new SuccessorWithDelete(10);

        assertEquals(2, s.successor(2));
        s.remove(2);
        assertEquals(3, s.successor(2));
        s.remove(3);
        assertEquals(4, s.successor(2));
    }
}
