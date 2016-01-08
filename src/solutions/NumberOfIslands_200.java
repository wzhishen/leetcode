package solutions;

/**
 * https://leetcode.com/problems/number-of-islands/
 *
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of
 * islands. An island is surrounded by water and is formed by connecting
 * adjacent lands horizontally or vertically. You may assume all four edges
 * of the grid are all surrounded by water.
 *
 * Example 1:
 * 11110
 * 11010
 * 11000
 * 00000
 * Answer: 1
 *
 * Example 2:
 * 11000
 * 11000
 * 00100
 * 00011
 * Answer: 3
 */
public class NumberOfIslands_200 {
    public int numIslands(char[][] grid) {
        if (grid == null) return -1;
        int cnt = 0;
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                if (isIsland(grid, i, j)) ++cnt;
            }
        }
        return cnt;
    }

    private boolean isIsland(char[][] grid, int i, int j) {
        if (grid[i][j] == '1') {
            destroy(grid, i, j);
            return true;
        }
        return false;
    }

    private void destroy(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i > grid.length - 1 || j > grid[0].length - 1) return;
        if (grid[i][j] == '1') {
            grid[i][j] = '0';
            destroy(grid, i - 1, j);
            destroy(grid, i + 1, j);
            destroy(grid, i, j - 1);
            destroy(grid, i, j + 1);
        }
    }
}
