package solutions;

import java.util.TreeSet;

/**
 * https://leetcode.com/problems/contains-duplicate-iii/
 *
 * Given an array of integers, find out whether there are two distinct indices
 * i and j in the array such that the difference between nums[i] and nums[j] is
 * at most t and the difference between i and j is at most k.
 */
public class ContainsDuplicateIII_220 {
    // O(n log k) time, O(k) space
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null) return false;
        TreeSet<Long> tree = new TreeSet<Long>();
        for (int i = 0; i < nums.length; ++i) {
            long n = nums[i];
            if ((tree.floor(n) != null && n - tree.floor(n) <= t) ||
                (tree.ceiling(n) != null && tree.ceiling(n) - n <= t)) return true;
            tree.add(n);
            if (i >= k) tree.remove((long)nums[i - k]);
        }
        return false;
    }
}
