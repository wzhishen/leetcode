package project2026.solutions;

import java.util.LinkedList;
import java.util.Queue;

/*
https://leetcode.com/problems/rotting-oranges/description/

You are given an m x n grid where each cell can have one of three values:

0 representing an empty cell,
1 representing a fresh orange, or
2 representing a rotten orange.
Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.

Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.



Example 1:
https://assets.leetcode.com/uploads/2019/02/16/oranges.png

Input: grid = [[2,1,1],[1,1,0],[0,1,1]]
Output: 4

Example 2:

Input: grid = [[2,1,1],[0,1,1],[1,0,1]]
Output: -1
Explanation: The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.

Example 3:

Input: grid = [[0,2]]
Output: 0
Explanation: Since there are already no fresh oranges at minute 0, the answer is just 0.


Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 10
grid[i][j] is 0, 1, or 2.

 */
public class Q0994_RottingOranges {
    public int orangesRotting(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        int allCnt = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] != 0) {
                    ++allCnt;
                }
                if (grid[i][j] == 2) {
                    q.offer(new int[] {i, j});
                }
            }
        }
        if (allCnt == 0) return 0; // Edge case: no oranges

        int step = 0;
        int rottenCnt = 0;
        int[][] dirs = new int[][] {{-1,0},{1,0},{0,-1},{0,1}};
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; ++i) {
                int[] curr = q.poll();
                int x = curr[0], y = curr[1];
                ++rottenCnt;
                for (int[] dir : dirs) {
                    int r = x + dir[0], c = y + dir[1];
                    if (r >= 0 && r < m && c >= 0 && c < n && grid[r][c] == 1) {
                        grid[r][c] = 2;
                        q.offer(new int[] {r, c});
                    }
                }
            }
            ++step;
        }
        return allCnt > rottenCnt ? -1 : step - 1;
    }
}
