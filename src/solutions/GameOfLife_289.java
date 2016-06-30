package solutions;

/**
 * https://leetcode.com/problems/game-of-life/
 *
 * According to the Wikipedia's article: "The Game of Life, also known simply
 * as Life, is a cellular automaton devised by the British mathematician John
 * Horton Conway in 1970."
 *
 * Given a board with m by n cells, each cell has an initial state live (1) or
 * dead (0). Each cell interacts with its eight neighbors (horizontal, vertical,
 * diagonal) using the following four rules (taken from the above Wikipedia
 * article):
 *
 * 1. Any live cell with fewer than two live neighbors dies, as if caused by
 *    under-population.
 * 2. Any live cell with two or three live neighbors lives on to the next generation.
 * 3. Any live cell with more than three live neighbors dies, as if by over-population.
 * 4. Any dead cell with exactly three live neighbors becomes a live cell, as if
 *    by reproduction.
 *
 * Write a function to compute the next state (after one update) of the board given
 * its current state.
 *
 * Follow up:
 * 1. Could you solve it in-place? Remember that the board needs to be updated at
 * the same time: You cannot update some cells first and then use their updated
 * values to update other cells.
 * 2. In this question, we represent the board using a 2D array. In principle,
 * the board is infinite, which would cause problems when the active area encroaches
 * the border of the array. How would you address these problems?
 */
public class GameOfLife_289 {
    /* DEAD: 0
     * LIVE: 1
     *
     * Use number to mark extra states.
     * States:
     * 0: DEAD -> DEAD
     * 1: LIVE -> LIVE
     * 2: LIVE -> DEAD
     * 3: DEAD -> LIVE
     */
    public void gameOfLife(int[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) return;
        int m = board.length, n = board[0].length;
        int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                int lifeCnt = 0;
                for (int k = 0; k < 8; ++k) {
                    int x = i + dx[k]; int y = j + dy[k];
                    if (x >= 0 && x < m && y >= 0 && y < n &&
                       (board[x][y] == 1 || board[x][y] == 2)) ++lifeCnt;
                }
                // Mark LIVE -> DEAD
                if (board[i][j] == 1 && (lifeCnt < 2 || lifeCnt > 3)) board[i][j] = 2;
                // Mark DEAD -> LIVE
                else if (board[i][j] == 0 && lifeCnt == 3) board[i][j] = 3;
            }
        }
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                board[i][j] %= 2;
            }
        }
    }

    /* Use bit to mark extra states.
     * States:
     * 0 (00): DEAD <- DEAD
     * 1 (01): DEAD <- LIVE
     * 2 (10): LIVE <- DEAD
     * 3 (11): LIVE <- LIVE
     */
    public void gameOfLife2(int[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) return;
        int m = board.length, n = board[0].length;
        int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                int lifeCnt = 0;
                for (int k = 0; k < 8; ++k) {
                    int x = i + dx[k]; int y = j + dy[k];
                    if (x >= 0 && x < m && y >= 0 && y < n &&
                       ((board[x][y] & 1) == 1)) ++lifeCnt;
                }
                // Only care about when second bit will become 1
                // Mark LIVE <- LIVE
                if (board[i][j] == 1 && (lifeCnt == 2 || lifeCnt == 3)) board[i][j] = 3;
                // Mark LIVE <- DEAD
                else if (board[i][j] == 0 && lifeCnt == 3) board[i][j] = 2;
            }
        }
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                board[i][j] >>= 1;
            }
        }
    }
}
