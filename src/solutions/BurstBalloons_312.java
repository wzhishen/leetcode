package solutions;

/**
 * https://leetcode.com/problems/burst-balloons/
 *
 * Given n balloons, indexed from 0 to n-1. Each balloon is painted with a
 * number on it represented by array nums. You are asked to burst all the
 * balloons.
 * If the you burst balloon i you will get nums[left] * nums[i] * nums[right]
 * coins. Here left and right are adjacent indices of i. After the burst, the
 * left and right then becomes adjacent.
 * Find the maximum coins you can collect by bursting the balloons wisely.
 *
 * Note:
 * (1) You may imagine nums[-1] = nums[n] = 1. They are not real therefore you
 * can not burst them.
 * (2) 0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100
 *
 * Example:
 * Given [3, 1, 5, 8]
 * Return 167
 *     nums = [3,1,5,8] --> [3,5,8] -->   [3,8]   -->  [8]  --> []
 *    coins =  3*1*5      +  3*5*8    +  1*3*8      + 1*8*1   = 167
 */
public class BurstBalloons_312 {
    /* DP recurrence:
     * dp[i][j] denotes max coins that can be collected from nums[i..j]
     * dp[i][j] = max(dp[i][j], nums[i-1] * nums[m] * nums[j+1] + dp[i][m-1] + dp[m+1][j])
     * 0 <= i <= m <= j < nums.length
     *
     * Ref:
     * http://www.cnblogs.com/grandyang/p/5006441.html
     * https://leetcode.com/discuss/72215/java-dp-solution-with-detailed-explanation-o-n-3
     */
    public int maxCoins(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int[][] dp = new int[nums.length][nums.length];
        for (int len = 1; len <= nums.length; ++len) {
            for (int i = 0; i < nums.length - len + 1; ++i) {
                int j = i + len - 1;
                for (int m = i; m <= j; ++m) {
                    int left = i - 1 >= 0 ? nums[i - 1] : 1;
                    int right = j + 1 < nums.length ? nums[j + 1] : 1;
                    int leftDP = m - 1 >= 0 ? dp[i][m - 1] : 0;
                    int rightDP = m + 1 < nums.length ? dp[m + 1][j] : 0;
                    dp[i][j] = Math.max(dp[i][j], leftDP + left * nums[m] * right + rightDP);
                }
            }
        }
        return dp[0][nums.length - 1];
    }
}
