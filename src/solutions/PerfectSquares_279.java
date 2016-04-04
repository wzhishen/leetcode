package solutions;

/**
 * https://leetcode.com/problems/perfect-squares/
 *
 * Given a positive integer n, find the least number of perfect square numbers
 * (for example, 1, 4, 9, 16, ...) which sum to n.
 *
 * For example, given n = 12, return 3 because 12 = 4 + 4 + 4; given n = 13,
 * return 2 because 13 = 4 + 9.
 */
public class PerfectSquares_279 {
    // DP recurrence:
    // dp[i] = min(1 + dp[i - j * j]) where j * j <= n
    // (1 == dp[j * j])
    public int numSquares(int n) {
        if (n <= 0) return -1;
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; ++i) {
            int min = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; ++j) {
                int m = 1 + dp[i - j * j];
                if (m < min) min = m;
            }
            dp[i] = min;
        }
        return dp[n];
    }
}
