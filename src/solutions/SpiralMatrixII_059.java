package solutions;

/**
 * https://leetcode.com/problems/spiral-matrix-ii/
 *
 * Given an integer n, generate a square matrix filled with elements from
 * 1 to n^2 in spiral order.
 *
 * For example,
 * Given n = 3,
 * You should return the following matrix:
 * [
 *   [ 1, 2, 3 ],
 *   [ 8, 9, 4 ],
 *   [ 7, 6, 5 ]
 * ]
 */
public class SpiralMatrixII_059 {
    public int[][] generateMatrix(int n) {
        if (n < 0) return null;
        int[][] result = new int[n][n];
        int cnt = 1;
        for (int i = 0; i < n / 2; ++i) {
            for (int j = i; j < n - i - 1; ++j) {
                result[i][j] = cnt++;
            }
            for (int j = i; j < n - i - 1; ++j) {
                result[j][n - i - 1] = cnt++;
            }
            for (int j = i; j < n - i - 1; ++j) {
                result[n - i - 1][n - j - 1] = cnt++;
            }
            for (int j = i; j < n - i - 1; ++j) {
                result[n - j - 1][i] = cnt++;
            }
        }
        if (n % 2 == 1) result[n / 2][n / 2] = cnt;
        return result;
    }
}
