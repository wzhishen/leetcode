package solutions;

import java.util.Stack;

/**
 * https://leetcode.com/problems/basic-calculator/
 *
 * Implement a basic calculator to evaluate a simple expression string.
 * The expression string may contain open ( and closing parentheses ),
 * the plus + or minus sign -, non-negative integers and empty spaces ' '.
 * You may assume that the given expression is always valid.
 *
 * Some examples:
 * "1 + 1" = 2
 * " 2-1 + 2 " = 3
 * "(1+(4+5+2)-3)+(6+8)" = 23
 *
 * Note: Do not use the eval built-in library function.
 */
public class BasicCalculator_224 {
    // Ref: https://leetcode.com/discuss/39532/easy-18-lines-c-16-lines-python
    public int calculate(String s) {
        int res = 0;
        Stack<Integer> sign = new Stack<Integer>();
        sign.push(1); sign.push(1);
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            if (ch == ' ') {
                continue;
            } else if (ch >= '0') {
                int j = i;
                int num = 0;
                while (j < s.length() && s.charAt(j) >= '0') {
                    num = num * 10 + (s.charAt(j) - '0');
                    ++j;
                }
                res += sign.pop() * num;
                i = j - 1;
            } else if (ch == '(') {
                sign.push(sign.peek());
            } else if (ch == '+') {
                sign.push(sign.peek());
            } else if (ch == '-') {
                sign.push(-1 * sign.peek());
            } else if (ch == ')') {
                sign.pop();
            }
        }
        return res;
    }
}
