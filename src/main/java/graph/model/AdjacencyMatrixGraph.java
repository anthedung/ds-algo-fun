package graph.model;

import java.util.ArrayList;
import java.util.List;

public class AdjacencyMatrixGraph implements Graph {
    private int[][] adjMatrix;
    private final int N;
    private int countE;

    public AdjacencyMatrixGraph(int N) {
        this.N = N;
        adjMatrix = new int[N][N];
    }

    @Override
    public List<Integer> adj(int v) {
        List<Integer> adj = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            if (adjMatrix[v][i] != 0)
                adj.add(i);
        }

        return adj;
    }

    @Override
    public int V() {
        return 0;
    }

    @Override
    public int E() {
        return countE;
    }

    @Override
    public void addEdge(int v, int w) {
        countE++;
        adjMatrix[v][w] = 1;
        adjMatrix[w][v] = 1;
    }
}
