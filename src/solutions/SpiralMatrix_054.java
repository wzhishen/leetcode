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
        List<Integer> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return res;

        int m = matrix.length, n = matrix[0].length;
        int rowStart = 0, rowEnd = m - 1, colStart = 0, colEnd = n - 1;

        while (rowStart <= rowEnd && colStart <= colEnd) {
            for (int c = colStart; c <= colEnd; ++c) res.add(matrix[rowStart][c]);
            if (++rowStart > rowEnd) return res;

            for (int r = rowStart; r <= rowEnd; ++r) res.add(matrix[r][colEnd]);
            if (--colEnd < colStart) return res;

            for (int c = colEnd; c >= colStart; --c) res.add(matrix[rowEnd][c]);
            --rowEnd;

            for (int r = rowEnd; r >= rowStart; --r) res.add(matrix[r][colStart]);
            ++colStart;
        }
        return res;
    }
}
