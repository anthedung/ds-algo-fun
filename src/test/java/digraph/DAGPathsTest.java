package digraph;

import edu.princeton.cs.algs4.Digraph;
import junit.framework.TestCase;
import org.junit.Test;

public class DAGPathsTest extends TestCase {

    @Test
    public void testDAGPaths() {
        Digraph digraph = new Digraph(5);
        digraph.addEdge(0, 3);
        digraph.addEdge(3, 4);
        digraph.addEdge(1, 4);
        digraph.addEdge(2, 4);
        digraph.addEdge(1, 2);
        digraph.addEdge(0, 1);

        // 0 -> 1 -> 2 -> 4
        // \->3----------/

        assertTrue(DAGPaths.isDAG(digraph));
    }

    @Test
    public void testNotDAGPaths() {
        Digraph digraph = new Digraph(5);
        digraph.addEdge(0, 3);
        digraph.addEdge(1, 3);
        digraph.addEdge(0, 1);
        digraph.addEdge(2, 4);
        digraph.addEdge(2, 0);

        assertFalse(DAGPaths.isDAG(digraph));
    }
}
