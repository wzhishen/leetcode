package solutions;

/**
 * https://leetcode.com/problems/minimum-size-subarray-sum/
 *
 * Given an array of n positive integers and a positive integer s, find the
 * minimal length of a subarray of which the sum ¡Ý s. If there isn't one,
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
    public int minSubArrayLen2(int s, int[] nums) {
        if (nums == null) return -1;

        int low = 0, high = 0, sum = 0, minLen = Integer.MAX_VALUE;
        while (high < nums.length) {
            while (sum < s && high < nums.length) {
                sum += nums[high];
                ++high;
            }
            while (sum >= s) {
                minLen = Math.min(minLen, high - low);
                sum -= nums[low];
                ++low;
            }
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}
