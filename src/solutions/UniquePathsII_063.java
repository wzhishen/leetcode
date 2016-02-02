package solutions;

/**
 * https://leetcode.com/problems/unique-paths-ii/
 *
 * Follow up for "Unique Paths":
 * Now consider if some obstacles are added to the grids. How many unique
 * paths would there be?
 * An obstacle and empty space is marked as 1 and 0 respectively in the grid.
 *
 * For example,
 * There is one obstacle in the middle of a 3x3 grid as illustrated below.
 * [
 *   [0,0,0],
 *   [0,1,0],
 *   [0,0,0]
 * ]
 * The total number of unique paths is 2.
 *
 * Note: m and n will be at most 100.
 */
public class UniquePathsII_063 {
    // Use a rolling array: O(m*n) time, O(n) space
    public int uniquePathsWithObstacles(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return -1;
        int m = grid.length, n = grid[0].length;
        int[] dp = new int[n];
        dp[0] = grid[0][0] == 1 ? 0 : 1;
        for (int j = 1; j < n; ++j) {
            if (grid[0][j] == 1) dp[j] = 0;
            else dp[j] = dp[j - 1];
        }

        for (int i = 1; i < m; ++i) {
            if (grid[i][0] == 1) dp[0] = 0;
            for (int j = 1; j < n; ++j) {
                if (grid[i][j] == 1) dp[j] = 0;
                else dp[j] += dp[j - 1];
            }
        }
        return dp[n - 1];
    }

    // If allowed to modify original matrix: O(m*n) time, O(1) space
    // Otherwise: O(m*n) time, O(m*n) space
    public int uniquePathsWithObstacles2(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return -1;
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 1) {
                    grid[i][j] = 0;
                } else {
                    if (i == 0 && j == 0) grid[i][j] = 1;
                    if (i > 0) grid[i][j] += grid[i - 1][j];
                    if (j > 0) grid[i][j] += grid[i][j - 1];
                }
            }
        }
        return grid[m - 1][n - 1];
    }
}
