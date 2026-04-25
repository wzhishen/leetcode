package project2026.solutions;

import java.util.HashMap;
import java.util.HashSet;

/*
https://leetcode.com/problems/longest-palindrome/

Given a string s which consists of lowercase or uppercase letters, return the length of the longest palindrome that can be built with those letters.

Letters are case sensitive, for example, "Aa" is not considered a palindrome.



Example 1:

Input: s = "abccccdd"
Output: 7
Explanation: One longest palindrome that can be built is "dccaccd", whose length is 7.

Example 2:

Input: s = "a"
Output: 1
Explanation: The longest palindrome that can be built is "a", whose length is 1.


Constraints:

1 <= s.length <= 2000
s consists of lowercase and/or uppercase English letters only.

 */
public class Q0409_LongestPalindrome {
    public int longestPalindrome(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        int res = 0;
        boolean hasOddCnt = false;
        for (char ch : map.keySet()) {
            int cnt = map.get(ch);
            if (cnt % 2 == 0) {
                res += cnt;
            } else {
                res += cnt - 1;
                hasOddCnt = true;
            }
        }
        return hasOddCnt ? res + 1 : res;
    }

    public int longestPalindrome2(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        int oddCharFreq = 0;
        for (char ch : map.keySet()) {
            if (map.get(ch) % 2 == 1) ++oddCharFreq;
        }
        return oddCharFreq == 0 ? s.length() : s.length() - oddCharFreq + 1;
    }

    public int longestPalindrome3(String s) {
        HashSet<Character> set = new HashSet<>();
        int res = 0;
        for (char ch : s.toCharArray()) {
            if (set.contains(ch)) {
                set.remove(ch);
                res += 2;
            } else {
                set.add(ch);
            }
        }
        return set.isEmpty() ? res : res + 1;
    }
}
