package solutions;

/**
 * https://leetcode.com/problems/house-robber-ii/
 *
 * Note: This is an extension of House Robber.
 *
 * After robbing those houses on that street, the thief has found himself a new
 * place for his thievery so that he will not get too much attention. This time,
 * all houses at this place are arranged in a circle. That means the first house
 * is the neighbor of the last one. Meanwhile, the security system for these houses
 * remain the same as for those in the previous street.
 * Given a list of non-negative integers representing the amount of money of each
 * house, determine the maximum amount of money you can rob tonight without alerting
 * the police.
 */
public class HouseRobberII_213 {
    /*
     * Apply DP in House Robber on two scenarios:
     * nums[0..n-1] and nums[1..n] where n = nums.length-1
     */
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);

        return Math.max(rob(nums, 0, nums.length - 2), rob(nums, 1, nums.length - 1));
    }

    private int rob(int[] nums, int left, int right) {
        int n = right - left + 1;
        int[] dp = new int[n];
        dp[0] = nums[left];
        dp[1] = Math.max(nums[left], nums[left + 1]);
        for (int i = 2; i < n; ++i) {
            dp[i] = Math.max(dp[i - 2] + nums[left + i], dp[i - 1]);
        }
        return dp[n - 1];
    }
}
