package solutions;

/**
 * https://leetcode.com/problems/shortest-palindrome/
 *
 * Given a string S, you are allowed to convert it to a palindrome by adding
 * characters in front of it. Find and return the shortest palindrome you can
 * find by performing this transformation.
 *
 * For example:
 * Given "aacecaaa", return "aaacecaaa".
 * Given "abcd", return "dcbabcd".
 */
public class ShortestPalindrome_214 {
    // O(n^2) time, O(1) space
    public String shortestPalindrome(String s) {
        int i = 0, end = s.length() - 1, j = end;
        char[] str = s.toCharArray();
        while (i < j) {
            if (str[i] == str[j]) {
                ++i; --j;
            } else {
                i = 0; j = --end;
            }
        }
        return new StringBuilder(s.substring(end + 1)).reverse().append(s).toString();
    }
}
