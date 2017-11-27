package digraph.challenges.wordnet;

import edu.princeton.cs.algs4.BreadthFirstDirectedPaths;
import edu.princeton.cs.algs4.Digraph;

public class SAP {
    private final Digraph digraph;

    // constructor takes a digraph (not necessarily a DAGPaths)
    public SAP(Digraph G) {
        digraph = new Digraph(G);
    }

    // length of shortest ancestral path between v and w; -1 if no such path
    public int length(int v, int w) {
        checkArg(v, w);
        BreadthFirstDirectedPaths pathsV = new BreadthFirstDirectedPaths(digraph, v);
        BreadthFirstDirectedPaths pathsW = new BreadthFirstDirectedPaths(digraph, w);

        return lengthHelper(pathsV, pathsW);
    }

    // a common ancestor of v and w that participates in a shortest ancestral path; -1 if no such path
    public int ancestor(int v, int w) {
        checkArg(v, w);
        BreadthFirstDirectedPaths pathsV = new BreadthFirstDirectedPaths(digraph, v);
        BreadthFirstDirectedPaths pathsW = new BreadthFirstDirectedPaths(digraph, w);

        return ancestorHelper(pathsV, pathsW);
    }

    // length of shortest ancestral path between any vertex in v and any vertex in w; -1 if no such path
    public int length(Iterable<Integer> v, Iterable<Integer> w) {
        BreadthFirstDirectedPaths pathsV = new BreadthFirstDirectedPaths(digraph, v);
        BreadthFirstDirectedPaths pathsW = new BreadthFirstDirectedPaths(digraph, w);

        return lengthHelper(pathsV, pathsW);
    }

    // a common ancestor that participates in shortest ancestral path; -1 if no such path
    public int ancestor(Iterable<Integer> v, Iterable<Integer> w) {
        BreadthFirstDirectedPaths pathsV = new BreadthFirstDirectedPaths(digraph, v);
        BreadthFirstDirectedPaths pathsW = new BreadthFirstDirectedPaths(digraph, w);

        return ancestorHelper(pathsV, pathsW);
    }


    private void checkArg(int... args) {
        for (int i = 0; i < args.length; i++) {
            if (args[i] < 0 || args[i] > digraph.V() - 1) throw new IllegalArgumentException();
        }
    }

    private int ancestorHelper(BreadthFirstDirectedPaths pathsV, BreadthFirstDirectedPaths pathsW) {
        int minLength = Integer.MAX_VALUE;
        int sap = -1;
        for (int i = 0; i < digraph.V(); i++) {
            if (pathsV.hasPathTo(i) && pathsW.hasPathTo(i)) {
                int len = pathsV.distTo(i) + pathsW.distTo(i);

                if (len < minLength) {
                    minLength = len;
                    sap = i;
                }
            }
        }

        return sap;
    }

    private int lengthHelper(BreadthFirstDirectedPaths pathsV, BreadthFirstDirectedPaths pathsW) {
        int minLength = -1;
        for (int i = 0; i < digraph.V(); i++) {
            if (pathsV.hasPathTo(i) && pathsW.hasPathTo(i)) {
                int len = pathsV.distTo(i) + pathsW.distTo(i);

                if (len < minLength || minLength == -1) {
                    minLength = len;
                }
            }
        }

        return minLength;
    }
}