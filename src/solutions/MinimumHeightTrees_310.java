package solutions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/minimum-height-trees/
 *
 * For a undirected graph with tree characteristics, we can choose any
 * node as the root. The result graph is then a rooted tree. Among all
 * possible rooted trees, those with minimum height are called minimum
 * height trees (MHTs). Given such a graph, write a function to find
 * all the MHTs and return a list of their root labels.
 *
 * Format:
 * The graph contains n nodes which are labeled from 0 to n - 1. You will
 * be given the number n and a list of undirected edges (each edge is a
 * pair of labels). You can assume that no duplicate edges will appear in
 * edges. Since all edges are undirected, [0, 1] is the same as [1, 0] and
 * thus will not appear together in edges.
 *
 * Example 1:
 * Given n = 4, edges = [[1, 0], [1, 2], [1, 3]]
 *         0
 *         |
 *         1
 *        / \
 *       2   3
 * return [1]
 *
 * Example 2:
 * Given n = 6, edges = [[0, 3], [1, 3], [2, 3], [4, 3], [5, 4]]
 *      0  1  2
 *       \ | /
 *         3
 *         |
 *         4
 *         |
 *         5
 * return [3, 4]
 *
 * Hint:
 * How many MHTs can a graph have at most?
 *
 * Note:
 * (1) According to the definition of tree on Wikipedia: "a tree is an
 * undirected graph in which any two vertices are connected by exactly
 * one path. In other words, any connected graph without simple cycles
 * is a tree."
 * (2) The height of a rooted tree is the number of edges on the longest
 * downward path between the root and a leaf.
 */
public class MinimumHeightTrees_310 {
    /* Key: keep deleting leaves layer-by-layer, until we reach the root.
     * Ref: https://leetcode.com/discuss/71656/c-solution-o-n-time-o-n-space
     */
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> res = new ArrayList<Integer>();
        if (n <= 0 || edges == null) return res;
        if (n == 1) {
            res.add(0); return res;
        }

        List<List<Integer>> graph = new ArrayList<List<Integer>>();
        for (int i = 0; i < n; ++i) graph.add(new ArrayList<Integer>());
        int[] indegree = new int[n];
        for (int[] e : edges) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
            ++indegree[e[0]];
            ++indegree[e[1]];
        }

        LinkedList<Integer> q = new LinkedList<Integer>();
        for (int i = 0; i < n; ++i) {
            if (indegree[i] == 1) q.add(i);
        }
        while (n > 2) {
            final int size = q.size();
            for (int i = 0; i < size; ++i) {
                int curr = q.remove();
                --n;
                for (int next : graph.get(curr)) {
                    --indegree[next];
                    if (indegree[next] == 1) q.add(next);
                }
            }
            
        }
        return q;
    }
}
