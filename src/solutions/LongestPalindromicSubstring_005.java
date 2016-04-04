package solutions;

/**
 * https://leetcode.com/problems/longest-palindromic-substring/
 *
 * Given a string S, find the longest palindromic substring in S. You may
 * assume that the maximum length of S is 1000, and there exists one unique
 * longest palindromic substring.
 */
public class LongestPalindromicSubstring_005 {
    // O(n^2) time, O(1) space
    public String longestPalindrome(String s) {
        if (s == null) return null;
        String res = "";
        for (int i = 0; i < s.length(); ++i) {
            String s1 = expand(s, i, i);
            String s2 = expand(s, i, i + 1);
            if (s1.length() > res.length() || s2.length() > res.length()) {
                res = s1.length() > s2.length() ? s1 : s2;
            }
        }
        return res;
    }

    private String expand(String s, int low, int high) {
        while (low >= 0 && high < s.length() && s.charAt(low) == s.charAt(high)) {
            --low; ++high;
        }
        return s.substring(low + 1, high);
    }

    // Optimal solution is Manacher's algorithm, O(n) time, O(n) space
    // https://en.wikipedia.org/wiki/Longest_palindromic_substring#Implementation
}
