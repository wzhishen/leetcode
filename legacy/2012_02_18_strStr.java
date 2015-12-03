public class Solution {
    // Implement strStr().

    // Returns a pointer to the first occurrence of needle in haystack, or null if needle is not part of haystack.
    
    // brute force: O(n^2) time, O(1) space
    // (Using *KMP algorithm* is another subtle solution with linear-time
    // complexity.)
    public String strStr(String haystack, String needle) {
        if (haystack == null || needle == null) return null;
        if (needle.isEmpty()) return haystack;
        for (int i = 0; i < haystack.length() - needle.length() + 1; ++i) {
            for (int j = 0; j < needle.length(); ++j) {
                if (needle.charAt(j) != haystack.charAt(i + j)) {
                    break;
                }
                if (j == needle.length() - 1) {
                    return haystack.substring(i);
                }
            }
        }
        return null;
    }
}