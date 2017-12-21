package cakes;

import junit.framework.TestCase;
import org.junit.Test;
import tree.Node;

public class SuperBalancedTreeTest extends TestCase {

    @Test
    public void testSuperBalance() {
        Node node = new Node();
        Node n = node.insertLeft(10);
        n.insertRight(12).insertLeft(9);

        n = node.insertRight(7);
        n.insertLeft(8).insertRight(17).insertRight(12).insertRight(12).insertRight(12);

        assertFalse(SuperBalancedTree.superBalance(node));
    }
}
