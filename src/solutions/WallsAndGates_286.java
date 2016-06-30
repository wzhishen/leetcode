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
    private int[] dx = {-1, 0, 0, 1};
    private int[] dy = {0, -1, 1, 0};

    public void wallsAndGates(int[][] rooms) {
        if (rooms == null) return;

        Queue<Integer> q = new LinkedList<Integer>();

        for (int i = 0; i < rooms.length; ++i) {
            for (int j = 0; j < rooms[0].length; ++j) {
                if (rooms[i][j] == 0) q.add(i * rooms[0].length + j);
            }
        }

        while (!q.isEmpty()) {
            int id = q.remove();
            int x = id / rooms[0].length;
            int y = id % rooms[0].length;
            for (int k = 0; k < 4; ++k) {
                int r = x + dx[k];
                int c = y + dy[k];
                if (r >= 0 && r < rooms.length && c >= 0 && c < rooms[0].length && rooms[r][c] == Integer.MAX_VALUE) {
                    rooms[r][c] = rooms[x][y] + 1;
                    q.add(r * rooms[0].length + c);
                }
            }
        }
    }
}
