package graph.model;

import java.util.List;

public interface Graph {
    List<Integer> adj(int v);

    int V(); // number of vertices

    int E(); // number of edges

    void addEdge(int v, int w);

    @Override
    String toString();
}
