package solutions;

import java.util.HashMap;

/**
 * https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/
 *
 * Given a string, find the length of the longest substring T that
 * contains at most k distinct characters.
 *
 * For example, Given s = “eceba” and k = 2,
 * T is "ece" which its length is 3.
 */
public class LongestSubstringWithAtMostKDistinctCharacters_340 {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (s == null) return 0;

        HashMap<Character, Integer> map = new HashMap<>();
        int l = 0, r = 0;
        int maxLen = 0;
        while (r < s.length()) {
            char chr = s.charAt(r);
            map.put(chr, map.getOrDefault(chr, 0) + 1);
            while (map.size() > k) {
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
