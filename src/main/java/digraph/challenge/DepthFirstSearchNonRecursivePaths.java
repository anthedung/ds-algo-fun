package digraph.challenge;

import edu.princeton.cs.algs4.Digraph;

import java.util.*;

// Non-recursive depth-first search.
// Implement depth-first search in an undirected graph without using recursion.
public class DepthFirstSearchNonRecursivePaths {
    private final Digraph digraph;
    private final int v;
    private boolean[] marked;

    public DepthFirstSearchNonRecursivePaths(Digraph digraph, int v) {
        this.digraph = digraph;
        this.v = v;

        marked = new boolean[digraph.V()];

        Stack<Integer> s = new Stack<>();
        s.push(v);
        dfs(s);
    }

    private void dfs(Stack<Integer> queue) {
        while (!queue.isEmpty()) {
            int ele = queue.pop();
            marked[ele] = true;
            for (int v : digraph.adj(ele)) {
                if (!marked[v]) {
                    queue.push(v);
                }
            }
        }
    }

    public boolean hasPathTo(int v) {
        return marked[v];
    }
}
