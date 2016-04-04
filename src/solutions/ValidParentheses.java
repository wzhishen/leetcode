package solutions;

import java.util.Stack;

/**
 * https://leetcode.com/problems/valid-parentheses/
 *
 * Given a string containing just the characters '(', ')', '{', '}', '['
 * and ']', determine if the input string is valid.
 * The brackets must close in the correct order, "()" and "()[]{}" are all
 * valid but "(]" and "([)]" are not.
 */
public class ValidParentheses {
    public boolean isValid(String s) {
        if (s == null) return false;
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            if (ch == ')' || ch == ']' || ch == '}') {
                if (stack.isEmpty() || stack.pop() != ch) return false;
            } else {
                char match = ")]}".charAt("([{".indexOf(ch));
                stack.push(match);
            }
        }
        return stack.isEmpty();
    }
}
