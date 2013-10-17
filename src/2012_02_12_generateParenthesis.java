public class Solution {
    public ArrayList<String> generateParenthesis(int n) {
        // Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

        // For example, given n = 3, a solution set is:

        // "((()))", "(()())", "(())()", "()(())", "()()()"
        
        ArrayList<String> ret = new ArrayList<String>();
        generateParenthesis(n, n, new char[2*n], 0, ret);
        return ret;
    }
    
    private void generateParenthesis(int left, int right, char[] parens, int index, ArrayList<String> res) {
        if (left < 0 || right < 0) return;
        if (left == 0 && right == 0) {
            res.add(new String(parens));
            return;
        }
        if (left > 0) {
            parens[index] = '(';
            generateParenthesis(left - 1, right, parens, index + 1, res);
        }
        if (right > left) {
            parens[index] = ')';
            generateParenthesis(left, right - 1, parens, index + 1, res);
        }
    }
}