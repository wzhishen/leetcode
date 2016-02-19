package solutions;

/**
 * https://leetcode.com/problems/implement-strstr/
 *
 * Implement strStr().
 * Returns the index of the first occurrence of needle in haystack,
 * or -1 if needle is not part of haystack.
 */
public class StrStr_028 {
    // Brute force: O(mn) time, O(1) space
    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null) return -1;
        if (needle.isEmpty()) return 0;
        int m = haystack.length(), n = needle.length();
        for (int i = 0; i < m - n + 1; ++i) {
            for (int j = 0; j < n; ++j) {
                if (needle.charAt(j) != haystack.charAt(i + j)) break;
                if (j == n - 1) return i;
            }
        }
        return -1;
    }

    // KMP: O(m) time, O(n) space
}
