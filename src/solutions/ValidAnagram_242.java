package solutions;

/**
 * https://leetcode.com/problems/valid-anagram/
 *
 * Given two strings s and t, write a function to determine if t is an
 * anagram of s.
 *
 * For example,
 * s = "anagram", t = "nagaram", return true.
 * s = "rat", t = "car", return false.
 *
 * Note:
 * You may assume the string contains only lowercase alphabets.
 *
 * Follow up:
 * What if the inputs contain unicode characters? How would you adapt your
 * solution to such case?
 */
public class ValidAnagram_242 {
    public boolean isAnagram(String s, String t) {
        if (s == null || t == null) return false;
        if (s.length() != t.length()) return false;
        int[] chars = new int[256];
        for (int i = 0; i < s.length(); ++i) {
            ++chars[s.charAt(i)];
        }
        for (int i = 0; i < t.length(); ++i) {
            if(--chars[t.charAt(i)] < 0) return false;
        }
        return true;
    }
}
