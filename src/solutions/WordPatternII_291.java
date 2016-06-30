package solutions;

import java.util.HashMap;
import java.util.HashSet;

/**
 * https://leetcode.com/problems/word-pattern-ii/
 *
 * Given a pattern and a string str, find if str follows the same pattern.
 * Here follow means a full match, such that there is a bijection between
 * a letter in pattern and a non-empty substring in str.
 *
 * Examples:
 * 1. pattern = "abab", str = "redblueredblue" should return true.
 * 2. pattern = "aaaa", str = "asdasdasdasd" should return true.
 * 3. pattern = "aabb", str = "xyzabcxzyabc" should return false.
 */
public class WordPatternII_291 {
    /* Ref:
     * https://segmentfault.com/a/1190000003827151
     * http://www.bo-song.com/word-pattern-ii/
     */
    public boolean wordPatternMatch(String pattern, String str) {
        if (pattern == null || str == null) return false;
        return match(pattern, str, 0, 0, new HashMap<Character, String>(), new HashSet<String>());
    }

    private boolean match(String pattern, String str, int s1, int s2, HashMap<Character, String> map, HashSet<String> set) {
        if (s1 == pattern.length() && s2 == str.length()) return true;
        if (s1 == pattern.length() || s2 == str.length()) return false;

        char c = pattern.charAt(s1);
        for (int i = s2; i < str.length(); ++i) {
            String w = str.substring(s2, i + 1);

            // old mapping
            if (map.containsKey(c)) {
                // hit old mapping, recurse to next search
                if (map.get(c).equals(w)) {
                    if (match(pattern, str, s1 + 1, i + 1, map, set)) return true;
                }
            // new mapping
            } else {
                // see unvisited word, add mapping, and recurse
                // if failed, backtrack and restore state
                if (!set.contains(w)) {
                    map.put(c, w);
                    set.add(w);
                    if (match(pattern, str, s1 + 1, i + 1, map, set)) return true;
                    map.remove(c);
                    set.remove(w);
                }
            }
            // try next word
        }
        return false;
    }
}
