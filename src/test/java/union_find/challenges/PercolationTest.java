package union_find.challenges;

import junit.framework.TestCase;
import org.junit.Test;

public class PercolationTest extends TestCase {

    @Test
    public void testConvertIndex() {
        Percolation p = new Percolation(10);

        assertEquals(0, p.convertIndex(1, 1));
        assertEquals(1, p.convertIndex(1, 2));
        assertEquals(10, p.convertIndex(2, 1));
        assertEquals(23, p.convertIndex(3, 4));
    }

    @Test
    public void testPercolation() {
        Percolation p = new Percolation(4);
        p.printGrid();
        assertEquals(0, p.numberOfOpenSites());

        System.out.println("\nopen 1 3");
        p.open(1, 3);
        p.printGrid();
        assertEquals(1, p.numberOfOpenSites());

        System.out.println("\nopen 2 3");
        p.open(2, 3);
        p.printGrid();
        assertEquals(2, p.numberOfOpenSites());
        assertTrue(p.isFull(2, 3))
        ;
        System.out.println("\nopen 2 2");
        p.open(2, 2);
        p.printGrid();
        assertEquals(3, p.numberOfOpenSites());

        System.out.println("\nopen 3 2");
        p.open(3, 2);
        p.printGrid();

        System.out.println("\nopen 3 2");
        p.open(4, 4);
        p.printGrid();

        System.out.println("\nopen 4 2");
        p.open(4, 2);
        p.printGrid();
        assertTrue(p.percolates());
    }
}
