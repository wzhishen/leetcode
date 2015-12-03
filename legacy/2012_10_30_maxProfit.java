public class Solution {
    // Say you have an array for which the ith element is the price
    // of a given stock on day i.

    // If you were only permitted to complete at most one transaction 
    // (ie, buy one and sell one share of the stock), design an 
    // algorithm to find the maximum profit.

    // O(n) time
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i = 0; i < prices.length; ++i) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            }
            if (prices[i] - minPrice > maxProfit) {
                maxProfit = prices[i] - minPrice;
            }
        }
        return maxProfit;
    }
    
    // brute force: O(n^2) time
    public int maxProfitBF(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int maxProfit = 0;
        for (int i = 0; i < prices.length; ++i) {
            for (int j = i; j < prices.length; ++j) {
                if (prices[j] - prices[i] >= maxProfit) {
                    maxProfit = prices[j] - prices[i];
                }
            }
        }
        return maxProfit;
    }
}