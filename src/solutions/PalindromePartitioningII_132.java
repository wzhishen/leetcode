package solutions;

/**
 * https://leetcode.com/problems/palindrome-partitioning-ii/
 *
 * Given a string s, partition s such that every substring of the partition
 * is a palindrome.
 * Return the minimum cuts needed for a palindrome partitioning of s.
 *
 * For example, given s = "aab",
 * Return 1 since the palindrome partitioning ["aa","b"] could be produced
 * using 1 cut.
 */
public class PalindromePartitioningII_132 {
    /*
     * DP recurrence:
     * dp[i] denotes palindromic min cuts for s[0..i-1]
     * if s[0..i-1] is already a palindrome: dp[i] = 0
     * else: dp[i] = min(dp[j]) + 1 where s[j..i-1] is a palindrome, 0 <= j< i
     */
    public int minCut(String s) {
        if (s == null) return -1;

        boolean[][] isPalindrome = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); ++i) {
            for (int j = 0; j <= i; ++j) {
                if (j == i || j + 1 == i) {
                    isPalindrome[j][i] = s.charAt(j) == s.charAt(i);
                } else {
                    isPalindrome[j][i] = s.charAt(j) == s.charAt(i) && isPalindrome[j + 1][i - 1];
                }
            }
        }

        int[] dp = new int[s.length() + 1];
        for (int i = 1; i <= s.length(); ++i) {
            if (isPalindrome[0][i - 1]) {
                dp[i] = 0;
            } else {
                int min = Integer.MAX_VALUE;
                for (int j = 0; j < i; ++j) {
                    if (isPalindrome[j][i-1]) {
                        min = Math.min(min, dp[j]);
                    }
                }
                dp[i] = min + 1;
            }
        }
        return dp[dp.length - 1];
    }
}
