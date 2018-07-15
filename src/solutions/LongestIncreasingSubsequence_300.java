package solutions;

import java.util.ArrayList;

/**
 * https://leetcode.com/problems/longest-increasing-subsequence/
 *
 * Given an unsorted array of integers, find the length of longest
 * increasing subsequence.
 *
 * For example,
 * Given [10, 9, 2, 5, 3, 7, 101, 18],
 * The longest increasing subsequence is [2, 3, 7, 101], therefore
 * the length is 4. Note that there may be more than one LIS
 * combination, it is only necessary for you to return the length.
 * Your algorithm should run in O(n^2) complexity.
 *
 * Follow up: Could you improve it to O(n log n) time complexity?
 */
public class LongestIncreasingSubsequence_300 {
    /* DP: O(n^2) time, O(n) space
     * recurrence:
     * dp[i] = max(dp[j] + 1) where 0 <= j < i, nums[j] < nums[i]
     */
    public int lengthOfLIS(int[] nums) {
        if (nums == null) return 0;
        int[] dp = new int[nums.length];
        int maxLen = 0;
        for (int i = 0; i < nums.length; ++i) {
            int len = 0;
            for (int j = 0; j < i; ++j) {
                if (nums[j] < nums[i]) len = Math.max(len, dp[j]);
            }
            dp[i] = len + 1;
            maxLen = Math.max(maxLen, dp[i]);
        }
        return maxLen;
    }

    /* Patience Sorting: O(n log n) time
     * Ref: https://segmentfault.com/a/1190000003819886
     */
    public int lengthOfLIS2(int[] nums) {
        if (nums == null) return 0;
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int n : nums) {
            if (list.isEmpty() || n > list.get(list.size()-1)) {
                list.add(n);
            } else {
                int low = 0, high = list.size() - 1;
                while (low <= high) {
                    int mid = low + (high - low) / 2;
                    if (n <= list.get(mid)) {
                        high = mid - 1;
                    } else {
                        low = mid + 1;
                    }
                }
                list.set(low, n);
            }
        }
        return list.size();
    }
}
