package union_find;


/**
 * Strategy:
 * union(a,b) => make UF(a) = b ~ root of a = b
 */
class QuickUnion extends UnionFinder {
    QuickUnion(int N) {
        super(N);
    }

    @Override
    public void union(int a, int b) {
        if (!connected(a, b)) {
            UF[root(a)] = b;
        }
    }

    @Override
    public boolean connected(int a, int b) {
        return root(a) == root(b);
    }

    private int root(int i) {
        while (i != UF[i]) {
            i = UF[i];
        }

        return i;
    }
}
