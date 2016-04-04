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
        int p = 0;
        for (int i = (s.length() - 1) / 2; i >= 0; --i) {
            int p1 = findPalindrome(s, i, i);
            int p2 = findPalindrome(s, i, i + 1);
            p = Math.max(p, p1 > p2 ? p1 : p2);
        }
        String front = "";
        while (p < s.length()) {
            front = s.charAt(p) + front;
            p++;
        }
        return front + s;
    }

    private int findPalindrome(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            --left; ++right;
        }
        if (left == -1) {
            return right;
        } else {
            return -1;
        }
    }
}
