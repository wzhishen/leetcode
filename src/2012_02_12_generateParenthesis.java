public class Solution {
    // Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

    // For example, given n = 3, a solution set is:

    // "((()))", "(()())", "(())()", "()(())", "()()()"
    
    public ArrayList<String> generateParenthesis(int n) {
        ArrayList<String> ret = new ArrayList<String>();
        generateParenthesis(n, n, "", ret);
        return ret;
    }
    
    private void generateParenthesis(int left, int right, String parens, ArrayList<String> res) {
        if (left < 0 || right < 0) return;
        if (left == 0 && right == 0) {
            res.add(parens);
            return;
        }
        if (left > 0) generateParenthesis(left - 1, right, parens + '(', res);
        if (right > left) generateParenthesis(left, right - 1, parens + ')', res);
    }
    }
}