package project2026.solutions;

/*
https://leetcode.com/problems/maximum-subarray/description/

Given an integer array nums, find the subarray with the largest sum, and return its sum.



Example 1:

Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
Explanation: The subarray [4,-1,2,1] has the largest sum 6.
Example 2:

Input: nums = [1]
Output: 1
Explanation: The subarray [1] has the largest sum 1.
Example 3:

Input: nums = [5,4,-1,7,8]
Output: 23
Explanation: The subarray [5,4,-1,7,8] has the largest sum 23.


Constraints:

1 <= nums.length <= 105
-104 <= nums[i] <= 104


Follow up: If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.

 */
public class Q0053_MaximumSubarray {
    // dp[i] means max sum of subarray ending with nums[i]
    // if dp[i-1] > 0, dp[i] = dp[i-1] + nums[i] <- add to previous subarray to form larger sum
    // else            dp[i] = nums[i]           <- do not add to previous subarray, become its own subarray
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        int res = dp[0];
        for (int i = 1; i < n; ++i) {
            dp[i] = dp[i - 1] > 0 ? dp[i - 1] + nums[i] : nums[i];
            res = Math.max(res, dp[i]);
        }
        return res;
    }

     public int maxSubArray2(int[] nums) {
         int sum = 0, res = Integer.MIN_VALUE;
         for (int num : nums) {
             sum = sum > 0 ? sum + num : num;
             res = Math.max(res, sum);
         }
         return res;
     }
}
