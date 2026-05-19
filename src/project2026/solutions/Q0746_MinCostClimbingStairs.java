package project2026.solutions;

/*
https://leetcode.com/problems/min-cost-climbing-stairs/description

You are given an integer array cost where cost[i] is the cost of ith step on a staircase. Once you pay the cost, you can either climb one or two steps.

You can either start from the step with index 0, or the step with index 1.

Return the minimum cost to reach the top of the floor.



Example 1:

Input: cost = [10,15,20]
Output: 15
Explanation: You will start at index 1.
- Pay 15 and climb two steps to reach the top.
The total cost is 15.

Example 2:

Input: cost = [1,100,1,1,1,100,1,1,100,1]
Output: 6
Explanation: You will start at index 0.
- Pay 1 and climb two steps to reach index 2.
- Pay 1 and climb two steps to reach index 4.
- Pay 1 and climb two steps to reach index 6.
- Pay 1 and climb one step to reach index 7.
- Pay 1 and climb two steps to reach index 9.
- Pay 1 and climb one step to reach the top.
The total cost is 6.


Constraints:

2 <= cost.length <= 1000
0 <= cost[i] <= 999

 */
public class Q0746_MinCostClimbingStairs {
    // dp[i] means min cost so far ending at step i
    // dp[i] = min(dp[i-1], dp[i-2]) + cost[i]
    //
    // Note that we need to reach step n (which is beyond the array) not n-1,
    // so result is dp[n] (where cost[n] is set to 0).
    // Alternatively, result can also be min(dp[n-1], dp[n-2]).
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n + 1];
        dp[0] = cost[0];
        dp[1] = cost[1];

        for (int i = 2; i <= n; ++i) {
            int c = i == n ? 0 : cost[i];
            dp[i] = Math.min(dp[i - 1], dp[i - 2]) + c;
        }
        return dp[n];
    }

    // public int minCostClimbingStairs(int[] cost) {
    //     int n = cost.length;
    //     int[] dp = new int[n];
    //     dp[0] = cost[0];
    //     dp[1] = cost[1];

    //     for (int i = 2; i < n; ++i) {
    //         dp[i] = Math.min(dp[i - 1], dp[i - 2]) + cost[i];
    //     }
    //     return Math.min(dp[n - 1], dp[n - 2]);
    // }
}
