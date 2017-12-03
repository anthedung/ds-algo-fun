package union_find.challenges;

import junit.framework.TestCase;
import org.junit.Test;

public class PercolationTest extends TestCase {

    @Test
    public void testPercolation() {
        Percolation p = new Percolation(4);
        assertEquals(0, p.numberOfOpenSites());

        System.out.println("\nopen 1 3");
        p.open(1, 3);
        assertEquals(1, p.numberOfOpenSites());

        System.out.println("\nopen 2 3");
        p.open(2, 3);
        assertEquals(2, p.numberOfOpenSites());
        assertTrue(p.isFull(2, 3))
        ;
        System.out.println("\nopen 2 2");
        p.open(2, 2);
        assertEquals(3, p.numberOfOpenSites());

        System.out.println("\nopen 3 2");
        p.open(3, 2);

        System.out.println("\nopen 3 2");
        p.open(4, 4);

        System.out.println("\nopen 4 2");
        p.open(4, 2);
        assertTrue(p.percolates());
    }
}
