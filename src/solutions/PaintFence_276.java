package solutions;

/**
 * https://leetcode.com/problems/paint-fence/
 *
 * There is a fence with n posts, each post can be painted with one
 * of the k colors.
 * You have to paint all the posts such that no more than two adjacent
 * fence posts have the same color.
 * Return the total number of ways you can paint the fence.
 *
 * Note:
 * n and k are non-negative integers.
 */
public class PaintFence_276 {
    /* DP recurrence:
     * dp[n] denotes total number of ways to paint a fence with n posts.
     *
     * dp[i] = dp[i-1] * (k-1) // Post i and i-1 have different colors, so there are only k-1 colors
     *                         // (different from post i-1) to choose from to paint post i.
     *
     *       + dp[i-2] * 1 * (k-1) // Post i and i-1 have same color, so post i and i-2 must have different colors,
     *                             // so there are only k-1 colors (different from post i-2) to choose from to paint
     *                             // post i. Post i-1 only has 1 choice, which is the same color as post i.
     *
     *       = (dp[i-2] + dp[i-1]) * (k-1)
     *
     * Ref: http://www.phperz.com/article/16/0101/178949.html
     */
    public int numWays(int n, int k) {
        if (n <= 0 || k <= 0) return 0;
        if (n == 1) return k;

        int[] dp = new int[n];
        dp[0] = k; dp[1] = k * k;
        for (int i = 2; i < n; ++i) {
            dp[i] = (dp[i - 2] + dp[i - 1]) * (k - 1);
        }
        return dp[n - 1];
    }
}
