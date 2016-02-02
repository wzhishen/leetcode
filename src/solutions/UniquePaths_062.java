package solutions;

/**
 * https://leetcode.com/problems/unique-paths/
 *
 * A robot is located at the top-left corner of a m x n grid (marked 'Start'
 * in the diagram below).
 *
 * The robot can only move either down or right at any point in time. The
 * robot is trying to reach the bottom-right corner of the grid (marked
 * 'Finish' in the diagram below).
 *
 * How many possible unique paths are there?
 *
 * Note: m and n will be at most 100.
 */
public class UniquePaths_062 {
    // Use a rolling array: O(m*n) time, O(n) space
    public int uniquePaths(int m, int n) {
        if (m <= 0 || n <= 0) return -1;
        int[] dp = new int[n];
        for (int j = 0; j < n; ++j) dp[j] = 1;

        for (int i = 1 ; i < m; ++i) {
            for (int j = 1; j < n; ++j) {
                dp[j] += dp[j - 1];
            }
        }
        return dp[n - 1];
    }

    // O(m*n) time, O(m*n) space
    public int uniquePaths2(int m, int n) {
        if (m <= 0 || n <= 0) return -1;
        int[][] grid = new int[m][n];
        grid[0][0] = 1;
        for (int i = 0 ; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (i > 0) grid[i][j] += grid[i - 1][j];
                if (j > 0) grid[i][j] += grid[i][j - 1];
            }
        }
        return grid[m - 1][n - 1];
    }
}
