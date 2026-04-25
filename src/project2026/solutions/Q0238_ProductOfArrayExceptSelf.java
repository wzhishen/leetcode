package project2026.solutions;

/*
https://leetcode.com/problems/product-of-array-except-self/

Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].

The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

You must write an algorithm that runs in O(n) time and without using the division operation.



Example 1:

Input: nums = [1,2,3,4]
Output: [24,12,8,6]
Example 2:

Input: nums = [-1,1,0,-3,3]
Output: [0,0,9,0,0]


Constraints:

2 <= nums.length <= 105
-30 <= nums[i] <= 30
The input is generated such that answer[i] is guaranteed to fit in a 32-bit integer.


Follow up: Can you solve the problem in O(1) extra space complexity? (The output array does not count as extra space for space complexity analysis.)

 */
public class Q0238_ProductOfArrayExceptSelf {
    /*
     * For example, given [a1, a2, a3, a4]
     * Construct two sequences:
     * [1, a1, a1a2, a1a2a3], [a4a3a2, a4a3, a4, 1]
     * Then multiply to merge the two:
     * [a2a3a4, a1a3a4, a1a2a4, a1a2a3]
     */
     public int[] productExceptSelf(int[] nums) {
         int n = nums.length;
         int[] prefix = new int[n];
         prefix[0] = 1;
         for (int i = 1; i < n; ++i) {
             prefix[i] = prefix[i - 1] * nums[i - 1];
         }
         int[] suffix = new int[n];
         suffix[n - 1] = 1;
         for (int i = n - 2; i >= 0; --i) {
             suffix[i] = suffix[i + 1] * nums[i + 1];
         }
         int[] res = new int[n];
         for (int i = 0; i < n; ++i) {
             res[i] = prefix[i] * suffix[i];
         }
         return res;
     }

    public int[] productExceptSelf2(int[] nums) {
        int n = nums.length;
        int[] output = new int[n];
        output[0] = 1;
        for (int i = 1; i < n; ++i) {
            output[i] = output[i - 1] * nums[i - 1];
        }
        int p = 1;
        for (int i = n - 1; i >= 0; --i) {
            output[i] *= p;
            p *= nums[i];
        }
        return output;
    }

    // My older version
    public int[] productExceptSelf3(int[] nums) {
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
