package project2026.solutions;

import java.util.Stack;

/*
https://leetcode.com/problems/backspace-string-compare

Given two strings s and t, return true if they are equal when both are typed into empty text editors. '#' means a backspace character.

Note that after backspacing an empty text, the text will continue empty.



Example 1:

Input: s = "ab#c", t = "ad#c"
Output: true
Explanation: Both s and t become "ac".

Example 2:

Input: s = "ab##", t = "c#d#"
Output: true
Explanation: Both s and t become "".

Example 3:

Input: s = "a#c", t = "b"
Output: false
Explanation: s becomes "c" while t becomes "b".


Constraints:

1 <= s.length, t.length <= 200
s and t only contain lowercase letters and '#' characters.


Follow up: Can you solve it in O(n) time and O(1) space?

 */
public class Q0844_BackspaceStringCompare {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> stack1 = convert(s);
        Stack<Character> stack2 = convert(t);
        return stack1.equals(stack2);
    }
    private Stack<Character> convert(String s) {
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (ch != '#') {
                stack.add(ch);
            } else {
                if (!stack.isEmpty()) stack.pop();
            }
        }
        return stack;
    }
}
