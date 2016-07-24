package solutions;

/**
 * https://leetcode.com/problems/bomb-enemy/
 *
 * Given a 2D grid, each cell is either a wall 'W', an enemy 'E' or
 * empty '0' (the number zero), return the maximum enemies you can
 * kill using one bomb.
 * The bomb kills all the enemies in the same row and column from
 * the planted point until it hits the wall since the wall is too
 * strong to be destroyed.
 * Note that you can only put the bomb at an empty cell.
 *
 * Example:
 * For the given grid
 *
 * 0 E 0 0
 * E 0 W E
 * 0 E 0 0
 *
 * return 3. (Placing a bomb at (1,1) kills 3 enemies)
 */
public class BombEnemy_361 {
    /* Ref:
     * http://www.cnblogs.com/grandyang/p/5599289.html
     */
    public int maxKilledEnemies(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int m = grid.length, n = grid[0].length;
        int[][] left = new int[m][n], right = new int[m][n], top = new int[m][n], bottom = new int[m][n];
        int max = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                int cnt = (j == 0 || grid[i][j] == 'W') ? 0 : left[i][j - 1];
                left[i][j] = grid[i][j] == 'E' ? cnt + 1 : cnt;
            }
            for (int j = n - 1; j >= 0; --j) {
                int cnt = (j == n - 1 || grid[i][j] == 'W') ? 0 : right[i][j + 1];
                right[i][j] = grid[i][j] == 'E' ? cnt + 1 : cnt;
            }
        }
        for (int j = 0; j < n; ++j) {
            for (int i = 0; i < m; ++i) {
                int cnt = (i == 0 || grid[i][j] == 'W') ? 0 : top[i - 1][j];
                top[i][j] = grid[i][j] == 'E' ? cnt + 1 : cnt;
            }
            for (int i = m - 1; i >= 0; --i) {
                int cnt = (i == m - 1 || grid[i][j] == 'W') ? 0 : bottom[i + 1][j];
                bottom[i][j] = grid[i][j] == 'E' ? cnt + 1: cnt;

                if (grid[i][j] == '0') max = Math.max(max, left[i][j] + right[i][j] + top[i][j] + bottom[i][j]);
            }
        }
        return max;
    }
}
