package union_find.challenges;

/**
 * Problem:
 * Successor with delete. Given a set of n integers S={0,1,...,n−1} and a sequence of requests of the following form:
 * Remove x from S
 * Find the successor of x: the smallest y in S such that y≥x.
 * design a data type so that all operations (except construction) take logarithmic time or better in the worst case.
 * <p>
 * Solution:
 * Successor(x) = Largest(x) ~ Largest of component tree that contains x
 * Removal: Remove(x) = Union(x, x+1)
 */
public class SuccessorWithDelete {
    int N;
    int[] UF;
    int[] sz; //weighted tree
    int[] largest; //keep largest of each connected component

    SuccessorWithDelete(int N) {
        this.N = N;

        UF = new int[N];
        largest = new int[N];
        sz = new int[N];

        for (int i = 0; i < N; i++) {
            UF[i] = largest[i] = i;
            sz[i] = 1; // size all = 1
        }
    }

    void union(int a, int b) {
        int rA = root(a);
        int rB = root(b);

        if (rA == rB) return;

        if (rA < rB) {
            UF[rA] = UF[rB];
            sz[rA] += sz[rB];

            if (largest[rA] > largest[rB]) {
                largest[rB] = largest[rA];
            }
        } else {
            UF[rB] = UF[rA];
            sz[rA] += sz[rA];

            if (largest[rA] < largest[rB]) {
                largest[rA] = largest[rB];
            }
        }
    }

    int root(int a) {
        while (a != UF[a]) {
            UF[a] = UF[UF[a]]; // cut tree height
            a = UF[a];
        }

        return a;
    }

    int successor(int a) {
        return largest[root(a)];
    }

    void remove(int a) {
        union(a, a + 1);
    }

    public static void main(String[] args) {
        SuccessorWithDelete s = new SuccessorWithDelete(10);

        System.out.println(s.successor(2));
        s.remove(2);
        System.out.println(s.successor(2));
    }
}
