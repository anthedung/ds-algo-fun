package cakes;

public class StockPicking {

    /**
     * given stock prices, get the max possible value with 1 buy 1 sell
     *
     * @param stockPricesYesterday
     * @return
     */
    static int getMaxProfit(int[] stockPricesYesterday) {
        int maxProfit = 0;
        int lowest = Integer.MAX_VALUE;

        for (int i = 0; i < stockPricesYesterday.length; i++) {
            int p = stockPricesYesterday[i];

            maxProfit = Math.max(p - lowest, maxProfit);

            lowest = Math.min(lowest, p);
        }

        return maxProfit;
    }
}
