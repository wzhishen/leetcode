package solutions;

/**
 * https://leetcode.com/problems/maximum-subarray/
 *
 * Find the contiguous subarray within an array (containing at least one
 * number) which has the largest sum.
 *
 * For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
 * the contiguous subarray [4,-1,2,1] has the largest sum = 6.
 *
 * More practice:
 * If you have figured out the O(n) solution, try coding another solution
 * using the divide and conquer approach, which is more subtle.
 */
public class MaximumSubarray_053 {
    /*
     * DP: O(n) time
     * recurrence:
     * dp[i] means max sum of subarray ending with i
     * dp[i] = dp[i-1] > 0 ? dp[i-1] + nums[i] : nums[i]
     * maxSum = max(dp[i])
     */
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        int maxSum = Integer.MIN_VALUE, sum = 0;
        for (int n : nums) {
            sum = sum > 0 ? sum + n : n;
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum;
    }

    /*
     * Divide and conquer:  O(n log n) time
     * Key: the maximum subarray must exist either in left or right part,
     * or cross the middle point.
     *
     * See why lmmax, rmmax should start with 0:
     * http://buttercola.blogspot.com/2014/08/leetcode-maximum-subarray.html
     */
    public int maxSubArray2(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        return maxSubArrayHelper(nums, 0, nums.length - 1);
    }

    private int maxSubArrayHelper(int[] nums, int low, int high) {
        if (low > high) return Integer.MIN_VALUE;
        int mid = low + (high - low) / 2;
        int lmax = maxSubArrayHelper(nums, low, mid - 1);
        int rmax = maxSubArrayHelper(nums, mid + 1, high);

        int sum = 0;
        int lmmax = 0;
        for (int i = mid - 1; i >= low; --i) {
            sum += nums[i];
            if (sum > lmmax) lmmax = sum;
        }
        sum = 0;
        int rmmax = 0;
        for (int i = mid + 1; i <= high; ++i) {
            sum += nums[i];
            if (sum > rmmax) rmmax = sum;
        }
        return Math.max(lmmax + rmmax + nums[mid], Math.max(lmax, rmax));
    }
}
