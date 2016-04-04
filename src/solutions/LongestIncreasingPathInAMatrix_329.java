package solutions;

/**
 * https://leetcode.com/problems/longest-increasing-path-in-a-matrix/
 *
 * Given an integer matrix, find the length of the longest increasing path.
 * From each cell, you can either move to four directions: left, right,
 * up or down. You may NOT move diagonally or move outside of the boundary
 * (i.e. wrap-around is not allowed).
 *
 * Example 1:
 * nums = [
 *   [9,9,4],
 *   [6,6,8],
 *   [2,1,1]
 * ]
 * Return 4
 * The longest increasing path is [1, 2, 6, 9].
 *
 * Example 2:
 * nums = [
 *   [3,4,5],
 *   [3,2,6],
 *   [2,2,1]
 * ]
 * Return 4
 * The longest increasing path is [3, 4, 5, 6]. Moving diagonally is not allowed.
 */
public class LongestIncreasingPathInAMatrix_329 {
    // Ref: http://bookshadow.com/weblog/2016/01/20/leetcode-longest-increasing-path-matrix/
    public int longestIncreasingPath(int[][] m) {
        if (m == null || m.length == 0 || m[0].length == 0) return 0;

        int[][] dp = new int[m.length][m[0].length];
        int maxLen = 0;
        for (int i = 0; i < m.length; ++i) {
            for (int j = 0; j < m[0].length; ++j) {
                maxLen = Math.max(maxLen, dfs(m, dp, i, j));
            }
        }
        return maxLen;
    }

    private int[] dx = {-1, 0, 1, 0};
    private int[] dy = {0, -1, 0, 1};

    private int dfs(int[][] m, int[][] dp, int i, int j) {
        if (dp[i][j] != 0) return dp[i][j];
        int maxLen = 0;
        for (int k = 0; k < 4; ++k) {
            int x = i + dx[k], y = j + dy[k];
            if (x >= 0 && y >= 0 && x < m.length && y < m[0].length && m[x][y] > m[i][j]) {
                maxLen = Math.max(maxLen, dfs(m, dp, x, y));
            }
        }
        dp[i][j] = maxLen + 1;
        return dp[i][j];
    }
}
