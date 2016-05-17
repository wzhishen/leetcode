package solutions;

/**
 * https://leetcode.com/problems/range-sum-query-2d-mutable/
 *
 * Given a 2D matrix matrix, find the sum of the elements inside the
 * rectangle defined by its upper left corner (row1, col1) and lower
 * right corner (row2, col2).
 * https://leetcode.com//static/images/courses/range_sum_query_2d.png
 * The above rectangle (with the red border) is defined by (row1, col1)
 * = (2, 1) and (row2, col2) = (4, 3), which contains sum = 8.
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
 * update(3, 2, 2)
 * sumRegion(2, 1, 4, 3) -> 10
 *
 * Note:
 * 1. The matrix is only modifiable by the update function.
 * 2. You may assume the number of calls to update and sumRegion function
 * is distributed evenly.
 * 3. You may assume that row1 <= row2 and col1 <= col2.
 */
public class RangeSumQuery2DMutable_308 {

    /*
     * Use a 2D binary indexed tree (Fenwick tree).
     *
     * build: O(mn * log m * log n) time
     * update: O(log m * log n) time
     * sumRange: O(log m * log n) time
     *
     * Ref:
     * https://leetcode.com/discuss/71169/java-2d-binary-indexed-tree-solution-clean-and-short-17ms
     * https://www.topcoder.com/community/data-science/data-science-tutorials/binary-indexed-trees/#2d
     */
    public class NumMatrix {
        private int[][] tree;
        private int[][] matrix;

        public NumMatrix(int[][] m) {
            if (m == null || m.length == 0) return;

            tree = new int[m.length + 1][m[0].length + 1];
            matrix = m;
            for (int i = 0; i < m.length; ++i) {
                for (int j = 0; j < m[0].length; ++j) {
                    add(i, j, m[i][j]);
                }
            }
        }

        private int sum(int row, int col) {
            int res = 0;
            for (int i = row + 1; i > 0; i -= i & -i) {
                for (int j = col + 1; j > 0; j -= j & -j) {
                    res += tree[i][j];
                }
            }
            return res;
        }

        private void add(int row, int col, int val) {
            for (int i = row + 1; i < tree.length; i += i & -i) {
                for (int j = col + 1; j < tree[0].length; j += j & -j) {
                    tree[i][j] += val;
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            return sum(row2, col2) - sum(row2, col1 - 1) - sum(row1 - 1, col2) + sum(row1 - 1, col1 - 1);
        }

        public void update(int row, int col, int val) {
            add(row, col, val - matrix[row][col]);
            matrix[row][col] = val;
        }

    }


    // Your NumMatrix object will be instantiated and called as such:
    // NumMatrix numMatrix = new NumMatrix(matrix);
    // numMatrix.sumRegion(0, 1, 2, 3);
    // numMatrix.update(1, 1, 10);
    // numMatrix.sumRegion(1, 2, 3, 4);
}
