package project2026.solutions;

import java.util.HashMap;

/*
https://leetcode.com/problems/minimum-window-substring/

Given two strings s and t of lengths m and n respectively, return the minimum window substring of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".

The testcases will be generated such that the answer is unique.



Example 1:

Input: s = "ADOBECODEBANC", t = "ABC"
Output: "BANC"
Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.

Example 2:

Input: s = "a", t = "a"
Output: "a"
Explanation: The entire string s is the minimum window.

Example 3:

Input: s = "a", t = "aa"
Output: ""
Explanation: Both 'a's from t must be included in the window.
Since the largest window of s only has one 'a', return empty string.


Constraints:

m == s.length
n == t.length
1 <= m, n <= 105
s and t consist of uppercase and lowercase English letters.


Follow up: Could you find an algorithm that runs in O(m + n) time?

 */
public class Q0076_MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> target = new HashMap<>();
        for (char ch : t.toCharArray()) {
            target.put(ch, target.getOrDefault(ch, 0) + 1);
        }
        HashMap<Character, Integer> window = new HashMap<>();
        int left = 0, right = 0;
        int cnt = 0;
        String res = "";
        while (right < s.length()) {
            char chr = s.charAt(right);
            int cntr = window.getOrDefault(chr, 0) + 1;
            window.put(chr, cntr);
            if (target.containsKey(chr) && cntr <= target.get(chr)) ++cnt;
            while (cnt == t.length()) {
                int len = right - left + 1;
                if (res.isEmpty() || len < res.length()) res = s.substring(left, right + 1);
                char chl = s.charAt(left);
                int cntl = window.get(chl) - 1;
                window.put(chl, cntl);
                if (target.containsKey(chl) && cntl < target.get(chl)) --cnt;
                ++left;
            }
            ++right;
        }
        return res;
    }

    public String minWindow2(String s, String t) {
        HashMap<Character, Integer> target = new HashMap<>();
        for (char ch : t.toCharArray()) {
            target.put(ch, target.getOrDefault(ch, 0) + 1);
        }
        HashMap<Character, Integer> window = new HashMap<>();
        int left = 0, right = 0;
        int cnt = 0; // here cnt means the count of unique chars that have been satisfied in the window
        String res = "";
        while (right < s.length()) {
            char chr = s.charAt(right);
            int cntr = window.getOrDefault(chr, 0) + 1;
            window.put(chr, cntr);
            if (target.containsKey(chr) && cntr == target.get(chr)) ++cnt; // all frequency matched for this unique char
            while (cnt == target.size()) { // all unique chars have been satisfied
                int len = right - left + 1;
                if (res.isEmpty() || len < res.length()) res = s.substring(left, right + 1);
                char chl = s.charAt(left);
                int cntl = window.get(chl) - 1;
                window.put(chl, cntl);
                if (target.containsKey(chl) && cntl == target.get(chl) - 1) --cnt; // frequency no longer matched for this unique char
                ++left;
            }
            ++right;
        }
        return res;
    }
}
