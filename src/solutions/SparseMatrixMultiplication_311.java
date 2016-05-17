package solutions;

/**
 * https://leetcode.com/problems/sparse-matrix-multiplication/
 *
 * Given two sparse matrices A and B, return the result of AB.
 * You may assume that A's column number is equal to B's row number.
 *
 * Example:
 * A = [
 *   [ 1, 0, 0],
 *   [-1, 0, 3]
 * ]
 *
 * B = [
 *   [ 7, 0, 0 ],
 *   [ 0, 0, 0 ],
 *   [ 0, 0, 1 ]
 * ]
 *
 *      |  1 0 0 |   | 7 0 0 |   |  7 0 0 |
 * AB = | -1 0 3 | x | 0 0 0 | = | -7 0 3 |
 *                   | 0 0 1 |
 */
public class SparseMatrixMultiplication_311 {
    /* Just skip multiplication for any zero elements.
     *
     * Ref:
     * https://leetcode.com/discuss/71912/easiest-java-solution
     * Matrix multiplication:
     * https://www.mathsisfun.com/algebra/matrix-multiplying.html
     */
    public int[][] multiply(int[][] A, int[][] B) {
        // A[0].length must be equal to B.length
        int m = A.length, n = A[0].length, nB = B[0].length;
        int res[][] = new int[m][nB];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (A[i][j] != 0) {
                    for (int k = 0; k < nB; ++k) {
                        if (B[j][k] != 0) res[i][k] += A[i][j] * B[j][k];
                    }
                }
            }
        }
        return res;
    }
}
