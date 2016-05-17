package solutions;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/spiral-matrix/
 *
 * Given a matrix of m x n elements (m rows, n columns), return all
 * elements of the matrix in spiral order.
 * For example,
 * Given the following matrix:
 * [
 *   [ 1, 2, 3 ],
 *   [ 4, 5, 6 ],
 *   [ 7, 8, 9 ]
 * ]
 * You should return [1,2,3,6,9,8,7,4,5].
 */
public class SpiralMatrix_054 {
    /* Gradually narrow boundaries
     * Ref:
     * https://leetcode.com/discuss/12228/super-simple-and-easy-to-understand-solution
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<Integer>();
        if (matrix == null || matrix.length == 0) return res;

        int rowLow = 0, rowHigh = matrix.length - 1, colLow = 0, colHigh = matrix[0].length - 1;
        while (rowLow <= rowHigh && colLow <= colHigh) {
            for (int i = colLow; i <= colHigh; ++i) res.add(matrix[rowLow][i]);
            ++rowLow;
            if (rowLow > rowHigh) break;

            for (int i = rowLow; i <= rowHigh; ++i) res.add(matrix[i][colHigh]);
            --colHigh;
            if (colLow > colHigh) break;

            for (int i = colHigh; i >= colLow; --i) res.add(matrix[rowHigh][i]);
            --rowHigh;

            for (int i = rowHigh; i >= rowLow; --i) res.add(matrix[i][colLow]);
            ++colLow;
        }
        return res;
    }
}
