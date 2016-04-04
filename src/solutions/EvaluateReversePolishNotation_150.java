package solutions;

import java.util.Stack;

/**
 * https://leetcode.com/problems/evaluate-reverse-polish-notation/
 *
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 * Valid operators are +, -, *, /. Each operand may be an integer or another expression.
 *
 * Some examples:
 * ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
 * ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 */
public class EvaluateReversePolishNotation_150 {
    // assume all operators take 2 arguments
    public int evalRPN(String[] tokens) {
        Stack<Integer> s = new Stack<Integer>();
        for (String token : tokens) {
            if (token.equals("+")) {
                s.push(s.pop() + s.pop());
            } else if (token.equals("-")) {
                int sec = s.pop();
                s.push(s.pop() - sec);
            } else if (token.equals("*")) {
                s.push(s.pop() * s.pop());
            } else if (token.equals("/")) {
                int sec = s.pop();
                s.push(s.pop() / sec);
            } else {
                s.push(Integer.parseInt(token));
            }
        }
        return s.pop();
    }
}
