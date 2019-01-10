public class BestTimeToBuyAndSellStockWithTransactionFee {

    public int maxProfit(int[] prices, int fee) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int profit = 0;
        int hold = prices[0];
        int sell = hold;
        boolean hasBuy = false;
        for (int i = 1; i < prices.length; i++) {
            // if not yet buy stock and the current stock price is less than hold,
            // change the hold to current stock price
            if (!hasBuy && prices[i] < hold) {
                hold = prices[i];
            } else if (!hasBuy && prices[i] - hold > fee) {
                // if not yet buy stock and buying current stock will have profit,
                // buy the stock
                hasBuy = true;
                sell = prices[i];
            } else if (hasBuy && prices[i] > sell) {
                // if already bought the stock and current stock is greater than sell
                sell = prices[i];
            } else if (hasBuy && sell - prices[i] > fee) {
                // if already bought the stock and selling current stock will have profit
                profit += sell - hold - fee;
                hasBuy = false;
                hold = prices[i];
            }
        }
        if (hasBuy) {
            profit += sell - hold - fee;
        }
        return profit;
    }
}
