package solutions;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
 *
 * Say you have an array for which the ith element is the price of a given stock
 * on day i.
 * Design an algorithm to find the maximum profit. You may complete as many
 * transactions as you like (ie, buy one and sell one share of the stock multiple
 * times) with the following restrictions:
 * 1. You may not engage in multiple transactions at the same time (ie, you must
 *    sell the stock before you buy again).
 * 2. After you sell your stock, you cannot buy stock on next day. (ie, cooldown
 *    1 day)
 *
 * Example:
 * prices = [1, 2, 3, 0, 2]
 * maxProfit = 3
 * transactions = [buy, sell, cooldown, buy, sell]
 */
public class BestTimeToBuyAndSellStockWithCooldown_309 {
    /*
     * DP recurrence:
     * sells: states of max daily profit, not holding stock at each day
     * buys:  states of max daily profit, holding stock at each day
     * sells[i] = max(sells[i - 1], buys[i - 1] + prices[i])
     * buys[i]  = max(buys[i - 1], sells[i - 2] - prices[i])
     *
     * Reference:
     * https://segmentfault.com/a/1190000004193861
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0 || prices.length == 1) return 0;
        int[] sells = new int[prices.length];
        int[] buys = new int[prices.length];
        sells[0] = 0;
        sells[1] = Math.max(0, prices[1] - prices[0]);
        buys[0] = -prices[0];
        buys[1] = Math.max(-prices[0], -prices[1]);
        for (int i = 2; i < prices.length; ++i) {
            sells[i] = Math.max(sells[i - 1], buys[i - 1] + prices[i]);
            buys[i] = Math.max(buys[i - 1], sells[i - 2] - prices[i]);
        }
        return sells[prices.length - 1];
    }

    // Use rolling arrays to reduce space to O(1)
    public int maxProfit2(int[] prices) {
        if (prices == null || prices.length == 0 || prices.length == 1) return 0;
        int[] sells = new int[3];
        int[] buys = new int[2];
        sells[0] = 0;
        sells[1] = Math.max(0, prices[1] - prices[0]);
        buys[0] = -prices[0];
        buys[1] = Math.max(-prices[0], -prices[1]);
        for (int i = 2; i < prices.length; ++i) {
            sells[i % 3] = Math.max(sells[(i - 1) % 3], buys[(i - 1) % 2] + prices[i]);
            buys[i % 2] = Math.max(buys[(i - 1) % 2], sells[(i - 2) % 3] - prices[i]);
        }
        return sells[(prices.length - 1) % 3];
    }
}
