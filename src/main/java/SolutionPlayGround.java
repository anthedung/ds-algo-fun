import java.util.*;

public class SolutionPlayGround {

    static int[] minimumZooNumbers(int m, int n, char[] t, int[] s, int[] d) {
        t = convertToBase1(t);
        s = convertToBase1(s);
        d = convertToBase1(d);

        // Return a list of length n consisting of the answers
        // starting from 1
        int[] minX = new int[m + 1];
        List<Order> orders = new ArrayList<>();
        Map<Integer, List<Order>> fromMap = new HashMap<>();

        for (int i = 1; i < n + 1; i++) {
            Order o = new Order(t[i], s[i], d[i]);
            orders.add(o);

            if (fromMap.get(s[i]) == null)
                fromMap.put(s[i], new ArrayList<>());
            fromMap.get(s[i]).add(o);
        }

        Collections.sort(orders);

        for (Order o : orders)
            System.out.println(o);

        List<Order> loaded = new ArrayList<>();

        // try from start;
        loadAndUnload(loaded, 1, m, n, minX, 0, fromMap);

        System.out.println(Arrays.toString(minX));

        // now I got minX;
        int[] results = new int[n];

        FIND_SMALLEST:
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (minX[j] >= i) {
                    results[i - 1] = j;
                    continue FIND_SMALLEST;
                }
            }
            results[i - 1] = -1;
        }

        System.out.println(Arrays.toString(results));
        return results;
    }

    private static int[] convertToBase1(int[] arr) {
        int[] newArr = new int[arr.length + 1];

        newArr[0] = -1;

        for (int i = 0; i < arr.length; i++)
            newArr[i+1] = arr[i];

        return newArr;
    }

    private static char[] convertToBase1(char[] arr) {
        char[] newArr = new char[arr.length + 1];

        newArr[0] = '0';

        for (int i = 0; i < arr.length; i++)
            newArr[i+1] = arr[i];

        return newArr;
    }

    private static void loadAndUnload(List<Order> loaded, int s, int zooNumber, int numOfAnmials, int[] minX, int animalMovedCount, Map<Integer, List<Order>> fromMap) {
        // try from start
        if (s == zooNumber + 1) return;

        // STEP 1: unloaded
        for (int j = 0; j < loaded.size(); j++) {
            Order o = loaded.get(j);
            if (o.to == s) {
                animalMovedCount++;
                minX[s] = Math.max(animalMovedCount, minX[s]); // number of animals can move with this
                if (animalMovedCount == numOfAnmials) {
                    throw new IllegalArgumentException();
                }
                loaded.remove(o);
                j--;
            }
        }

        // STEP 2: now loading
        List<Order> inZoo = fromMap.get(s);
        if (inZoo != null) { // some animals in this zoo

            List<List<Order>> waysToLoad = waysToLoad(loaded, inZoo);

            for (List<Order> l : waysToLoad) {
                loadAndUnload(l, s + 1, zooNumber, numOfAnmials, minX, animalMovedCount, fromMap);
            }
        } else {
            loadAndUnload(loaded, s + 1, zooNumber, numOfAnmials, minX, animalMovedCount, fromMap);
        }
    }

    // exhaustive
    // from taking 0, to taking all eligible
    // loadedSet to check for colliding permission
    private static List<List<Order>> waysToLoad(List<Order> loaded, List<Order> inZoo) {
        List<List<Order>> lol = new ArrayList<>();
        for (int i = 0; i < inZoo.size(); i++) {
            List<Order> l = new ArrayList<Order>();

            // create new loaded and set of name
            Set<Character> loadedSet = new HashSet<>();
            for (int j = 0; j < loaded.size(); j++) {
                Order o = loaded.get(j);
                l.add(o);
                loadedSet.add(o.animal);
            }

            for (int j = i; j < inZoo.size(); j++) {
                Order o = inZoo.get(j);

                if (isEligible(o, loadedSet)) {
                    l.add(o);
                    loadedSet.add(o.animal);
                }
            }

            if (l.size() > loaded.size())
                lol.add(l);
        }
        lol.add(loaded); // including not taking any

        return lol;
    }

    private static boolean isEligible(Order o, Set<Character> loadedSet) {
        char n = o.animal;
        switch (n) {
            case 'E':
                return !loadedSet.contains('M') && !loadedSet.contains('D');
            case 'D':
                return !loadedSet.contains('E') && !loadedSet.contains('C');
            case 'C':
                return !loadedSet.contains('D') && !loadedSet.contains('M');
            case 'M':
                return !loadedSet.contains('C') && !loadedSet.contains('E');
        }

        return false;
    }

    // unload as many as possible, of course
    //

    private static class Order implements Comparable<Order> {
        char animal;
        int from;
        int to;

        Order(char a, int f, int t) {
            animal = a;
            from = f;
            to = t;
        }

        public int compareTo(Order that) {
            if (from > that.from) return 1;
            if (from < that.from) return -1;

            // if from equals, compare using to
            if (to > that.to) return 1;
            if (to < that.to) return -1;

            return 0; // else equals
        }

        public String toString() {
            return animal + " f:" + from + " t:" + to;
        }

        public boolean equals(Object that) {
            return animal == ((Order) that).animal
                    && from == ((Order) that).from
                    && to == ((Order) that).to;
        }

        public int hashCode() {
            return (animal + "").hashCode() + from * 9 + to * 99;
        }
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int m = 10;
        char[] t = new char[]{'E', 'D', 'C', 'M', 'E', 'D'};

        int[] s = new int[]{1, 1, 1, 2, 9, 7};
        int[] d = new int[]{2, 2, 2, 4, 10, 10};

        int[] result = minimumZooNumbers(m, t.length, t, s, d);

//        for (int a0 = 0; a0 < cases; a0++) {
//            int m = in.nextInt();
//            int n = in.nextInt();
//            char[] t = new char[n];
//            for (int t_i = 0; t_i < n; t_i++) {
//                t[t_i] = in.next().charAt(0);
//            }
//            int[] s = new int[n];
//            for (int s_i = 0; s_i < n; s_i++) {
//                s[s_i] = in.nextInt();
//            }
//            int[] d = new int[n];
//            for (int d_i = 0; d_i < n; d_i++) {
//                d[d_i] = in.nextInt();
//            }
//
//            int[] result = minimumZooNumbers(m, n, t, s, d);
//            for (int i = 0; i < result.length; i++) {
//                System.out.print(result[i] + (i != result.length - 1 ? " " : ""));
//            }
//            System.out.println("");
//        }
        in.close();
    }
}

