package graph.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AdjacencyListGraph implements Graph {
    private Map<Integer, List<Integer>> adj; //use Set for distinct number of adj
    private final int V;
    private int countE;

    public AdjacencyListGraph(int V) { //init graph with V vertices
        this.V = V;

        adj = new HashMap<>();

        for (int i = 0; i < V; i++) {
            adj.put(i, new ArrayList<>());
        }
    }

    @Override
    public List<Integer> adj(int v) {
        return adj.get(v);
    }

    @Override
    public int V() {
        return V;
    }

    @Override
    public int E() {
        return countE;
    }

    @Override
    public void addEdge(int v, int w) {
        adj.get(v).add(w);
        adj.get(w).add(v);

        countE++;
    }
}
