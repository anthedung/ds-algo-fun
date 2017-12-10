package digraph.challenge;


import edu.princeton.cs.algs4.Digraph;
import junit.framework.TestCase;
import org.junit.Test;

public class DepthFirstSearchNonRecursivePathsTest extends TestCase {

    @Test
    public void testNonRecursiveDfs(){
        Digraph d = new Digraph(8);
        d.addEdge(0,1);
        d.addEdge(1,2);
        d.addEdge(2,3);
        d.addEdge(0,5);
        d.addEdge(5,6);
        d.addEdge(4,7);

        DepthFirstSearchNonRecursivePaths dfsPaths = new DepthFirstSearchNonRecursivePaths(d, 0);

        assertTrue(dfsPaths.hasPathTo(3));
        assertTrue(dfsPaths.hasPathTo(6));
        assertFalse(dfsPaths.hasPathTo(7));
    }
}
