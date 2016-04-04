package solutions;

/**
 * https://leetcode.com/problems/coin-change/
 *
 * You are given coins of different denominations and a total amount of money amount. Write a function
 * to compute the fewest number of coins that you need to make up that amount. If that amount of money
 * cannot be made up by any combination of the coins, return -1.
 *
 * Example 1:
 * coins = [1, 2, 5], amount = 11
 * return 3 (11 = 5 + 5 + 1)
 
 * Example 2:
 * coins = [2], amount = 3
 * return -1.
 *
 * Note:
 * You may assume that you have an infinite number of each kind of coin.
 */
public class CoinChange_322 {
    // DP recurrence:
    // for coin in coins: dp[i] = min(dp[i - coin]) + 1
    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0 || amount < 0) return -1;
        if (amount == 0) return 0;

        int[] dp = new int[amount + 1];
        for (int coin : coins) {
            if (coin <= amount) dp[coin] = 1;
        }
        for (int i = 1; i <= amount; ++i) {
            int min = Integer.MAX_VALUE;
            for (int coin : coins) {
                if (i - coin > 0 && dp[i - coin] != -1 && dp[i - coin] < min) {
                    min = dp[i - coin];
                }
            }
            if (dp[i] == 0) {
                if (min == Integer.MAX_VALUE) {
                    dp[i] = -1;
                } else {
                    dp[i] = min + 1;
                }
            }
        }
        return dp[amount];
    }
}
