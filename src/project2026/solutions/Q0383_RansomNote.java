package project2026.solutions;

import java.util.HashMap;

/*
https://leetcode.com/problems/ransom-note/description/

Given two strings ransomNote and magazine, return true if ransomNote can be constructed by using the letters from magazine and false otherwise.

Each letter in magazine can only be used once in ransomNote.



Example 1:

Input: ransomNote = "a", magazine = "b"
Output: false
Example 2:

Input: ransomNote = "aa", magazine = "ab"
Output: false
Example 3:

Input: ransomNote = "aa", magazine = "aab"
Output: true


Constraints:

1 <= ransomNote.length, magazine.length <= 105
ransomNote and magazine consist of lowercase English letters.

Ransom Note just means if all the letters of the 1st string are present in the 2nd string.
 */
public class Q0383_RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] map = new int[26];
        for (char ch : magazine.toCharArray()) {
            ++map[ch - 'a'];
        }
        for (char ch : ransomNote.toCharArray()) {
            if (--map[ch - 'a'] < 0) return false;
        }
        return true;
    }

     public boolean canConstruct2(String ransomNote, String magazine) {
         HashMap<Character, Integer> map = new HashMap<>();
         for (char ch : magazine.toCharArray()) {
             int cnt = map.getOrDefault(ch, 0) + 1;
             map.put(ch, cnt);
         }
         for (char ch : ransomNote.toCharArray()) {
             int cnt = map.getOrDefault(ch, 0) - 1;
             if (cnt < 0) return false;
             else map.put(ch, cnt);
         }
         return true;
     }

     public boolean canConstruct3(String ransomNote, String magazine) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char ch : magazine.toCharArray()) {
            int cnt = map.getOrDefault(ch, 0) + 1;
            map.put(ch, cnt);
        }
        for (char ch : ransomNote.toCharArray()) {
            if (!map.containsKey(ch)) return false;
            int cnt = map.getOrDefault(ch, 0) - 1;
            if (cnt == 0) map.remove(ch);
            else map.put(ch, cnt);
        }
        return true;
    }
}
