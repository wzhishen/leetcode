public class Solution {
    // Say you have an array for which the ith element is the price
    // of a given stock on day i.

    // Design an algorithm to find the maximum profit. You may 
    // complete as many transactions as you like (ie, buy one and 
    // sell one share of the stock multiple times). However, you 
    // may not engage in multiple transactions at the same time (
    // ie, you must sell the stock before you buy again).

    // Buy and keep the stock as long as it grows, every time it
    // drops sell it immediately and buy it again.
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int profit = 0;
        int low = prices[0];
        for (int i = 1; i < prices.length; ++i) {
            if (prices[i] < prices[i - 1]) {
                profit += prices[i - 1] - low;
                low = prices[i];
            }
        }
        if (prices[prices.length - 1] - low > 0) {
            profit += prices[prices.length - 1] - low;
        }
        return profit;
    }
}