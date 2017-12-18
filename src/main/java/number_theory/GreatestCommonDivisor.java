package number_theory;

/**
 * find the greatest common divisor of a,b
 */
public class GreatestCommonDivisor {

    // O(log(max(a,b))
    static int gcd(int a, int b) {
        if (b == 0) return a;

        return gcd(b, a % b);
    }
}
