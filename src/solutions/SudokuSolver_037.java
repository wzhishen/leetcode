package solutions;

/**
 * https://leetcode.com/problems/sudoku-solver/
 *
 * Write a program to solve a Sudoku puzzle by filling the empty cells.
 * Empty cells are indicated by the character '.'.
 * You may assume that there will be only one unique solution.
 */
public class SudokuSolver_037 {
    public void solveSudoku(char[][] board) {
        solve(board);
    }

    private boolean solve(char[][] board) {
        for (int row = 0; row < 9; ++row) {
            for (int col = 0; col < 9; ++col) {
                if (board[row][col] == '.') {
                    for (char n = '1'; n <= '9'; ++n) {
                        if (isValid(board, row, col, n)) {
                            board[row][col] = n;
                            if (solve(board)) return true;
                            board[row][col] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isValid(char[][] board, int row, int col, int n) {
        for (int c = 0; c < 9; ++c) {
            if (board[row][c] == n) return false;
        }
        for (int r = 0; r < 9; ++r) {
            if (board[r][col] == n) return false;
        }
        for (int r = row/3*3; r < row/3*3 + 3; ++r) {
            for (int c = col/3*3; c < col/3*3 + 3; ++c) {
                if (board[r][c] == n) return false;
            }
        }
        return true;
    }
}
