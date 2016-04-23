package solutions;

/**
 * https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/
 *
 * Given n nodes labeled from 0 to n - 1 and a list of undirected edges
 * (each edge is a pair of nodes), write a function to find the number
 * of connected components in an undirected graph.
 * Example 1:
 *      0          3
 *      |          |
 *      1 --- 2    4
 * Given n = 5 and edges = [[0, 1], [1, 2], [3, 4]], return 2.
 * Example 2:
 *      0           4
 *      |           |
 *      1 --- 2 --- 3
 * Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [3, 4]], return 1.
 * Note:
 * You can assume that no duplicate edges will appear in edges. Since all
 * edges are undirected, [0, 1] is the same as [1, 0] and thus will not
 * appear together in edges.
 */
public class NumberOfConnectedComponentsInAnUndirectedGraph_323 {
    public int countComponents(int n, int[][] edges) {
        int[] root = new int[n];
        int cnt = n;
        for (int i = 0; i < n; ++i) root[i] = i;
        for (int[] edge : edges) {
            int root1 = getRoot(root, edge[0]);
            int root2 = getRoot(root, edge[1]);
            if (root1 != root2) {
                root[root1] = root2;
                --cnt;
            }
        }
        return cnt;
    }

    private int getRoot(int[] root, int i) {
        while (i != root[i]) {
            root[i] = root[root[i]]; // path compression
            i = root[i];
        }
        return i;
    }
}
