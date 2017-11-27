package digraph;

import edu.princeton.cs.algs4.Digraph;

// Question: Check if a graph is a directed acyclic graph
public class DAGPaths {
    // check if graph is a DAGPaths, using sort
    public static boolean isDAG(Digraph digraph) {
        return !hasAnyCircle(digraph);
    }

    public static boolean hasAnyCircle(Digraph digraph) {
        boolean[] marked = new boolean[digraph.V()];
        boolean[] onPath = new boolean[digraph.V()];

        // check if dfs meet anyone on its path again
        // mark the path along the branch, but if rollback (exit recursive call) then clear the mark
        for (int i = 0; i < digraph.V(); i++) {
            if (dfs(digraph, i, marked, onPath)) {
                return true;
            }
        }
        return false;
    }

    private static boolean dfs(Digraph g, int s, boolean[] marked, boolean[] onPath) {
        marked[s] = true;
        onPath[s] = true;
        for (int v : g.adj(s)) {
            if (onPath[v]) {
                return true;
            }

            if (!marked[v]) {
                dfs(g, v, marked, onPath);
                onPath[v] = false; // on the way back, clear its mark onPath
            }
        }

        return false;
    }
}
