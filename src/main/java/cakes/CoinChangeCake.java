package cakes;

/**
 * Q5: given int amount and int[] coins => how many ways to count
 */
public class CoinChangeCake {
    static long countWays(int amount, int[] coins) {
        return countWaysHelper(amount, coins.length - 1, coins, new long[amount + 1][coins.length + 1]);
    }

    private static long countWaysHelper(int amt, int coinType, int[] coins, long[][] ways) {
        if (ways[amt][coinType] > 0) return ways[amt][coinType];

        if (coinType == 0) {
            // last coinType
            ways[amt][coinType] = (amt % coins[coinType] == 0) ? 1 : 0;
        } else {
            if (amt >= coins[coinType]) {
                // if amt > value of coin =>
                // ways = way with coin type + ways without this coin type
                ways[amt][coinType] = countWaysHelper(amt - coins[coinType], coinType, coins, ways)
                        + countWaysHelper(amt, coinType - 1, coins, ways);
            } else {
                ways[amt][coinType] = countWaysHelper(amt, coinType - 1, coins, ways);
            }
        }

        return ways[amt][coinType];
    }
}

