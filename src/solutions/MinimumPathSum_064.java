package solutions;

/**
 * https://leetcode.com/problems/minimum-path-sum/
 *
 * Given a m x n grid filled with non-negative numbers, find a path from
 * top left to bottom right which minimizes the sum of all numbers along
 * its path.
 *
 * Note: You can only move either down or right at any point in time.
 */
public class MinimumPathSum_064 {
    // DP recurrence:
    // dp[i][j] = min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j]
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return -1;

        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m][n];

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                dp[i][j] = get(dp, i, j) + grid[i][j];
            }
        }
        return dp[m - 1][n - 1];
    }

    private int get(int[][] dp, int i, int j) {
        if (i == 0 && j == 0) return 0;
        else if (i == 0) return dp[i][j - 1];
        else if (j == 0) return dp[i - 1][j];
        else return Math.min(dp[i - 1][j], dp[i][j - 1]);
    }
}
