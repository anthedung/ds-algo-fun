package union_find;

import java.util.Arrays;

public abstract class UnionFinder {
    protected int[] UF;

    public UnionFinder(int N) {
        UF = new int[N];

        for (int i = 0; i < N; i++) {
            UF[i] = i;
        }
    }

    public UnionFinder(int[] UF) {
        this.UF = UF;
    }

    public abstract void union(int a, int b);

    public abstract boolean connected(int a, int b);

    void show() {
        int[] index = new int[UF.length];

        for (int i = 0; i < UF.length; i++) {
            index[i] = i;
        }
        System.out.println(this.getClass().getSimpleName() + ":\n" + Arrays.toString(index));
        System.out.println(Arrays.toString(UF));
    }

//    public abstract void showConnectedComponents();
}
