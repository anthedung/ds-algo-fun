package union_find;


/**
 * Strategy:
 * 1st enhancement is to cut the tree heights to reduce finding root op.
 * maintain a size of each tree root, and add the smaller tree to a bigger one at root
 */
class QuickUnionBalancedTree extends QuickUnion {
    // size to keep track of number of elements each tree from root
    // so that can join the smaller tree to a bigger one
    int[] size;

    QuickUnionBalancedTree(int N) {
        super(N);

        size = new int[N];
    }

    @Override
    public void union(int a, int b) {
        int rootA = root(a);
        int rootB = root(b);

        // if not connected then compare size of the tree
        if (rootA != rootB) {
            if (size[rootA] < size[rootB]) {
                UF[rootA] = rootB;
                size[rootB] = size[rootB] + size[rootA];
            } else {
                UF[rootB] = rootA;
                size[rootA] = size[rootA] + size[rootB];
            }
        }
    }

    @Override
    public boolean connected(int a, int b) {
        return root(a) == root(b);
    }

    int root(int i) {
        while (i != UF[i]) {
            i = UF[i];
        }

        return i;
    }
}
