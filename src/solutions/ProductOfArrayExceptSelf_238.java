package solutions;

/**
 * https://leetcode.com/problems/product-of-array-except-self/
 *
 * Given an array of n integers where n > 1, nums, return an array output
 * such that output[i] is equal to the product of all the elements of nums
 * except nums[i].
 * Solve it without division and in O(n).
 * For example, given [1,2,3,4], return [24,12,8,6].
 *
 * Follow up:
 * Could you solve it with constant space complexity? (Note: The output array
 * does not count as extra space for the purpose of space complexity analysis.)
 */
public class ProductOfArrayExceptSelf_238 {
    /*
     * For example, given [a1, a2, a3, a4]
     * Construct two sequences:
     * [1, a1, a1a2, a1a2a3], [a4a3a2, a4a3, a4, 1]
     * Then multiply to merge the two:
     * [a2a3a4, a1a3a4, a1a2a4, a1a2a3]
     */
    public int[] productExceptSelf(int[] nums) {
        int[] output = new int[nums.length];
        if (nums == null || nums.length == 0) return output;
        output[0] = 1;
        int p = nums[0];
        for (int i = 1; i < output.length; ++i) {
            output[i] = p;
            p *= nums[i];
        }
        p = nums[nums.length - 1];
        for (int i = output.length - 2; i >= 0; --i) {
            output[i] *= p;
            p *= nums[i];
        }
        return output;
    }
}
