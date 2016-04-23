package solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * https://leetcode.com/problems/graph-valid-tree/
 *
 * Given n nodes labeled from 0 to n - 1 and a list of undirected
 * edges (each edge is a pair of nodes), write a function to check
 * whether these edges make up a valid tree.
 *
 * For example:
 * Given n = 5 and edges = [[0, 1], [0, 2], [0, 3], [1, 4]],
 * return true.
 * Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [1, 3], [1, 4]],
 * return false.
 *
 * Hint:
 * 1. Given n = 5 and edges = [[0, 1], [1, 2], [3, 4]], what should
 * your return? Is this case a valid tree?
 * 2. According to the definition of tree on Wikipedia: "a tree is
 * an undirected graph in which any two vertices are connected by
 * exactly one path. In other words, any connected graph without
 * simple cycles is a tree."
 *
 * Note:
 * You can assume that no duplicate edges will appear in edges.
 * Since all edges are undirected, [0, 1] is the same as [1, 0]
 * and thus will not appear together in edges.
 */
public class GraphValidTree_261 {
    // Union find
    public boolean validTree(int n, int[][] edges) {
        int[] root = new int[n];
        for (int i = 0; i < n; ++i) root[i] = i;
        for (int[] edge : edges) {
            int root1 = getRoot(root, edge[0]);
            int root2 = getRoot(root, edge[1]);
            if (root1 == root2) return false; // detect cycles
            root[root1] = root2;
        }
        // detect islands: n-node tree has n-1 edges
        return edges.length == n - 1;
    }

    private int getRoot(int[] root, int i) {
        while (i != root[i]) {
            root[i] = root[root[i]]; // path compression
            i = root[i];
        }
        return i;
    }

    // BFS
    public boolean validTree2(int n, int[][] edges) {
        HashMap<Integer, ArrayList<Integer>> list = new HashMap<Integer, ArrayList<Integer>>();
        for (int i = 0; i < n; ++i) list.put(i, new ArrayList<Integer>());
        for (int[] edge : edges) {
            list.get(edge[0]).add(edge[1]);
            list.get(edge[1]).add(edge[0]);
        }

        LinkedList<Integer> q = new LinkedList<Integer>();
        boolean[] visited = new boolean[n];
        q.add(0);
        while (!q.isEmpty()) {
            int node = q.remove();
            if (visited[node]) return false; // detect cycles
            visited[node] = true;
            for (int next : list.get(node)) {
                if (!visited[next]) {
                    q.add(next);
                }
            }
        }
        for (int i = 0; i < n; ++i) {
            if (!visited[i]) return false; // detect islands
        }
        return true;
    }
}
