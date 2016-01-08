package solutions;

/**
 * https://leetcode.com/problems/longest-common-prefix/
 *
 * Write a function to find the longest common prefix string amongst an
 * array of strings.
 */
public class LongestCommonPrefix_014 {
    public String longestCommonPrefix(String[] strs) {
        String prefix = "";
        if (strs == null || strs.length == 0) return prefix;
        for (int i = 0; i < strs[0].length(); ++i) {
            char ch = strs[0].charAt(i);
            for (String s : strs) {
                if (i > s.length() - 1 || ch != s.charAt(i)) return prefix;
            }
            prefix += ch;
        }
        return prefix;
    }
}
