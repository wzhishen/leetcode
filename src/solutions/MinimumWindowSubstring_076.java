package solutions;

import java.util.HashMap;

/**
 * https://leetcode.com/problems/minimum-window-substring/
 *
 * Given a string S and a string T, find the minimum window in S which will contain
 * all the characters in T in complexity O(n).
 *
 * For example,
 * S = "ADOBECODEBANC"
 * T = "ABC"
 * Minimum window is "BANC".
 *
 * Note:
 * If there is no such window in S that covers all characters in T, return the empty
 * string "".
 * If there are multiple such windows, you are guaranteed that there will always be
 * only one unique minimum window in S.
 */
public class MinimumWindowSubstring_076 {
    /* A generic two-pointers approach to solve all these "substring problems":
     *
     * 1. Use two pointers start and end to represent a window.
     * 2. Move end to find a valid window.
     * 3. When a valid window is found, move start to find a smaller window.
     * 4. Keep track of the max/min window that interests you.
     */

    // O(n) time, O(n) space
    public String minWindow(String s, String t) {
        if (s == null || t == null) return null;
        char[] S = s.toCharArray();
        char[] T = t.toCharArray();

        int[] tmap = new int[256];
        int[] smap = new int[256];
        for (char ch : T) ++tmap[ch];

        int minLen = Integer.MAX_VALUE, minI = 0, len = 0;
        int i = 0, j = 0;
        while (j < S.length) {
            ++smap[S[j]];
            if (smap[S[j]] <= tmap[S[j]]) ++len;
            if (len == T.length) {
                while (smap[S[i]] > tmap[S[i]]) {
                    --smap[S[i]];
                    ++i;
                }
                if (j - i + 1 < minLen) {
                    minLen = j - i + 1;
                    minI = i;
                }
                // trigger next search
                --smap[S[i]];
                ++i;
                --len;
            }
            ++j;
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(minI, minI + minLen);
    }

    // my version 2
    public String minWindow2(String s, String t) {
        HashMap<Character, Integer> target = new HashMap<>();
        for (int i = 0; i < t.length(); ++i) target.put(t.charAt(i), target.getOrDefault(t.charAt(i), 0) + 1);

        HashMap<Character, Integer> curr = new HashMap<>();
        int l = 0, r = 0, cnt = 0;
        String res = "";
        while (r < s.length()) {
            char chr = s.charAt(r);
            curr.put(chr, curr.getOrDefault(chr, 0) + 1);
            if (target.containsKey(chr) && curr.get(chr) <= target.get(chr)) ++cnt;
            while (cnt == t.length()) {
                if (res.isEmpty() || r - l + 1 < res.length()) res = s.substring(l, r + 1);
                char chl = s.charAt(l);
                int cntl = curr.get(chl) - 1;
                if (target.containsKey(chl) && cntl < target.get(chl)) --cnt;
                curr.put(chl, cntl);
                ++l;
            }
            ++r;
        }
        return res;
    }
}
