package solutions;

/**
 * https://leetcode.com/problems/search-a-2d-matrix/
 *
 * Write an efficient algorithm that searches for a value in an m x n matrix.
 * This matrix has the following properties:
 * 1. Integers in each row are sorted from left to right.
 * 2. The first integer of each row is greater than the last integer of the
 * previous row.
 *
 * For example,
 * Consider the following matrix:
 * [
 *   [1,   3,  5,  7],
 *   [10, 11, 16, 20],
 *   [23, 30, 34, 50]
 * ]
 * Given target = 3, return true.
 */
public class SearchA2DMatrix_074 {
    /*
     * O(log m + log n) time
     * m, n are length of matrix sides
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        int low = 0;
        int high = matrix.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (matrix[mid][0] == target) return true;
            else if (matrix[mid][0] > target) high = mid - 1;
            else low = mid + 1;
        }
        int row = high < 0 ? low : high;
        low = 0;
        high = matrix[0].length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (matrix[row][mid] == target) return true;
            else if (matrix[row][mid] > target) high = mid - 1;
            else low = mid + 1;
        }
        return false;
    }
}
