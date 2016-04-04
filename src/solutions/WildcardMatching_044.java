package solutions;

/**
 * https://leetcode.com/problems/wildcard-matching/
 *
 * Implement wildcard pattern matching with support for '?' and '*'.
 * '?' Matches any single character.
 * '*' Matches any sequence of characters (including the empty sequence).

 * The matching should cover the entire input string (not partial).
 * The function prototype should be:
 * bool isMatch(const char *s, const char *p)
 * 
 * Some examples:
 * isMatch("aa","a") ¡ú false
 * isMatch("aa","aa") ¡ú true
 * isMatch("aaa","aa") ¡ú false
 * isMatch("aa", "*") ¡ú true
 * isMatch("aa", "a*") ¡ú true
 * isMatch("ab", "?*") ¡ú true
 * isMatch("aab", "c*a*b") ¡ú false
 */
public class WildcardMatching_044 {
    /* Reference:
     * http://shmilyaw-hotmail-com.iteye.com/blog/2154716
     */
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) return false;

        int sInd = 0, pInd = 0, starInd = -1, lastSInd = -1;
        while (sInd < s.length()) {
            if (pInd < p.length() && (s.charAt(sInd) == p.charAt(pInd) || p.charAt(pInd) == '?')) {
                ++sInd;
                ++pInd;
            } else if (pInd < p.length() && p.charAt(pInd) == '*') {
                starInd = pInd;
                pInd = starInd + 1;
                lastSInd = sInd;
            } else if (starInd != -1) {
                pInd = starInd + 1;
                ++lastSInd;
                sInd = lastSInd;
            } else {
                return false;
            }
        }
        while (pInd < p.length() && p.charAt(pInd) == '*') ++pInd;
        return pInd == p.length();
    }

    /*
     * DP recurrence formula:
     * dp[i][j] records if s[0..i] and p[0..j] matches.
     *
     * 1. if s[i] == p[j] or p[j] == '?':
     *    dp[i][j] = dp[i-1][j-1]
     *
     * 2. if p[j] == '*':
     *    dp[i][j] = dp[i][j-1]   // * matches ''
     *            || dp[i-1][j-1] // * matches 1 char: s[i-1..i]
     *            || dp[i-2][j-1] // * matches 2 chars: s[i-2..i]
     *            || ...
     *            || dp[0][j-1]   // * matches i chars: s[1..i]
     *
     * Since dp[i][j] = dp[i][j-1] || dp[i-1][j-1] || dp[i-2][j-1] || ... || dp[0][j-1]
     *    => dp [i-1][j] = dp[i-1][j-1] || dp[i-2][j-1] || dp[i-3][j-1] || ... || dp[0][j-1]
     *
     * So dp[i][j] = dp[i][j-1] || dp[i-1][j]
     *
     * Reference:
     * http://www.cnblogs.com/yuzhangcmu/p/4116153.html
     */
    public boolean isMatchDP(String s, String p) {
        if (s == null || p == null) return false;

        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        for (int j = 1; j <= p.length(); ++j) { // s is empty
            if (p.charAt(j - 1) == '*') dp[0][j] = dp[0][j - 1];
        }
        for (int i = 1; i <= s.length(); ++i) {
            for (int j = 1; j <= p.length(); ++j) {
                if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                } else if (p.charAt(j - 1) == '?' || p.charAt(j - 1) == s.charAt(i - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                }
            }
        }
        return dp[s.length()][p.length()];
    }
}
