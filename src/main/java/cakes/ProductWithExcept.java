package cakes;

/**
 * You have an array of integers, and for each index you want to
 * find the product of every integer except the integer at that index.
 * solution:
 * get prod of all before * all after
 * O(n) time and just need another array of n O(n) space
 */
public class ProductWithExcept {

    static long[] getProductsOfAllIntsExceptAtIndex(long[] a) {
        assert a != null && a.length > 0;
        if (a.length == 1) return a;

        // O(n
        long[] prod = new long[a.length];

        // O(n
        int prodSofar = 1;
        for (int i = 0; i < a.length; i++) {
            prod[i] = prodSofar;
            prodSofar *= a[i];
        }

        // O(n
        prodSofar = 1;
        for (int i = a.length - 1; i >= 0; i--) {
            prod[i] *= prodSofar;
            prodSofar *= a[i];
        }

        return prod;
    }
}
