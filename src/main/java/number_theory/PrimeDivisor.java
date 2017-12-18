package number_theory;

import java.util.ArrayList;
import java.util.List;

/**
 * find all prime divisor of n
 */
public class PrimeDivisor {

    public static int[] primDivisor(int n) {
        List<Integer> div = new ArrayList<>();

        while (n % 2 == 0) {
            div.add(2);
            n = n / 2;
        }

        // if div x1, x2 ... of n exist, at least there is 1 x < sqrt(n), else, x1 * x2 > n
        int bound = (int) Math.sqrt(n) + 1;
        for (int k = 3; k < bound; k += 2) {
            while (n % k == 0) {
                div.add(k);
                n = n / k;
            }
        }

        // after factorize, n still > 0 => n must be prime
        if (n > 0) div.add(n);

        int l = div.size();
        int[] res = new int[l];

        for (int i = 0; i < l; i++)
            res[i] = div.get(i);

        return res;
    }
}
