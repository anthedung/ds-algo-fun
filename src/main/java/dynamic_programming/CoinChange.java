package dynamic_programming;

// give m money and n coin, how many ways to make coin
public class CoinChange {

    // method 1: recursive way 1
    public static long coinChangeRecursive(int m, int[] coins) {
        return coinChangeRecHelper(m, coins.length - 1, coins, new long[m + 1][coins.length]);

    }

    private static long coinChangeRecHelper(int m, int coinType, int[] coins, long[][] ways) {
        if (ways[m][coinType] > 0) return ways[m][coinType];

        if (coinType == 0) {
            // last coin type left
            ways[m][coinType] = (m % coins[coinType] == 0) ? 1 : 0;
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

    public static long coinChangeBottomUp(int m, int[] coins) {
        // add a theoretical coin = 0
        int[] updatedCoins = new int[coins.length + 1];
        updatedCoins[0] = 0;
        for (int i = 0; i < coins.length; i++) {
            updatedCoins[i + 1] = coins[i];
        }

        coins = updatedCoins;

        long[][] memo = new long[m + 1][coins.length + 1];

        memo[0][0] = 1; // theoretically, there is 1 way to pay 0 with 0;


        // logic is memo[m][n] = memo[m][n-1] + memo[m-coins[n]][n]
        // i.e. number of ways for amt m and 0->n coins = ways to make without it + ways to make with it
        // both of these values are sub-problems and should have been calculate.
        for (int amt = 0; amt <= m; amt++) {
            for (int i = 0; i < coins.length; i++) {
                if (amt == 0 && i == 0) continue; // skip the first 0,0 as already calculated;

                if (amt - coins[i] >= 0)
                    memo[amt][i] += memo[amt - coins[i]][i];

                if (i >= 1)
                    memo[amt][i] += memo[amt][i - 1];
            }
        }

        return memo[m][coins.length - 1];
    }
}
