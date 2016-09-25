package solutions;

/**
 * https://leetcode.com/problems/is-subsequence/
 *
 * Given a string s and a string t, check if s is subsequence of t.
 * You may assume that there is only lower case English letters in
 * both s and t. t is potentially a very long (length ~= 500,000)
 * string, and s is a short string (<=100).
 *
 * A subsequence of a string is a new string which is formed from
 * the original string by deleting some (can be none) of the characters
 * without disturbing the relative positions of the remaining characters.
 * (ie, "ace" is a subsequence of "abcde" while "aec" is not).
 *
 * Example 1:
 * s = "abc", t = "ahbgdc"
 *
 * Return true.
 *
 * Example 2:
 * s = "axc", t = "ahbgdc"
 *
 * Return false.
 */
public class IsSubsequence_392 {
    public boolean isSubsequence(String s, String t) {
        if (s == null || t == null) return false;
        if (s.isEmpty()) return true;

        int ps = 0, pt = 0;
        while (pt < t.length()) {
            if (s.charAt(ps) == t.charAt(pt)) {
                ++ps;
                if (ps == s.length()) return true;
            }
            ++pt;
        }
        return false;
    }

    // DP: Memory limit exceeded
    public boolean isSubsequence2(String s, String t) {
        if (s == null || t == null) return false;
        boolean[][] dp = new boolean[s.length() + 1][t.length() + 1];
        for (int j = 0; j <= t.length(); ++j) dp[0][j] = true;
        for (int i = 1; i <= s.length(); ++i) {
            for (int j = 1; j <= t.length(); ++j) {
                if (s.charAt(i - 1) != t.charAt(j - 1)) {
                    dp[i][j] = dp[i][j - 1];
                } else {
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j - 1];
                }
            }
        }
        return dp[s.length()][t.length()];
    }
}
