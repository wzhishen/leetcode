package solutions;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/surrounded-regions/
 *
 * Given a 2D board containing 'X' and 'O', capture all regions surrounded
 * by 'X'.
 * A region is captured by flipping all 'O's into 'X's in that surrounded
 * region.
 *
 * For example,
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 *
 * After running your function, the board should be:
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 */
public class SurroundedRegions_130 {
    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) return;
        for (int i = 0; i < board.length; ++i) {
            fill(board, i, 0);
            fill(board, i, board[0].length - 1);
        }
        for (int j = 0; j < board[0].length; ++j) {
            fill(board, 0, j);
            fill(board, board.length - 1, j);
        }
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[0].length; ++j) {
                if (board[i][j] == 'O') board[i][j] = 'X';
                else if (board[i][j] == '#') board[i][j] = 'O';
            }
        }
    }

    private int[] dx = {-1, 0, 0, 1}, dy = {0, -1, 1, 0};

    // Theoretically can do DFS but will not pass online judge's space constraint requirement
    private void fill(char[][] board, int i, int j) {
        if (board[i][j] != 'O') return;
        board[i][j] = '#';
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(encode(board, i, j));
        while (!q.isEmpty()) {
            int n = q.remove();
            int r = n / board[0].length, c = n % board[0].length;
            for (int k = 0; k < 4; ++k) {
                int x = r + dx[k], y = c + dy[k];
                if (x >= 0 && x < board.length && y >= 0 && y < board[0].length && board[x][y] == 'O') {
                    board[x][y] = '#';
                    q.add(encode(board, x, y));
                }
            }
        }
    }

    private int encode(char[][] board, int i, int j) {
        return i * board[0].length + j;
    }
}
