package solutions;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/number-of-islands-ii/
 *
 * A 2d grid map of m rows and n columns is initially filled with water.
 * We may perform an addLand operation which turns the water at position
 * (row, col) into a land. Given a list of positions to operate, count
 * the number of islands after each addLand operation. An island is
 * surrounded by water and is formed by connecting adjacent lands
 * horizontally or vertically. You may assume all four edges of the
 * grid are all surrounded by water.
 *
 * Example:
 * Given m = 3, n = 3, positions = [[0,0], [0,1], [1,2], [2,1]].
 * Initially, the 2d grid grid is filled with water. (Assume 0 represents
 * water and 1 represents land).
 * 0 0 0
 * 0 0 0
 * 0 0 0
 *
 * Operation #1: addLand(0, 0) turns the water at grid[0][0] into a land.
 * 1 0 0
 * 0 0 0   Number of islands = 1
 * 0 0 0
 *
 * Operation #2: addLand(0, 1) turns the water at grid[0][1] into a land.
 * 1 1 0
 * 0 0 0   Number of islands = 1
 * 0 0 0
 *
 * Operation #3: addLand(1, 2) turns the water at grid[1][2] into a land.
 * 1 1 0
 * 0 0 1   Number of islands = 2
 * 0 0 0
 *
 * Operation #4: addLand(2, 1) turns the water at grid[2][1] into a land.
 * 1 1 0
 * 0 0 1   Number of islands = 3
 * 0 1 0
 *
 * We return the result as an array: [1, 1, 2, 3]
 *
 * Challenge:
 * Can you do it in time complexity O(k log mn), where k is the length
 * of the positions?
 */
public class NumberOfIslandsII_305 {
    final int[] dx = {-1, 0, 0, 1}, dy = {0, -1, 1, 0};

    /* Ref:
     * https://www.cs.princeton.edu/~rs/AlgsDS07/01UnionFind.pdf
     * https://segmentfault.com/a/1190000004197552
     */
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> res = new ArrayList<Integer>();
        if (positions == null || m <= 0 || n <= 0) return res;

        int[] a = new int[m * n];
        for (int i = 0; i < a.length; ++i) a[i] = -1;
        int cnt = 0;
        for (int[] pos : positions) {
            int index = pos[0] * n + pos[1];
            if (a[index] != index) { // ignore duplicate positions
                a[index] = index;
                ++cnt;
                for (int i = 0; i < 4; ++i) {
                    int x = dx[i] + pos[0];
                    int y = dy[i] + pos[1];
                    int adjIndex = x * n + y;
                    // adjacent lands should be united. If not yet, united them
                    if (x >= 0 && x < m && y >= 0 && y < n && a[adjIndex] != -1) {
                        int root = root(a, adjIndex);
                        if (root != index) {
                            a[root] = index;
                            --cnt;
                        }
                    }
                }
            }
            res.add(cnt);
        }
        return res;
    }

    private int root(int[] a, int i) {
        while (i != a[i]) {
            a[i] = a[a[i]]; // Path compression to flatten tree
            i = a[i];
        }
        return i;
    }
}
