package solutions;

import java.util.Set;

/**
 * https://leetcode.com/problems/word-break/
 *
 * Given a string s and a dictionary of words dict, determine if s can be
 * segmented into a space-separated sequence of one or more dictionary words.
 *
 * For example, given
 * s = "leetcode",
 * dict = ["leet", "code"].
 * Return true because "leetcode" can be segmented as "leet code".
 */
public class WordBreak_139 {
    /*
     * DP recurrence:
     * dp[i+1] means S[0, i] can break
     * dp[i+1] = true iff S[0, j-1] can break and S[j, i] is a word
     *             => dp[j] == true && dict.contains(S[j, i])
     *                where 0 <= j <= i
     */
    public boolean wordBreak(String s, Set<String> dict) {
        if (s == null || dict == null) return false;
        boolean dp[] = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 0; i < s.length(); ++i) {
            for (int j = 0; j <= i; ++j) {
                if (dp[j] && dict.contains(s.substring(j, i + 1))) {
                    dp[i + 1] = true;
                }
            }
        }
        return dp[s.length()];
    }
}
