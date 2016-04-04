package solutions;

/**
 * https://leetcode.com/problems/maximum-product-subarray/
 *
 * Find the contiguous subarray within an array (containing at least one
 * number) which has the largest product.
 *
 * For example, given the array [2,3,-2,4],
 * the contiguous subarray [2,3] has the largest product = 6.
 */
public class MaximumProductSubarray_152 {
    /*
     * DP recurrence:
     * maxProduct[i] = max(maxProduct[i-1]*A[i], // if A[i] > 0
     *                     minProduct[i-1]*A[i], // if A[i] < 0
     *                     A[i])                 // if 0 occurs before A[i]
     * minProduct[i] = min(maxProduct[i-1]*A[i], // if A[i] < 0
     *                     minProduct[i-1]*A[i], // if A[i] > 0
     *                     A[i])                 // if 0 occurs before A[i]
     */
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        int maxProduct = nums[0];
        int minProduct = nums[0];
        int result = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            int maxProductCopy = maxProduct;
            maxProduct = Math.max(Math.max(nums[i] * maxProductCopy, nums[i] * minProduct), nums[i]);
            minProduct = Math.min(Math.min(nums[i] * maxProductCopy, nums[i] * minProduct), nums[i]);
            result = Math.max(result, maxProduct);
        }
        return result;
    }
}
