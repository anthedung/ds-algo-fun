package dynamic_programming;

// Fibonacci seq:
// idx: 0,1,2,3,4,5,6,7
// fib: 0,1,1,2,3,5,8,13
public class Fibonacci {
    // number of function calls compare;
    private int fnCallCount = 0;

    public int getFnCallCount() {
        return fnCallCount;
    }

    /**
     * general memoization with recursive technique
     *
     * @param n
     * @return
     */
    public int memoizeFib(int n) {
        int[] cache = new int[n + 1];

        int res = memoizeFibHelper(n, cache);
        return res;
    }

    private int memoizeFibHelper(int n, int[] cache) {
        fnCallCount++;

        if (n < 2) {
            cache[n] = n;
            return n;
        }

        if (cache[n] > 0) {
            return cache[n];
        }

        int res = memoizeFibHelper(n - 1, cache) + memoizeFibHelper(n - 2, cache);
        // memoizeFibHelper(n - 2, cache) is already cached => no need for further computation
        cache[n] = res;

        return res;
    }

    /**
     * Slow Recursive
     *
     * @param n
     * @return
     */
    public int slowFib(int n) {
        fnCallCount++;

        if (n < 2) {
            return n;
        }

        return slowFib(n - 1) + slowFib(n - 2);
    }

    /**
     * get fib(n)
     * @param n
     * @return
     */
    public int xyFib(int n) {
        int x = 0;
        int y = 1;

        if (n < 2) {
            return n;
        }
        int fib = 1;
        for (int i = 2; i < n + 1; i++) {
            int tmp = fib;

            fib = x + y;

            x = tmp;
            y = fib;
        }

        return fib;
    }
}
