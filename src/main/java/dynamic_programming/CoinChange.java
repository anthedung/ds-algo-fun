package dynamic_programming;

// give m money and n coin, how many ways to make coin
public class CoinChange {

    // method 1: recursive way 1
    public static long coinChangeRecursive(int m, int[] coins) {
        int coinTypes = coins.length;
        long[][] ways = new long[m + 1][coinTypes + 1];
        return coinChangeRecHelper(m, coins.length - 1, coins, ways);

    }

    private static long coinChangeRecHelper(int m, int coinType, int[] coins, long[][] ways) {
        if (ways[m][coinType] > 0) return ways[m][coinType];

        if (coinType == 0) {
            // last coin type left
            if (m % coins[coinType] == 0) {
                ways[m][coinType] = 1;
            } else {
                ways[m][coinType] = 0;
            }
        } else {
            if (m >= coins[coinType]) {
                // if m still more than this coin type
                // then ways = ways without this coin type + way with this coin type
                ways[m][coinType] = coinChangeRecHelper(m, coinType - 1, coins, ways)
                        + coinChangeRecHelper(m - coins[coinType], coinType, coins, ways);
            } else {
                // else ways = ways without this coin type (since this coin is bigger than remaining)
                ways[m][coinType] = coinChangeRecHelper(m, coinType - 1, coins, ways);
            }
        }

        return ways[m][coinType];
    }
}
