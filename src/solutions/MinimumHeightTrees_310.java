package solutions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MinimumHeightTrees_310 {
    /* Key: keep deleting leaves layer-by-layer, until reach the root.
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
