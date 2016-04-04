package solutions;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/
 *
 * Say you have an array for which the ith element is the price of a given
 * stock on day i.
 * Design an algorithm to find the maximum profit. You may complete at most
 * two transactions.
 *
 * Note:
 * You may not engage in multiple transactions at the same time (ie, you must
 * sell the stock before you buy again).
 */
public class BestTimeToBuyAndSellStockIII_123 {
    /*
     * Divide array into 2 parts, solving each part regresses to problem
     * BestTimeToBuyAndSellStock_121.
     * Brute force: O(n^2) time, O(1) space; DP: O(n) time, O(n) space
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int[] left = new int[prices.length];
        int[] right = new int[prices.length];
        /*
         * DP from left to right. Recurrence:
         * leftMaxProfit[i] = Math.max(leftMaxProfit[i-1], prices[i] - minBuyingPrice)
         */
        int minPrice = prices[0];
        for (int i = 1; i < prices.length; ++i) {
            minPrice = Math.min(minPrice, prices[i]);
            left[i] = Math.max(left[i - 1], prices[i] - minPrice);
        }
        /*
         * DP from right to left. Recurrence:
         * rightMaxProfit[i] = Math.max(rightMaxProfit[i+1], maxSellingPrice - prices[i])
         */
        int maxPrice = prices[prices.length - 1];
        for (int i = prices.length - 2; i >= 0; --i) {
            maxPrice = Math.max(maxPrice, prices[i]);
            right[i] = Math.max(right[i + 1], maxPrice - prices[i]);
        }
        int maxProfit = 0;
        for (int i = 0; i < prices.length; ++i) {
            maxProfit = Math.max(maxProfit, left[i] + right[i]);
        }
        return maxProfit;
    }
}
