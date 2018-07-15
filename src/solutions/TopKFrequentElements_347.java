package solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/top-k-frequent-elements/
 *
 * Given a non-empty array of integers, return the k most frequent
 * elements.
 *
 * For example,
 * Given [1,1,1,2,2,3] and k = 2, return [1,2].
 *
 * Note:
 * 1. You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
 * 2. Your algorithm's time complexity must be better than O(n log n),
 * where n is the array's size.
 */
@SuppressWarnings("unchecked")
public class TopKFrequentElements_347 {
    //Hash table + bucket sort: O(n) time, O(n + n) space
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> res = new ArrayList<>();
        if (nums == null || k <= 0) return res;

        HashMap<Integer, Integer> cntMap = new HashMap<>();
        for (int n : nums) cntMap.put(n, cntMap.getOrDefault(n, 0) + 1);

        List<Integer>[] buckets = new List[nums.length + 1];
        for (int key : cntMap.keySet()) {
            int cnt = cntMap.get(key);
            if (buckets[cnt] == null) buckets[cnt] = new ArrayList<>();
            buckets[cnt].add(key);
        }

        for (int i = buckets.length - 1; i >= 0; --i) {
            if (buckets[i] == null) continue;
            for (int n : buckets[i]) {
                if (res.size() < k) res.add(n);
                else break;
            }
        }
        return res;
    }

    // Hash table + heap: O(n log k) time, O(n + k) space
    public List<Integer> topKFrequent2(int[] nums, int k) {
        List<Integer> res = new ArrayList<>();
        if (nums == null || k <= 0) return res;

        HashMap<Integer, Integer> cntMap = new HashMap<>();
        for (int n : nums) cntMap.put(n, cntMap.getOrDefault(n, 0) + 1);

        PriorityQueue<Integer> q = new PriorityQueue<>((a, b) -> cntMap.get(a) - cntMap.get(b));
        for (int key : cntMap.keySet()) {
            if (q.size() < k) {
                q.offer(key);
            } else {
                if (cntMap.get(key) >= cntMap.get(q.peek())) {
                    q.poll();
                    q.offer(key);
                }
            }
        }
        List<Integer> result = new ArrayList<>();
        while (!q.isEmpty()) result.add(q.poll());
        return result;
    }
}
