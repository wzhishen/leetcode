package solutions;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/find-k-pairs-with-smallest-sums/
 *
 * You are given two integer arrays nums1 and nums2 sorted in ascending
 * order and an integer k.
 * Define a pair (u,v) which consists of one element from the first array
 * and one element from the second array.
 * Find the k pairs (u1,v1),(u2,v2) ...(uk,vk) with the smallest sums.
 *
 * Example 1:
 * Given nums1 = [1,7,11], nums2 = [2,4,6],  k = 3
 *
 * Return: [1,2],[1,4],[1,6]
 *
 * The first 3 pairs are returned from the sequence:
 * [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
 *
 * Example 2:
 * Given nums1 = [1,1,2], nums2 = [1,2,3],  k = 2
 *
 * Return: [1,1],[1,1]
 *
 * The first 2 pairs are returned from the sequence:
 * [1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]
 *
 * Example 3:
 * Given nums1 = [1,2], nums2 = [3],  k = 3 
 *
 * Return: [1,3],[2,3]
 *
 * All possible pairs are returned from the sequence:
 * [1,3],[2,3]
 */
public class FindKPairsWithSmallestSums_373 {
    // Ref: https://discuss.leetcode.com/topic/50529/java-9ms-heap-queue-solution-k-log-k/
    public List<int[]> kSmallestPairs(int[] a1, int[] a2, int k) {
        List<int[]> res = new ArrayList<>();
        if (a1.length == 0 || a2.length == 0) return res;
        int m = a1.length, n = a2.length;

        PriorityQueue<Pair> q = new PriorityQueue<Pair>((p1, p2) -> (int)(p1.sum - p2.sum));
        for (int i = 0; i < k && i < n; ++i) q.offer(new Pair(0, i, a1[0] + a2[i]));

        while (!q.isEmpty() && res.size() < k) {
            Pair p = q.poll();
            res.add(new int[] {a1[p.i], a2[p.j]});
            // At (i,j), no need to add both (i+1,j) and (i,j+1) which leads to duplication,
            // just add (i+1,j) since (i,j+1) will be covered by (i-1,j+1).
            if (p.i < m - 1) {
                q.offer(new Pair(p.i + 1, p.j, a1[p.i + 1] + a2[p.j]));
            }
        }
        return res;
    }

    class Pair {
        int i, j;
        int sum;
        public Pair(int i, int j, int sum) {
            this.i = i;
            this.j = j;
            this.sum = sum;
        }
    }
}
