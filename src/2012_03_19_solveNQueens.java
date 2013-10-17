public class Solution {
    // Given an integer n, return all distinct solutions to the n-queens puzzle.

    // Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.

    // For example,
    // There exist two distinct solutions to the 4-queens puzzle:

    // [
    //  [".Q..",  // Solution 1
    //   "...Q",
    //   "Q...",
    //   "..Q."],

    //  ["..Q.",  // Solution 2
    //   "Q...",
    //   "...Q",
    //   ".Q.."]
    // ]
    
    public ArrayList<String[]> solveNQueens(int n) {
        if (n <= 0) return null;
        ArrayList<String[]> ret = new ArrayList<String[]>();
        solveNQueens(n, 0, new Integer[n], ret);
        return ret;
    }
    
    private void solveNQueens(int grid_size, int row, Integer[] columns, ArrayList<String[]> res) {
        if (row == grid_size) {
            res.add(transform(columns));
        }
        else {
            for (int col = 0; col < grid_size; ++col) {
                if (isValid(row, col, columns)) {
                    columns[row] = col;
                    solveNQueens(grid_size, row + 1, columns, res);
                }
            }
        }
    }
    
    private boolean isValid(int row, int col, Integer[] columns) {
        for (int r = 0; r < row; ++r) {
            if (columns[r] == col) return false;
            if (Math.abs(columns[r] - col) == row - r) return false;
        }
        return true;
    }
    
    private String[] transform(Integer[] columns) {
        int size = columns.length;
        String[] ret = new String[size];
        for (int i = 0; i < size; ++i) {
            StringBuffer sb = new StringBuffer();
            for (int j = 0; j < size; ++j) {
                if (j == columns[i]) {
                    sb.append('Q');
                }
                else {
                    sb.append('.');
                }
            }
            ret[i] = sb.toString();
        }
        return ret;
    }
}