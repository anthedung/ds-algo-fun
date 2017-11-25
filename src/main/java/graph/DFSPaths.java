package graph;

import graph.model.Graph;

import java.util.List;

public class DFSPaths implements Paths {
    private Graph g;
    private int startV;
    private int parent[];

    public DFSPaths(Graph g, int s) {
        this.g = g;
        this.startV = s;

        parent = new int[g.V()];
    }

    @Override
    public boolean hasPathTo(int v) {
        boolean[] marked = new boolean[g.V()];

        return dfs(startV, v, marked);
    }

    private boolean dfs(int startV, int v, boolean[] marked) {
        List<Integer> adj = g.adj(startV);

        for (Integer toVisit : adj) {
            parent[toVisit] = startV;

            if (!marked[toVisit]) {
                marked[toVisit] = true;

                return toVisit == v || dfs(toVisit, v, marked);
            }
        }

        return false;
    }

    @Override
    public List<Integer> pathTo(int v) {
        return null;
    }
}