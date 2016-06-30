package solutions;

import java.util.HashMap;

/**
 * https://leetcode.com/problems/climbing-stairs/
 *
 * You are climbing a stair case. It takes n steps to reach to the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct ways
 * can you climb to the top?
 */
public class ClimbingStairs_070 {
    // Tabulation on the fly
    public int climbStairs(int n) {
        int step1 = 1, step2 = 1, curr = 1;
        for (int i = 2; i <= n; ++i) {
            curr = step1 + step2;
            step1 = step2;
            step2 = curr;
        }
        return curr;
    }

    // Tabulation using an array of intermediate states
    public int climbStairs2(int n) {
        if (n == 0 || n == 1) return 1;
        int[] dp = new int[n + 1];
        dp[1] = 1; dp[2] = 2;
        for (int i = 3; i <= n; ++i) dp[i] = dp[i - 1] + dp[i - 2];
        return dp[n];
    }

    // Memoization: relatively slow and has bigger overhead
    public int climbStairs3(int n) {
        return climbStairs3(n, new HashMap<Integer, Integer>());
    }

    private int climbStairs3(int n, HashMap<Integer, Integer> cache) {
        if (cache.containsKey(n)) return cache.get(n);
        if (n < 0) return 0;
        if (n == 0) return 1;
        int steps = climbStairs3(n - 1, cache) + climbStairs3(n - 2, cache);
        cache.put(n, steps);
        return steps;
    }
}
