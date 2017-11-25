package graph;

import graph.model.Graph;

import java.util.List;

public class BFSPaths implements Paths {
    private Graph g;
    private int startVertice;

    public BFSPaths(Graph g, int s) {
        this.g = g;
        this.startVertice = s;
    }

    @Override
    public boolean hasPathTo(int v) {
        return false;
    }

    @Override
    public List<Integer> pathTo(int v) {
        return null;
    }
}