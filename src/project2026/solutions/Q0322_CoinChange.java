package project2026.solutions;

import java.util.Arrays;
import java.util.HashMap;

/*
https://leetcode.com/problems/coin-change/description/

You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.

Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

You may assume that you have an infinite number of each kind of coin.



Example 1:

Input: coins = [1,2,5], amount = 11
Output: 3
Explanation: 11 = 5 + 5 + 1
Example 2:

Input: coins = [2], amount = 3
Output: -1
Example 3:

Input: coins = [1], amount = 0
Output: 0


Constraints:

1 <= coins.length <= 12
1 <= coins[i] <= 231 - 1
0 <= amount <= 104

 */
public class Q0322_CoinChange {
     HashMap<Integer, Integer> memo = new HashMap<>();

     public int coinChange(int[] coins, int amount) {
         if (amount == 0) return 0;
         if (amount < 0) return -1;
         if (memo.containsKey(amount)) return memo.get(amount);

         int res = Integer.MAX_VALUE;
         for (int coin : coins) {
             int prev = coinChange(coins, amount - coin);
             if (prev == -1) continue;
             res = Math.min(res, prev + 1);
         }
         memo.put(amount, res == Integer.MAX_VALUE ? -1 : res);
         return memo.get(amount);
     }

    public int coinChange2(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE - 1);
        dp[0] = 0;
        for (int i = 1; i <= amount; ++i) {
            for (int coin : coins) {
                if (i - coin < 0) continue;
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }
        return dp[amount] == Integer.MAX_VALUE - 1 ? -1 : dp[amount];
    }

    // dp[i][j] means the number of coins from coins[0...i - 1] to make up exact amount j
    //
    // dp[0][*] = inf, there's no way to use no coins to make up any amount, thus inf/-1
    // dp[*][0] = 0, we need 0 coin to make up amount 0
    // Result is dp[n][amount]
    // public int coinChange(int[] coins, int amount) {
    //     int n = coins.length;
    //     int[][] dp = new int[n + 1][amount + 1];
    //     for (int j = 0; j <= amount; ++j) dp[0][j] = Integer.MAX_VALUE - 1;

    //     for (int i = 1; i <= n; ++i) {
    //         for (int j = 1; j <= amount; ++j) {
    //             if (j - coins[i - 1] < 0) {
    //                 dp[i][j] = dp[i - 1][j];
    //             } else {
    //                 dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - coins[i - 1]] + 1);
    //             }
    //         }
    //     }
    //     return dp[n][amount] == Integer.MAX_VALUE - 1 ? -1 : dp[n][amount];
    // }

    // public int coinChange(int[] coins, int amount) {
    //     int n = coins.length;
    //     int[][] dp = new int[n + 1][amount + 1];
    //     for (int j = 0; j <= amount; ++j) dp[0][j] = -1;

    //     for (int i = 1; i <= n; ++i) {
    //         for (int j = 1; j <= amount; ++j) {
    //             if (j - coins[i - 1] < 0) {
    //                 dp[i][j] = dp[i - 1][j];
    //             } else {
    //                 if (dp[i - 1][j] != -1 && dp[i][j - coins[i - 1]] != -1) {
    //                     dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - coins[i - 1]] + 1);
    //                 } else if (dp[i - 1][j] != -1) {
    //                     dp[i][j] = dp[i - 1][j];
    //                 } else if (dp[i][j - coins[i - 1]] != -1) {
    //                     dp[i][j] = dp[i][j - coins[i - 1]] + 1;
    //                 } else {
    //                     dp[i][j] = -1;
    //                 }
    //             }
    //         }
    //     }
    //     return dp[n][amount];
    // }
}
