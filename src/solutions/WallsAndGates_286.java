package solutions;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/walls-and-gates/
 *
 * You are given a m x n 2D grid initialized with these three possible values.
 * 1. -1 - A wall or an obstacle.
 * 2. 0 - A gate.
 * 3. INF - Infinity means an empty room. We use the value 2^31 - 1 = 2147483647
 * to represent INF as you may assume that the distance to a gate is less than
 * 2147483647.
 *
 * Fill each empty room with the distance to its nearest gate. If it is impossible
 * to reach a gate, it should be filled with INF.
 *
 * For example, given the 2D grid:
 * INF  -1  0  INF
 * INF INF INF  -1
 * INF  -1 INF  -1
 *   0  -1 INF INF
 *
 * After running your function, the 2D grid should be:
 *   3  -1   0   1
 *   2   2   1  -1
 *   1  -1   2  -1
 *   0  -1   3   4
 */
public class WallsAndGates_286 {
    private int[] dx = {-1, 0, 0, 1}, dy = {0, -1, 1, 0};

    public void wallsAndGates(int[][] rooms) {
        if (rooms == null || rooms.length == 0 || rooms[0].length == 0) return;

        int m = rooms.length, n = rooms[0].length;
        Queue<Integer> q = new LinkedList<Integer>();
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (rooms[i][j] == 0) q.add(i * n + j);
            }
        }

        while (!q.isEmpty()) {
            int id = q.remove();
            int i = id / n, j = id % n;
            for (int k = 0; k < 4; ++k) {
                int x = i + dx[k], y = j + dy[k];
                if (x >= 0 && y >= 0 && x < m && y < n && rooms[x][y] == Integer.MAX_VALUE) {
                    rooms[x][y] = rooms[i][j] + 1;
                    q.add(x * n + y);
                }
            }
        }
    }
}
