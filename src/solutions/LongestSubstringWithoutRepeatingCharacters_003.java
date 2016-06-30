package solutions;

import java.util.HashSet;

/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 *
 * Given a string, find the length of the longest substring without repeating
 * characters. For example, the longest substring without repeating letters
 * for "abcabcbb" is "abc", which the length is 3. For "bbbbb" the longest
 * substring is "b", with the length of 1.
 */
public class LongestSubstringWithoutRepeatingCharacters_003 {
    // O(n) time, O(n) space
    public int lengthOfLongestSubstring(String s) {
        if (s == null) return 0;

        HashSet<Character> set = new HashSet<>();
        int l = 0, r = 0;
        int maxLen = 0;
        while (r < s.length()) {
            char chr = s.charAt(r);
            while (set.contains(chr)) {
                set.remove(s.charAt(l++));
            }
            set.add(chr);
            maxLen = Math.max(maxLen, r - l + 1);
            ++r;
        }
        return maxLen;
    }
}
