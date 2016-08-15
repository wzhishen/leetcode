package solutions;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 *
 * Say you have an array for which the ith element is the price of a given
 * stock on day i.
 * If you were only permitted to complete at most one transaction (ie, buy
 * one and sell one share of the stock), design an algorithm to find the
 * maximum profit.
 */
public class BestTimeToBuyAndSellStock_121 {
    public int maxProfit(int[] prices) {
        if (prices == null) return 0;
        int profit = 0;
        int minPrice = Integer.MAX_VALUE;
        for (int price : prices) {
            minPrice = Math.min(minPrice, price);
            profit = Math.max(profit, price - minPrice);
        }
        return profit;
    }
}
