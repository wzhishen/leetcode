package project2026.solutions;

import java.util.HashMap;

/*
https://leetcode.com/problems/valid-anagram/

Given two strings s and t, return true if t is an anagram of s, and false otherwise.



Example 1:

Input: s = "anagram", t = "nagaram"

Output: true

Example 2:

Input: s = "rat", t = "car"

Output: false



Constraints:

1 <= s.length, t.length <= 5 * 104
s and t consist of lowercase English letters.


Follow up: What if the inputs contain Unicode characters? How would you adapt your solution to such a case?

 */
public class Q0242_ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        HashMap<Character, Integer> map = new HashMap<>();
        for (char ch : s.toCharArray()) {
            int cnt = map.getOrDefault(ch , 0) + 1;
            map.put(ch, cnt);
        }
        for (char ch : t.toCharArray()) {
            if (!map.containsKey(ch)) return false;
            int cnt = map.getOrDefault(ch , 0) - 1;
            if (cnt == 0) map.remove(ch);
            else map.put(ch, cnt);
        }
        return map.isEmpty();
    }
}
