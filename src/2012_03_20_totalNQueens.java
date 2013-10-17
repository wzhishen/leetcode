public class Solution {
    // Follow up for N-Queens problem.

    // Now, instead outputting board configurations, return the total number of distinct solutions.
    
    public int totalNQueens(int n) {
        if (n <= 0) return 0;
        return totalNQueens(n, 0, new Integer[n]);
    }
    
    private int totalNQueens(int grid_size, int row, Integer[] columns) {
        int cnt = 0;
        if (row == grid_size) {
            return 1;
        }
        else {
            for (int col = 0; col < grid_size; ++col) {
                if (isValid(row, col, columns)) {
                    columns[row] = col;
                    cnt += totalNQueens(grid_size, row + 1, columns);
                }
            }
        }
        return cnt;
    }
    
    private boolean isValid(int row, int col, Integer[] columns) {
        for (int r = 0; r < row; ++r) {
            if (columns[r] == col) return false;
            if (Math.abs(columns[r] - col) == row - r) return false;
        }
        return true;
    }
}