package solutions;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/n-queens/
 *
 * The n-queens puzzle is the problem of placing n queens on an n��n chessboard
 * such that no two queens attack each other.
 * Given an integer n, return all distinct solutions to the n-queens puzzle.
 * Each solution contains a distinct board configuration of the n-queens' placement,
 * where 'Q' and '.' both indicate a queen and an empty space respectively.
 *
 * For example,
 * There exist two distinct solutions to the 4-queens puzzle:
 * [
 *   [".Q..",  // Solution 1
 *   "...Q",
 *   "Q...",
 *   "..Q."],
 *
 *   ["..Q.",  // Solution 2
 *    "Q...",
 *   "...Q",
 *   ".Q.."]
 * ]
 */
public class NQueens_051 {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> solutions = new ArrayList<List<String>>();
        if (n <= 0) return solutions;
        placeQueens(solutions, new int[n], 0);
        return solutions;
    }

    private void placeQueens(List<List<String>> solutions, int[] solution, int rowNum) {
        if (rowNum == solution.length) {
            solutions.add(printQueens(solution));
        } else {
            for (int colNum = 0; colNum < solution.length; ++colNum) {
                if (canPlaceQueen(solution, rowNum, colNum)) {
                    solution[rowNum] = colNum;
                    placeQueens(solutions, solution, rowNum + 1);
                }
            }
        }
    }

    private boolean canPlaceQueen(int[] solution, int rowNum, int colNum) {
        for (int row = 0; row < rowNum; ++row) {
            if (colNum == solution[row]) return false;
            if (rowNum - row == Math.abs(colNum - solution[row])) return false;
        }
        return true;
    }

    private List<String> printQueens(int[] solution) {
        List<String> rows = new ArrayList<String>();
        for (int row = 0; row < solution.length; ++row) {
            StringBuilder sb = new StringBuilder();
            for (int col = 0; col < solution.length; ++col) {
                sb.append(col == solution[row] ? 'Q' : '.');
            }
            rows.add(sb.toString());
        }
        return rows;
    }
}
