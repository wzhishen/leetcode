package solutions;

/**
 * https://leetcode.com/problems/search-a-2d-matrix-ii/
 *
 * Write an efficient algorithm that searches for a value in an m x n matrix.
 * This matrix has the following properties:
 * 1. Integers in each row are sorted in ascending from left to right.
 * 2. Integers in each column are sorted in ascending from top to bottom.
 *
 * For example,
 * Consider the following matrix:
 * [
 *   [1,   4,  7, 11, 15],
 *   [2,   5,  8, 12, 19],
 *   [3,   6,  9, 16, 22],
 *   [10, 13, 14, 17, 24],
 *   [18, 21, 23, 26, 30]
 * ]
 * Given target = 5, return true.
 * Given target = 20, return false.
 */
public class SearchA2DMatrixII_240 {
    /*
     * O(m + n) time
     * m, n are length of matrix sides
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        int i = 0, j = matrix[0].length - 1;
        while (j >= 0 && i < matrix.length) {
            if (matrix[i][j] == target) return true;
            else if (matrix[i][j] > target) --j;
            else ++i;
        }
        return false;
    }

    /* Divide and Conquer/Binary Search:
     * Recurrence: T(N) = 3T(N/2) + C
     * According to Master Theorem, a = 3, b = 2
     * T(N) = O(N^log3), where N is the average length of matrix sides
     */
    public boolean searchMatrix2(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        return search(matrix, target, 0, matrix.length - 1, 0, matrix[0].length - 1);
    }

    private boolean search(int[][] matrix, int target, int rs, int re, int cs, int ce) {
        if (rs > re || cs > ce) return false;
        int rm = rs + (re - rs) / 2;
        int cm = cs + (ce - cs) / 2;
        if (matrix[rm][cm] == target) {
            return true;
        } else if (matrix[rm][cm] > target) {
            return search(matrix, target, rs, rm - 1, cs, cm - 1) ||
                   search(matrix, target, rs, rm - 1, cm, ce) ||
                   search(matrix, target, rm, re, cs, cm - 1);
        } else {
            return search(matrix, target, rm + 1, re, cs + 1, ce) ||
                   search(matrix, target, rs, rm, cm + 1, ce) ||
                   search(matrix, target, rm + 1, re, cs, cm);
        }
    }
}
