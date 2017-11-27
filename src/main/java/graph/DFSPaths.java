package graph;

import graph.model.Graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DFSPaths implements Paths {
    private Graph g;
    private int startV;
    private int parent[];
    boolean[] marked;

    public DFSPaths(Graph g, int s) {
        this.g = g;
        this.startV = s;

        parent = new int[g.V()];

        boolean[] marked = new boolean[g.V()];
        dfs(s);
    }

    @Override
    public boolean hasPathTo(int v) {

        return marked[v];
    }

    private boolean dfs(int startV) {
        for (Integer toVisit : g.adj(startV)) {
            parent[toVisit] = startV;

            if (!marked[toVisit]) {
                marked[toVisit] = true;

                dfs(toVisit);
            }
        }

        return false;
    }

    @Override
    public Iterable<Integer> pathTo(int v) {
        Stack<Integer> pathStack = new Stack<>();

        while (startV != v) {
            pathStack.push(v);
            v = parent[v];
        }

        List<Integer> path = new ArrayList<>();

        while (!pathStack.empty())
            path.add(pathStack.pop());

        return path;
    }
}