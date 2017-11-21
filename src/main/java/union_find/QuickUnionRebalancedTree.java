package union_find;

/**
 * further enhancement to the balanced tree
 * cutting down the tree height while traveling to root by attempting to set root of an element to an immediate root of its root
 */
public class QuickUnionRebalancedTree extends QuickUnionBalancedTree {

    public QuickUnionRebalancedTree(int N) {
        super(N);
        size = new int[N];
    }

    @Override
    public boolean connected(int a, int b) {
        return root(a) == root(b);
    }

    @Override
    public int root(int i) {
        while (i != UF[i]) {
            UF[i] = UF[UF[i]];
            i = UF[i];
        }

        return i;
    }
}
