package project2026.solutions;

/*
https://leetcode.com/problems/number-of-islands/

Given an m x n 2D binary grid which represents a map of '1's (land) and '0's (water), return the number of islands.

An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.



Example 1:

Input: grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
Output: 1

Example 2:

Input: grid = [
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]
Output: 3


Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 300
grid[i][j] is '0' or '1'.

 */
public class Q0200_NumberOfIslands {
    public int numIslands(char[][] grid) {
        int cnt = 0;
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                if (grid[i][j] == '1') {
                    ++cnt;
                    destroy(grid, i, j);
                }
            }
        }
        return cnt;
    }
    private void destroy(char[][] grid, int x, int y) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length) return;
        if (grid[x][y] == '0') return;
        grid[x][y] = '0';
        destroy(grid, x - 1, y);
        destroy(grid, x + 1, y);
        destroy(grid, x, y - 1);
        destroy(grid, x, y + 1);
    }
}
