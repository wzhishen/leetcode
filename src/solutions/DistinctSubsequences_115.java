package solutions;

/**
 * https://leetcode.com/problems/distinct-subsequences/
 *
 * Given a string S and a string T, count the number of distinct
 * subsequences of T in S.
 * A subsequence of a string is a new string which is formed from the
 * original string by deleting some (can be none) of the characters
 * without disturbing the relative positions of the remaining characters.
 * (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).
 *
 * Here is an example:
 * S = "rabbbit", T = "rabbit"
 * Return 3.
 */
public class DistinctSubsequences_115 {
    /* DP recurrence:
     * dp[i][j] denotes count of distinct T[0..i-1] in S[0..j-1]
     * if T[i-1] != S[j-1]: dp[i][j] = dp[i][j-1]
     * if T[i-1] == S[j-1]: dp[i][j] = dp[i][j-1]   // treat as if T[i-1] != S[j-1]
     *                               + dp[i-1][j-1] // take the match: T[i-1] == S[j-1]
     */
    public int numDistinct(String s, String t) {
        if (s == null || t == null) return 0;
        int[][] dp = new int[t.length() + 1][s.length() + 1];
        for (int j = 0; j <= s.length(); ++j) dp[0][j] = 1; // t is empty
        for (int i = 0; i < t.length(); ++i) {
            for (int j = 0; j < s.length(); ++j) {
                dp[i + 1][j + 1] = dp[i + 1][j] + (t.charAt(i) == s.charAt(j) ? dp[i][j] : 0);
            }
        }
        return dp[t.length()][s.length()];
    }
}
