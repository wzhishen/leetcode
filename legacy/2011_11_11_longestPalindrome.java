public class Solution {
    // Given a string S, find the longest palindromic substring in S. 
    // You may assume that the maximum length of S is 1000, and there 
    // exists one unique longest palindromic substring.

    // brute force
    public String longestPalindrome(String s) {
        for (int len = s.length(); len >= 1; --len) {
            for (int i = 0; i < s.length() - len + 1; ++i) {
                if (isPalindrome(s.substring(i, i + len))) {
                    return s.substring(i, i + len);
                }
            }
        }
        return null;
    }
    
    private boolean isPalindrome(String s) {
        for (int i = 0; i < s.length() / 2; ++i) {
            if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }
    
    private boolean isPalindrome2(String s) {
        Stack<Character> stack = new Stack<Character>();
        int i = 0;
        while (i < s.length() / 2) {
            stack.push(s.charAt(i));
            ++i;
        }
        if (s.length() % 2 == 1) {
            ++i;
        }
        while (i < s.length()) {
            if (s.charAt(i) != stack.pop()) return false;
            ++i
        }
        return true;
    }
}