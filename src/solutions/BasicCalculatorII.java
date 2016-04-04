package solutions;

import java.util.Stack;

/**
 * https://leetcode.com/problems/basic-calculator-ii/
 *
 * Implement a basic calculator to evaluate a simple expression string.
 * The expression string contains only non-negative integers, +, -, *, /
 * operators and empty spaces . The integer division should truncate toward
 * zero.
 * You may assume that the given expression is always valid.
 *
 * Some examples:
 * "3+2*2" = 7
 * " 3/2 " = 1
 * " 3+5 / 2 " = 5
 *
 * Note: Do not use the eval built-in library function.
 */
public class BasicCalculatorII {
    /* A generalized solution that handles all '+', '-', '*', '/', '(', ')', ' '.
     * Ref: http://www.geeksforgeeks.org/expression-evaluation/
     */
    public int calculate(String s) {
        Stack<Integer> vals = new Stack<Integer>();
        Stack<Character> ops = new Stack<Character>();
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            // ignore white spaces
            if (ch == ' ') {
                continue;
            // parse numbers
            } else if (ch >= '0') {
                int j = i; int num = 0;
                while (j < s.length() && s.charAt(j) >= '0') {
                    num = num * 10 + (s.charAt(j) - '0');
                    ++j;
                }
                vals.push(num);
                i = j - 1;
            // handle open braces
            } else if (ch == '(') {
                ops.push(ch);
             // handle closing braces
            } else if (ch == ')') {
                while (ops.peek() != '(') {
                    vals.push(apply(ops.pop(), vals.pop(), vals.pop()));
                }
                ops.pop();
            // handle operators
            } else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                while (!ops.isEmpty() && isHighOrEqualPrecedence(ops.peek(), ch)) {
                    vals.push(apply(ops.pop(), vals.pop(), vals.pop()));
                }
                ops.push(ch);
            }
        }
        // handle remaining elements
        while (!ops.isEmpty()) {
            vals.push(apply(ops.pop(), vals.pop(), vals.pop()));
        }
        return vals.pop();
    }

    private boolean isHighOrEqualPrecedence(char op1, char op2) {
        if (op1 == '(') return false;
        if ((op2 == '*' || op2 == '/') && (op1 == '+' || op1 == '-')) return false;
        return true;
    }

    private int apply(char op, int a, int b) {
        switch (op) {
            case '+': return b + a;
            case '-': return b - a;
            case '*': return b * a;
            case '/': return b / a;
        }
        return 0;
    }
}
