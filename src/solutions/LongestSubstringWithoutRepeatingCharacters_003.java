package solutions;

import java.util.HashMap;

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
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int maxLen = 0;
        int left = 0;
        int right = 0;
        while (right < s.length()) {
            char ch = s.charAt(right);
            if (map.containsKey(ch)) {
                while (left < right && s.charAt(left) != ch) {
                    map.remove(s.charAt(left));
                    ++left;
                }
                ++left;
            }
            map.put(ch, right);
            maxLen = Math.max(maxLen, right - left + 1);
            ++right;
        }
        return maxLen;
    }
}
