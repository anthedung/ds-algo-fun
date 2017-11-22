package union_find.challenges;

import union_find.QuickUnionRebalancedTree;

/**
 * Union-find with specific canonical element.
 * Add a method 𝚏𝚒𝚗𝚍() to the union-find data type so that 𝚏𝚒𝚗𝚍(𝚒) returns the largest element in the connected component containing i.
 * The operations, 𝚞𝚗𝚒𝚘𝚗(), 𝚌𝚘𝚗𝚗𝚎𝚌𝚝𝚎𝚍(), and 𝚏𝚒𝚗𝚍() should all take logarithmic time or better.
 * <p>
 * For example, if one of the connected components is {1,2,6,9}, then the 𝚏𝚒𝚗𝚍() method should
 * return 9 for each of the four elements in the connected components.
 * <p>
 * <p>
 * Proposed solution: create another array contain the largest element of each root
 * Update it when union
 */
class UnionFindLargest extends QuickUnionRebalancedTree {
    static int N = 10;
    int[] largest = new int[N];

    UnionFindLargest(int N) {
        super(N);

        System.arraycopy(UF, 0, largest, 0, N);
    }

    int find(int i) {
        int l = largest[root(i)];
        System.out.println(l);

        return l;
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

                if (largest[rootB] < largest[rootA]) {
                    largest[rootB] = largest[rootA];
                }
            } else {
                UF[rootB] = rootA;
                size[rootA] = size[rootA] + size[rootB];

                if (largest[rootA] < largest[rootB]) {
                    largest[rootA] = largest[rootB];
                }
            }
        }
    }

    public static void main(String[] args) {
        UnionFindLargest uf = new UnionFindLargest(N);

        uf.union(1, 0);
        uf.union(4, 1);
        uf.union(3, 6);
        uf.union(2, 7);
        uf.union(3, 2);
        uf.union(1, 6);
        uf.union(5, 9);
        uf.union(5, 9);
        uf.union(2, 0); // 0,1,3,4,6,2,7 | 8 | 5,9

        uf.find(3);
        uf.find(2);
        uf.find(8);
        uf.find(5);
    }
}
