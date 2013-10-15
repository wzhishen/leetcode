public class Solution {
    // Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

    // The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.

    public boolean isValid(String s) {
        if (s == null || s.isEmpty()) return false;
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); ++i) {
            char p = s.charAt(i);
            if (p == ')') {
                if (stack.isEmpty() || stack.peek() != '(') 
                    return false;
                else stack.pop();
            }
            else if (p == ']') {
                if (stack.isEmpty() || stack.peek() != '[') 
                    return false;
                else stack.pop();
            }
            else if (p == '}') {
                if (stack.isEmpty() || stack.peek() != '{') 
                    return false;
                else stack.pop();
            }
            else if (p == '(' || p == '[' || p == '{') {
                stack.push(p);
            }
        }
        return stack.isEmpty();
    }
}