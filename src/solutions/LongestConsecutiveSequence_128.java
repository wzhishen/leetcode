package solutions;

import java.util.HashSet;

/**
 * https://leetcode.com/problems/longest-consecutive-sequence/
 *
 * Given an unsorted array of integers, find the length of the
 * longest consecutive elements sequence.
 *
 * For example,
 * Given [100, 4, 200, 1, 3, 2],
 * The longest consecutive elements sequence is [1, 2, 3, 4].
 * Return its length: 4.
 *
 * Your algorithm should run in O(n) complexity.
 */
public class LongestConsecutiveSequence_128 {
    /* O(n) time, O(n) space
     * Ref: http://www.acmerblog.com/leetcode-longest-consecutive-sequence-5846.html
     */
    public int longestConsecutive(int[] nums) {
        if (nums == null) return 0;

        HashSet<Integer> set = new HashSet<Integer>();
        for (int n : nums) set.add(n);

        int maxCnt = 1;
        for (int n : nums) {
            int cnt = 1;
            int left = n - 1, right = n + 1;
            while (set.contains(left)) {
                set.remove(left);
                ++cnt;
                --left;
            }
            while (set.contains(right)) {
                set.remove(right);
                ++cnt;
                ++right;
            }
            if (cnt > maxCnt) maxCnt = cnt;
        }
        return maxCnt;
    }
}
