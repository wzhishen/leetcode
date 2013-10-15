public class Solution {
    // Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.

    // Follow up:
    // Did you use extra space?
    // A straight forward solution using O(mn) space is probably a bad idea.
    // A simple improvement uses O(m + n) space, but still not the best solution.
    // Could you devise a constant space solution?

    // can use bit vector, but will soon overflow
    public void setZeroes(int[][] matrix) {
        if (matrix == null) return;
        boolean[] rowsVector = new boolean[matrix.length];
        boolean[] colsVector = new boolean[matrix[0].length];
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[0].length; ++j) {
                if (matrix[i][j] == 0) {
                    rowsVector[i] = colsVector[j] = true;
                }
            }
        }
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[0].length; ++j) {
                if (rowsVector[i] || colsVector[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}