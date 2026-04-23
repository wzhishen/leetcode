package project2026.solutions;

import java.util.LinkedList;
import java.util.Queue;

/*
https://leetcode.com/problems/01-matrix/description/

Given an m x n binary matrix mat, return the distance of the nearest 0 for each cell.

The distance between two cells sharing a common edge is 1.



Example 1:
https://assets.leetcode.com/uploads/2021/04/24/01-1-grid.jpg

Input: mat = [[0,0,0],[0,1,0],[0,0,0]]
Output: [[0,0,0],[0,1,0],[0,0,0]]

Example 2:
https://assets.leetcode.com/uploads/2021/04/24/01-2-grid.jpg

Input: mat = [[0,0,0],[0,1,0],[1,1,1]]
Output: [[0,0,0],[0,1,0],[1,2,1]]


Constraints:

m == mat.length
n == mat[i].length
1 <= m, n <= 104
1 <= m * n <= 104
mat[i][j] is either 0 or 1.
There is at least one 0 in mat.


Note: This question is the same as 1765: https://leetcode.com/problems/map-of-highest-peak/

 */
public class Q0542_01Matrix {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[][] res = new int[m][n];
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                res[i][j] = -1;
                if (mat[i][j] == 0) {
                    res[i][j] = 0;
                    q.offer(new int[] {i, j});
                }
            }
        }

        int[][] dirs = new int[][] {{-1,0},{1,0},{0,-1},{0,1}};
        while (!q.isEmpty()) {
            int size = q.size();
            int[] curr = q.poll();
            int i = curr[0], j = curr[1];

            for (int[] dir : dirs) {
                int x = i + dir[0], y = j + dir[1];
                if (x >= 0 && x < m && y >= 0 && y < n && res[x][y] == -1) {
                    res[x][y] = res[i][j] + 1;
                    q.offer(new int[] {x, y});
                }
            }
        }
        return res;
    }
}
