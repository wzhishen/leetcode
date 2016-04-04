package solutions;

/**
 * https://leetcode.com/problems/range-sum-query-2d-immutable/
 *
 * Given a 2D matrix matrix, find the sum of the elements inside the rectangle defined
 * by its upper left corner (row1, col1) and lower right corner (row2, col2).
 * https://leetcode.com/static/images/courses/range_sum_query_2d.png
 * The above rectangle (with the red border) is defined by (row1, col1) = (2, 1) and
 * (row2, col2) = (4, 3), which contains sum = 8.
 *
 * Example:
 * Given matrix = [
 *   [3, 0, 1, 4, 2],
 *   [5, 6, 3, 2, 1],
 *   [1, 2, 0, 1, 5],
 *   [4, 1, 0, 1, 7],
 *   [1, 0, 3, 0, 5]
 * ]
 *
 * sumRegion(2, 1, 4, 3) -> 8
 * sumRegion(1, 1, 2, 2) -> 11
 * sumRegion(1, 2, 2, 4) -> 12
 *
 * Note:
 * 1. You may assume that the matrix does not change.
 * 2. There are many calls to sumRegion function.
 * 3. You may assume that row1 <= row2 and col1 <= col2.
 */
public class RangeSumQuery2DImmutable_304 {

    public class NumMatrix {
        private int[][] m;

        public NumMatrix(int[][] matrix) {
            if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return;
            m = matrix;
            for (int i = 0; i < matrix.length; ++i) {
                for (int j = 0; j < matrix[0].length; ++j) {
                    m[i][j] += m(i - 1, j) + m(i, j - 1) - m(i - 1, j - 1);
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            return m(row2, col2) - m(row2, col1 - 1) - m(row1 - 1, col2) + m(row1 - 1, col1 - 1);
        }

        private int m(int i, int j) {
            return i >= 0 && j >= 0 ? m[i][j] : 0;
        }
    }


    // Your NumMatrix object will be instantiated and called as such:
    // NumMatrix numMatrix = new NumMatrix(matrix);
    // numMatrix.sumRegion(0, 1, 2, 3);
    // numMatrix.sumRegion(1, 2, 3, 4);
}
