package union_find.challenges;

import junit.framework.TestCase;
import org.junit.Test;

public class UnionFindLargestTest extends TestCase {

    @Test
    public void testFindLargest() {
        UnionFindLargest uf = new UnionFindLargest(10);

        uf.union(1, 0);
        uf.union(4, 1);
        uf.union(3, 6);
        uf.union(2, 7);
        uf.union(3, 2);
        uf.union(1, 6);
        uf.union(5, 9);
        uf.union(5, 9);
        uf.union(2, 0); // 0,1,3,4,6,2,7 | 8 | 5,9

        assertEquals(uf.find(3), 7);
        assertEquals(uf.find(2), 7);
        assertEquals(uf.find(8), 8);
        assertEquals(uf.find(5), 9);
    }
}

