package union_find;


/**
 * Strategy:
 * union(a,b) => make UF(a) = b ~ root of a = b
 */
class QuickUnion extends UnionFinder {
    QuickUnion(int N) {
        super(N);
    }

    QuickUnion(int[] UF) {
        super(UF);
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

//    @Override
    public void showConnectedComponents() {
        for (int i = 0; i < UF.length; i++) {
            System.out.print("[ ");
            if (i == UF[i]) {

            }
            System.out.print("]  ||  ");
        }
        System.out.println("");
    }
}
