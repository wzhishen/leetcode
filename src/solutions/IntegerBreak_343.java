package solutions;

/**
 * https://leetcode.com/problems/integer-break/
 *
 * Given a positive integer n, break it into the sum of at least two positive
 * integers and maximize the product of those integers. Return the maximum
 * product you can get.
 *
 * For example, given n = 2, return 1 (2 = 1 + 1); given n = 10, return 36
 * (10 = 3 + 3 + 4).
 *
 * Note: you may assume that n is not less than 2.
 *
 * Hint:
 * 1. There is a simple O(n) solution to this problem.
 * 2. You may check the breaking results of n ranging from 7 to 10 to discover
 * the regularities.
 */
public class IntegerBreak_343 {
    /* See regularities starting from 5:
     * 2  -> 1*1
     * 3  -> 1*2
     * 4  -> 2*2
     *
     * 5  -> 3 * 2
     * 6  -> 3 * 3
     * 7  -> 3 * 4
     * 8  -> 3*3 * 2
     * 9  -> 3*3 * 3
     * 10 -> 3*3 * 4
     * 11 -> 3*3*3 * 2
     * 12 -> 3*3*3 * 3
     * 13 -> 3*3*3 * 4
     * ...
     *
     * Ref:
     * http://www.programcreek.com/2015/04/leetcode-integer-break-java/
     */
    public int integerBreak(int n) {
        if (n == 2) return 1;
        if (n == 3) return 2;

        int m = n / 3;
        if (n % 3 == 0) return (int) Math.pow(3, m);
        if (n % 3 == 1) return (int) Math.pow(3, m - 1) * 4;
        if (n % 3 == 2) return (int) Math.pow(3, m) * 2;
        return -1;
    }

    /* DP: https://leetcode.com/discuss/98143/java-dp-solution
     * dp[i] = max(dp[i], j * dp[i-j])
     */
}
