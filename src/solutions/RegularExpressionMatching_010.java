package solutions;

/**
 * https://leetcode.com/problems/regular-expression-matching/
 *
 * Implement regular expression matching with support for '.' and '*'.
 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.
 *
 * The matching should cover the entire input string (not partial).
 * The function prototype should be:
 * bool isMatch(const char *s, const char *p)
 *
 * Some examples:
 * isMatch("aa","a") ¡ú false
 * isMatch("aa","aa") ¡ú true
 * isMatch("aaa","aa") ¡ú false
 * isMatch("aa", "a*") ¡ú true
 * isMatch("aa", ".*") ¡ú true
 * isMatch("ab", ".*") ¡ú true
 * isMatch("aab", "c*a*b") ¡ú true
 */
public class RegularExpressionMatching_010 {
    /*
     * DP recurrence formula:
     * dp[i][j] records if s[0..i] and p[0..j] matches.
     *
     * 1. if s[i] == p[j] or p[j] == '.':
     *    dp[i][j] = dp[i-1][j-1]
     *
     * 2. if p[j] == '*':
     * 2.1 if s[i] == p[j-1] or p[j-1] == '.':
     *     dp[i][j] = dp[i][j-2] || dp[i-1][j-2] || dp[i-2][j-2] || ... || dp[0][j-2]
     *               = dp[i][j-2] || dp[i-1][j]
     *     // * matches 1 or more preceding elements
     *     // eg., "cde*" matches "cdeee" or "cde"
     * 2.2 else:
     *     dp[i][j] = dp[i][j-2]
     *     // * matches zero preceding elements
     *     // eg., "cde*" matches "cd"
     *
     * Reference:
     * http://www.cnblogs.com/jdflyfly/p/3810681.html
     */
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) return false;

        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        for (int j = 1; j <= p.length(); ++j) {
            if (j - 2 >= 0 && p.charAt(j - 1) == '*') dp[0][j] = dp[0][j - 2];
        }
        for (int i = 1; i <= s.length(); ++i) {
            for (int j = 1; j <= p.length(); ++j) {
                if (j - 2 >= 0 && p.charAt(j - 1) == '*') {
                    if (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.') {
                        dp[i][j] = dp[i][j - 2] || dp[i - 1][j];
                    } else {
                        dp[i][j] = dp[i][j - 2];
                    }
                } else if (p.charAt(j - 1) == '.' || p.charAt(j - 1) == s.charAt(i - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                }
            }
        }
        return dp[s.length()][p.length()];
    }
}
