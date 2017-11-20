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

//    @Override
    public void showConnectedComponents() {
        Map<Integer, ArrayList<Integer>> connectedComponents = new HashMap<>();

        for (int i = 0; i < UF.length; i++) {
            ArrayList<Integer> components = connectedComponents.get(i);
            if (components == null) {
                components = new ArrayList<>();
                components.add(i);
            }
        }

        /* printing the components */
        for (Map.Entry<Integer, ArrayList<Integer>> e : connectedComponents.entrySet()) {
            System.out.println(e.getKey() + ": " + Arrays.toString(e.getValue().toArray()));
        }
    }
}
