package tree;

import junit.framework.TestCase;
import org.junit.Test;
import tree.bst.BST;

import java.util.List;

public class BSTTest extends TestCase {

    @Test
    public void testBSTAdd() {
        BST bst = new BST();

        bst.add(10);
        bst.add(12);
        bst.add(9);
        bst.add(7);
        bst.add(1);
        bst.add(17);
    }

    @Test
    public void testBSTInOrder() {
        BST bst = new BST();

        bst.add(10);
        bst.add(12);
        bst.add(9);
        bst.add(7);
        bst.add(1);
        bst.add(17);

        List<Integer> l = bst.inOrder();

        for (int i : l)
            System.out.println(i);

        assertEquals(7, (int) l.get(1));
    }


    @Test
    public void testBSTRemove() {
        BST bst = new BST();

        bst.add(10);
        bst.add(12);
        bst.add(9);
        bst.add(7);
        bst.add(1);
        bst.add(8);
        bst.add(17);

        List<Integer> l = bst.inOrder();
        for (int i : l)
            System.out.print(i + " ");
        assertEquals(7, (int) l.get(1));

        System.out.println("removed...");

        bst.remove(10);
        l = bst.inOrder();
        for (int i : l)
            System.out.print(i + " ");
        assertEquals(12, (int) l.get(4));

    }
}
