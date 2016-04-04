package solutions;

import java.util.Stack;

/**
 * https://leetcode.com/problems/longest-valid-parentheses/
 *
 * Given a string containing just the characters '(' and ')', find the
 * length of the longest valid (well-formed) parentheses substring.
 * For "(()", the longest valid parentheses substring is "()", which has
 * length = 2.
 * Another example is ")()())", where the longest valid parentheses
 * substring is "()()", which has length = 4.
 */
public class LongestValidParentheses_032 {
    /* O(n) time, O(n) space
     * Reference: http://tinyurl.com/pbewmho
     */
    public int longestValidParentheses(String s) {
        int maxLen = 0;
        Stack<Integer> stack = new Stack<Integer>();
        char[] str = s.toCharArray();
        for (int i = 0; i < str.length; ++i) {
            // Current ')' is a match
            if (str[i] == ')' && !stack.isEmpty() && str[stack.peek()] == '(') {
                stack.pop();
                if (stack.isEmpty()) {
                    maxLen = i + 1;
                } else {
                    maxLen = Math.max(maxLen, i - stack.peek());
                }
            // Current '(' or ')' is not a match, push it to stack
            } else {
                stack.push(i);
            }
        }
        return maxLen;
    }

    /*
     * DP recurrence:
     * dp[i] denotes max length of valid substring ending at i.
     *
     * if s[i] == '(': dp[i] = 0 // a substring ending with '(' is always invalid
     * if s[i] == ')': j = i - dp[i-1] - 1   // this ')' might match a potential '(' at j
     *   if s[j] == '(': dp[i] = 2 + dp[i-1] // means s[j..i] is valid, eg., s[j..i] = "(())"
     *                             + dp[j-1] // needs to connect with preceding valid parens, eg., s[..i] = "()()(())"
     *   else: dp[i] = 0 // this ')' does not match a '(' at j
     */
    public int longestValidParentheses2(String s) {
        char[] str = s.toCharArray();
        int[] dp = new int[str.length];
        int maxLen = 0;
        for (int i = 1; i < str.length; ++i) {
            int j = i - dp[i - 1] - 1;
            if (str[i] == ')' && j >= 0 && str[j] == '(') {
                dp[i] = 2 + dp[i - 1] + (j >= 1 ? dp[j - 1] : 0);
            }
            maxLen = Math.max(maxLen, dp[i]);
        }
        return maxLen;
    }
}
