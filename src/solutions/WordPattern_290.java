package solutions;

import java.util.HashMap;
import java.util.HashSet;

/**
 * https://leetcode.com/problems/word-pattern/
 *
 * Given a pattern and a string str, find if str follows the same pattern.
 * Here follow means a full match, such that there is a bijection between
 * a letter in pattern and a non-empty word in str.
 *
 * Examples:
 * 1. pattern = "abba", str = "dog cat cat dog" should return true.
 * 2. pattern = "abba", str = "dog cat cat fish" should return false.
 * 3. pattern = "aaaa", str = "dog cat cat dog" should return false.
 * 4. pattern = "abba", str = "dog dog dog dog" should return false.
 *
 * Notes:
 * You may assume pattern contains only lowercase letters, and str contains
 * lowercase letters separated by a single space.
 */
public class WordPattern_290 {
    public boolean wordPattern(String pattern, String str) {
        if (pattern == null || str == null) return false;
        String[] words = str.split(" ");
        if (pattern.length() != words.length) return false;
        HashMap<Character, String> map1 = new HashMap<Character, String>();
        HashMap<String, Character> map2 = new HashMap<String, Character>();
        for (int i = 0; i < pattern.length(); ++i) {
            char ch = pattern.charAt(i);
            String word = words[i];
            if (map1.containsKey(ch) && !map1.get(ch).equals(word)) return false;
            if (map2.containsKey(word) && !map2.get(word).equals(ch)) return false;
            map1.put(ch, word);
            map2.put(word, ch);
        }
        return true;
    }

    public boolean wordPattern2(String pattern, String str) {
        if (pattern == null || str == null) return false;

        String[] words = str.split(" ");
        if (pattern.length() != words.length) return false;
        HashMap<Character, String> map = new HashMap<Character, String>();
        HashSet<String> set = new HashSet<String>();
        for (int i = 0; i < pattern.length(); ++i) {
            char ch = pattern.charAt(i);
            String word = words[i];
            if (map.containsKey(ch) && !map.get(ch).equals(word)) return false;
            if (!map.containsKey(ch) && set.contains(word)) return false;
            map.put(ch, word);
            set.add(word);
        }
        return true;
    }
}
