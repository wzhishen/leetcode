package project2026.solutions;

import java.util.HashMap;
import java.util.HashSet;

/*
https://leetcode.com/problems/longest-substring-without-repeating-characters/description/

Given a string s, find the length of the longest substring without duplicate characters.


Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3. Note that "bca" and "cab" are also correct answers.
Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.


Constraints:

0 <= s.length <= 5 * 104
s consists of English letters, digits, symbols and spaces.

 */
public class Q0003_LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0, right = 0;
        int res = 0;
        while (right < s.length()) {
            char chr = s.charAt(right);
            map.put(chr, map.getOrDefault(chr, 0) + 1);
            while (map.get(chr) > 1) {
                char chl = s.charAt(left);
                map.put(chl, map.get(chl) - 1);
                ++left;
            }
            res = Math.max(res, right - left + 1);
            ++right;
        }
        return res;
    }

    public int lengthOfLongestSubstring2(String s) {
        HashSet<Character> set = new HashSet<>();
        int left = 0, right = 0;
        int res = 0;
        while (right < s.length()) {
            char chr = s.charAt(right);
            while (set.contains(chr)) {
                char chl = s.charAt(left);
                set.remove(chl);
                ++left;
            }
            res = Math.max(res, right - left + 1);
            set.add(chr);
            ++right;
        }
        return res;
    }

     public int lengthOfLongestSubstring3(String s) {
         if (s == null || s.isEmpty()) return 0;
         HashSet<Character> set = new HashSet<>();
         int left = 0, right = 0;
         int res = 0;
         while (right < s.length()) {
             char chr = s.charAt(right);
             if (!set.contains(chr)) {
                 res = Math.max(res, right - left + 1);
                 set.add(chr);
                 ++right;
             } else {
                 char chl = s.charAt(left);
                 set.remove(chl);
                 ++left;
             }
         }
         return res;
     }
}
