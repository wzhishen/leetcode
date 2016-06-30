package solutions;

import java.util.HashMap;

/**
 * https://leetcode.com/problems/longest-substring-with-at-most-two-distinct-characters/
 *
 * Given a string, find the length of the longest substring T that
 * contains at most 2 distinct characters.
 *
 * For example, Given s = “eceba”,
 * T is "ece" which its length is 3.
 */
public class LongestSubstringWithAtMostTwoDistinctCharacters_159 {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if (s == null) return 0;

        HashMap<Character, Integer> map = new HashMap<>();
        int l = 0, r = 0;
        int maxLen = 0;
        while (r < s.length()) {
            char chr = s.charAt(r);
            map.put(chr, map.getOrDefault(chr, 0) + 1);
            while (map.size() > 2) {
                char chl = s.charAt(l);
                int cntl = map.get(chl) - 1;
                if (cntl == 0) map.remove(chl);
                else map.put(chl, cntl);
                ++l;
            }
            maxLen = Math.max(maxLen, r - l + 1);
            ++r;
        }
        return maxLen;
    }
}
