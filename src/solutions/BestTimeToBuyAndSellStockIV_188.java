package solutions;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/
 *
 * Say you have an array for which the ith element is the price of a given
 * stock on day i.
 * Design an algorithm to find the maximum profit. You may complete at most
 * k transactions.
 *
 * Note:
 * You may not engage in multiple transactions at the same time (ie, you must
 * sell the stock before you buy again).
 */
public class BestTimeToBuyAndSellStockIV_188 {
    /* DP recurrence:
     * dp[i][j] denotes max profit up until day j with at most i transactions.
     * dp[i][j] = max(dp[i][j-1], prices[j] - prices[jj] + dp[i-1][jj]), where 0 <= jj < j
     *          = max(dp[i][j-1], prices[j] + max(dp[i-1][jj] - prices[jj]))
     *
     * dp[i][0] = 0: can't make profit on the single first day.
     * dp[0][j] = 0: can't make profit with zero transaction.
     *
     * Ref:
     * https://leetcode.com/discuss/62026/clean-java-dp-solution-with-comment
     * Another thought:
     * http://www.jiuzhang.com/solutions/best-time-to-buy-and-sell-stock-iv/
     */
    public int maxProfit(int k, int[] prices) {
        if (k <= 0 || prices == null) return 0;

        int n = prices.length;
        // when k is big enough, this problem becomes BestTimeToBuyAndSellStockII_122
        int maxProfit = 0;
        if (k >= n / 2) {
            for (int i = 1; i < n; ++i) maxProfit += Math.max(prices[i] - prices[i - 1], 0);
            return maxProfit;
        }

        int[][] dp = new int[k + 1][n];
        for (int i = 1; i <= k; ++i) {
            int localMax = dp[i - 1][0] - prices[0];
            for (int j = 1; j < n; ++j) {
                dp[i][j] = Math.max(dp[i][j - 1], prices[j] + localMax);
                localMax = Math.max(localMax, dp[i - 1][j] - prices[j]);
            }
        }
        return dp[k][n - 1];
    }
}
