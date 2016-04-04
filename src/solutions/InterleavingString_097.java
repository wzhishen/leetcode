package solutions;

/**
 * https://leetcode.com/problems/interleaving-string/
 *
 * Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.
 *
 * For example,
 * Given:
 * s1 = "aabcc",
 * s2 = "dbbca",
 * When s3 = "aadbbcbcac", return true.
 * When s3 = "aadbbbaccc", return false.
 */
public class InterleavingString_097 {
    /*
     * DP recurrence:
     * dp[i+1][j+1] denotes whether S1[0..i] and S2[0..j] can interleave into S3[0..i+j+1]
     *
     * dp[i+1][j+1] = true iff:
     *   S1[i] == S3[i+j+1] and dp[i][j+1] == true, or
     *   S2[j] == S3[i+j+1] and dp[i+1][j] == true
     *
     * Base case:
     * dp[0][0] = true
     * dp[i+1][0] = true if S1[i] == S3[i] and dp[i][0] == true
     * dp[0][j+1] = true if S2[j] == S3[j] and dp[0][j] == true
     */
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1 == null || s2 == null || s3 == null) return false;
        if (s3.length() != s1.length() + s2.length()) return false;

        boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];
        dp[0][0] = true;
        for (int i = 0; i < s1.length(); ++i) {
            dp[i + 1][0] = (s1.charAt(i) == s3.charAt(i)) && dp[i][0];
        }
        for (int j = 0; j < s2.length(); ++j) {
            dp[0][j + 1] = (s2.charAt(j) == s3.charAt(j)) && dp[0][j];
        }
        for (int i = 0; i < s1.length(); ++i) {
            for (int j = 0; j < s2.length(); ++j) {
                dp[i + 1][j + 1] = (s1.charAt(i) == s3.charAt(i + j + 1)) && dp[i][j + 1] ||
                           (s2.charAt(j) == s3.charAt(i + j + 1)) && dp[i + 1][j];
            }
        }
        return dp[s1.length()][s2.length()];
    }
}
