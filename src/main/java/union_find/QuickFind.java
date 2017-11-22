package union_find;

import java.util.*;

class QuickFind extends UnionFinder {
    QuickFind(int N) {
        super(N);
    }

    public void union(int a, int b) {
        int aid = UF[a];
        int bid = UF[b];
        for (int i = 0; i < UF.length; i++) {
            if (UF[i] == aid) {
                UF[i] = bid;
            }
        }
    }

    public boolean connected(int a, int b) {
        return this.UF[a] == this.UF[b];
    }
}
