package solutions;

/**
 * https://leetcode.com/problems/maximal-square/
 *
 * Given a 2D binary matrix filled with 0's and 1's, find the largest
 * square containing all 1's and return its area.
 *
 * For example, given the following matrix:
 * 1 0 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 * Return 4.
 */
public class MaximalSquare_221 {
    /* O(n^2) time, O(n^2) space
     * DP recurrence:
     * dp[i][j]: max side width of square with bottom right corner at matrix[i][j]
     * if matrix[i][j] = 0:
     *   dp[i][j] = 0
     * else:
     *   dp[i][j] = min(dp[i-1][j-1], dp[i-1][j], dp[i][j-1]) + 1
     *
     * Ref:
     * https://leetcode.com/discuss/38489/easy-solution-with-detailed-explanations-8ms-time-and-space
     * https://segmentfault.com/a/1190000003709497
     */
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;

        int maxArea = 0;
        int[][] m = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[0].length; ++j) {
                if (i == 0 || j == 0) {
                    m[i][j] = matrix[i][j] - '0';
                } else {
                    m[i][j] = matrix[i][j] == '0' ? 0 : Math.min(m[i - 1][j - 1], Math.min(m[i - 1][j], m[i][j - 1])) + 1;
                }
                maxArea = Math.max(maxArea, m[i][j] * m[i][j]);
            }
        }
        return maxArea;
    }

    // O(n^2) time, O(n) space with a rolling array
    public int maximalSquare2(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;

        int maxArea = 0;
        int[][] m = new int[2][matrix[0].length];
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[0].length; ++j) {
                if (i == 0 || j == 0) {
                    m[i % 2][j] = matrix[i][j] - '0';
                } else {
                    m[i % 2][j] = matrix[i][j] == '0' ? 0 : Math.min(m[(i - 1) % 2][j - 1], Math.min(m[(i - 1) % 2][j], m[i % 2][j - 1])) + 1;
                }
                maxArea = Math.max(maxArea, m[i % 2][j] * m[i % 2][j]);
            }
        }
        return maxArea;
    }
}
