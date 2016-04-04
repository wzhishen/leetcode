package solutions;

/**
 * https://leetcode.com/problems/decode-ways/
 *
 * A message containing letters from A-Z is being encoded to numbers using
 * the following mapping:
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * Given an encoded message containing digits, determine the total number
 * of ways to decode it.
 *
 * For example,
 * Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).
 * The number of ways decoding "12" is 2.
 */
public class DecodeWays_091 {
    // DP recurrence:
    // dp[i] = dp[i - 1] if s[i] is valid
    //       + dp[i - 2] if s[i-1..i] is valid
    public int numDecodings(String s) {
        if (s == null || s.isEmpty()) return 0;
        int[] dp = new int[s.length()];
        for (int i = 0; i < s.length(); ++i) {
            int ways = 0;
            if (s.charAt(i) >= '1' && s.charAt(i) <= '9') {
                if (i == 0) ways += 1;
                if (i - 1 >= 0) ways += dp[i - 1];
            }
            if (i - 1 >= 0 && (s.charAt(i - 1) == '1' || s.charAt(i - 1) == '2' && s.charAt(i) <= '6')) {
                if (i == 1) ways += 1;
                if (i - 2 >= 0) ways += dp[i - 2];
            }
            dp[i] = ways;
        }
        return dp[dp.length - 1];
    }
}
