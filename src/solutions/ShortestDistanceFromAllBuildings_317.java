package solutions;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/shortest-distance-from-all-buildings/
 *
 * You want to build a house on an empty land which reaches all buildings
 * in the shortest amount of distance. You can only move up, down, left
 * and right. You are given a 2D grid of values 0, 1 or 2, where:
 * 1. Each 0 marks an empty land which you can pass by freely.
 * 2. Each 1 marks a building which you cannot pass through.
 * 3. Each 2 marks an obstacle which you cannot pass through.
 *
 * For example, given three buildings at (0,0), (0,4), (2,2), and an
 * obstacle at (0,2):
 * 1 - 0 - 2 - 0 - 1
 * |   |   |   |   |
 * 0 - 0 - 0 - 0 - 0
 * |   |   |   |   |
 * 0 - 0 - 1 - 0 - 0
 * The point (1,2) is an ideal empty land to build a house, as the total
 * travel distance of 3+3+1=7 is minimal. So return 7.
 *
 * Note:
 * There will be at least one building. If it is not possible to build
 * such house according to the above rules, return -1.
 */
public class ShortestDistanceFromAllBuildings_317 {
    private int[] dx = {-1, 0, 0, 1};
    private int[] dy = {0, -1, 1, 0};

    /* Key:
     * Keep an extra matrix counting total number of buildings each '0'
     * can reach, since a desired point should be able to reach all buildings.
     *
     * Other than that, just do naive BFS constructing a distance matrix for
     * each building. (Tried to save space by reusing any existing matrices
     * but won't be any better)
     *
     * O((m*n)^2) time, O(m*n) space
     *
     * Ref:
     * https://leetcode.com/discuss/74999/java-solution-with-explanation-and-time-complexity-analysis
     */
    public int shortestDistance(int[][] grid) {
        if (grid == null) return -1;

        int m = grid.length, n = grid[0].length;
        int buildingCnt = 0;
        int[][] dist = new int[m][n];
        int[][] nums = new int[m][n];

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 1) {
                    ++buildingCnt;
                    bfs(grid, dist, nums, i * n + j);
                }
            }
        }

        int minDist = Integer.MAX_VALUE;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (nums[i][j] == buildingCnt) minDist = Math.min(minDist, dist[i][j]);
            }
        }
        return minDist == Integer.MAX_VALUE ? -1 : minDist;
    }

    private void bfs(int[][] grid, int[][] dist, int[][] nums, int id) {
        int m = grid.length, n = grid[0].length;

        Queue<Integer> q = new LinkedList<Integer>();
        q.add(id);
        boolean[][] visited = new boolean[m][n];

        int step = 0;
        while (!q.isEmpty()) {
            final int size = q.size();
            ++step;
            for (int i = 0; i < size; ++i) {
                id = q.remove();
                int x = id / n, y = id % n;
                for (int j = 0; j < 4; ++j) {
                    int row = x + dx[j], col = y + dy[j];
                    if (row >= 0 && row < m && col >= 0 && col < n && grid[row][col] == 0 && !visited[row][col]) {
                        dist[row][col] += step;
                        ++nums[row][col];
                        visited[row][col] = true;
                        q.add(row * n + col);
                    }
                }
            }
        }
    }
}
