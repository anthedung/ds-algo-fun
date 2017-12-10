package graph;

import graph.model.AdjacencyListGraph;
import graph.model.Graph;
import junit.framework.TestCase;
import org.junit.Test;

public class GraphTest extends TestCase {

    @Test
    public void testAdjListGraph() {
        Graph g = new AdjacencyListGraph(10);
        assertEquals(0, g.E());
        assertEquals(10, g.V());

        g.addEdge(0, 3);
        assertEquals(1, g.E());
        assertEquals(10, g.V());
        assertEquals(1, g.adj(0).size());
        assertEquals(1, g.adj(3).size());
    }
}
