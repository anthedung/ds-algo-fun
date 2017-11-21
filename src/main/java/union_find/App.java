package union_find;

public class App {

    public static void main(String[] args) {
        final int N = 10;

        UnionFinder quickFind = new QuickFind(N);
        UnionFinder quickUnion = new QuickUnion(N);
        UnionFinder balancedTree = new QuickUnionBalancedTree(N);
        UnionFinder rebalancedTree = new QuickUnionRebalancedTree(N);

        experiment(quickFind);
        experiment(quickUnion);
        experiment(balancedTree);
        experiment(rebalancedTree);
    }

    // 1. perform some unions on the set
    // 2. calculate elapsed time for each Strategy
    private static void experiment(UnionFinder uf) {
        long startTime = System.nanoTime();

        uf.union(1, 0);
        uf.union(4, 1);
        uf.union(3, 6);
        uf.union(2, 7);
        uf.union(3, 2);
        uf.union(1, 6);
        uf.union(5, 9);
        uf.union(5, 9);
        uf.union(2, 0); // 0,1,3,4,6,2,7 | 8 | 5,9
        long estimatedTime = System.nanoTime() - startTime;
        uf.show();

//        uf.showConnectedComponents();
        System.out.printf("*** Elapsed : " + estimatedTime + "\n\n");
    }
}
