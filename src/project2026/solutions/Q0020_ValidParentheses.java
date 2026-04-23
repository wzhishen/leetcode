package project2026.solutions;

import java.util.Stack;

/*
https://leetcode.com/problems/valid-parentheses/description/

Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

1. Open brackets must be closed by the same type of brackets.
2. Open brackets must be closed in the correct order.
3. Every close bracket has a corresponding open bracket of the same type.


Example 1:

Input: s = "()"

Output: true

Example 2:

Input: s = "()[]{}"

Output: true

Example 3:

Input: s = "(]"

Output: false

Example 4:

Input: s = "([])"

Output: true

Example 5:

Input: s = "([)]"

Output: false


Constraints:

1 <= s.length <= 104
s consists of parentheses only '()[]{}'.

 */
public class Q0020_ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (")]}".contains(ch + "")) {
                if (stack.isEmpty()) return false;
                if (ch != stack.pop()) return false;
            } else {
                char match = ")]}".charAt("([{".indexOf(ch));
                stack.push(match);
            }
        }
        return stack.isEmpty();
    }

    // public boolean isValid(String s) {
    //     Stack<Character> stack = new Stack<Character>();
    //     for (char c : s.toCharArray()) {
    //         if (c == '(')
    //             stack.push(')');
    //         else if (c == '{')
    //             stack.push('}');
    //         else if (c == '[')
    //             stack.push(']');
    //         else if (stack.isEmpty() || stack.pop() != c)
    //             return false;
    //     }
    //     return stack.isEmpty();
    // }
}
