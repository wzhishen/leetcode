package solutions;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/generate-parentheses/
 *
 * Given n pairs of parentheses, write a function to generate all combinations
 * of well-formed parentheses.
 *
 * For example, given n = 3, a solution set is:
 * "((()))", "(()())", "(())()", "()(())", "()()()"
 */
public class GenerateParentheses_022 {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<String>();
        if (n < 0) return result;
        generateParenthesis(n, n, 0, new char[n * 2], result);
        return result;
    }

    private void generateParenthesis(int left, int right, int i, char[] chars, List<String> result) {
        if (left == 0 && right == 0) {
            result.add(new String(chars));
            return;
        }
        if (left > 0) {
            chars[i] = '(';
            generateParenthesis(left - 1, right, i + 1, chars, result);
        }
        if (right > left) {
            chars[i] = ')';
            generateParenthesis(left, right - 1, i + 1, chars, result);
        }
    }
}
