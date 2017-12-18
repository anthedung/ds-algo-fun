package number_theory;

public class BinaryExponentiation {

    static long binExp(int x, int n) {
        if (n < 2) return x;

        return n % 2 == 0
                ? binExp(x * x, n / 2)
                : x * binExp(x * x, n / 2);
    }
}
