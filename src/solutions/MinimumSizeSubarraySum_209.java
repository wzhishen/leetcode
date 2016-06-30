package solutions;

/**
 * https://leetcode.com/problems/minimum-size-subarray-sum/
 *
 * Given an array of n positive integers and a positive integer s, find the
 * minimal length of a subarray of which the sum >= s. If there isn't one,
 * return 0 instead.
 *
 * For example, given the array [2,3,1,2,4,3] and s = 7,
 * the subarray [4,3] has the minimal length under the problem constraint.
 *
 * More practice:
 * If you have figured out the O(n) solution, try coding another solution
 * of which the time complexity is O(n log n).
 */
public class MinimumSizeSubarraySum_209 {
    // Two pointers: O(n) time
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null) return -1;

        int i = 0, j = 0, sum = 0, minLen = Integer.MAX_VALUE;
        while (j < nums.length) {
            sum += nums[j];
            while (sum >= s) {
                minLen = Math.min(minLen, j - i + 1);
                sum -= nums[i++];
            }
            ++j;
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}
