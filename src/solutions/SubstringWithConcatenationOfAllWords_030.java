package solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * https://leetcode.com/problems/substring-with-concatenation-of-all-words/
 *
 * You are given a string, s, and a list of words, words, that are all of the
 * same length. Find all starting indices of substring(s) in s that is a
 * concatenation of each word in words exactly once and without any intervening
 * characters.
 *
 * For example, given:
 * s: "barfoothefoobarman"
 * words: ["foo", "bar"]
 * You should return the indices: [0,9].
 * (order does not matter).
 */
public class SubstringWithConcatenationOfAllWords_030 {
    /* O(L*N*M) time, O(N*M) space
     * L: length of string s, N: size of words, M: length of a word in words
     */
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<Integer>();
        if (s == null || words == null) return res;

        HashMap<String, Integer> target = new HashMap<String, Integer>();
        for (String word : words) {
            int cnt = 1;
            if (target.containsKey(word)) cnt += target.get(word);
            target.put(word, cnt);
        }

        int N = words.length;
        int M = words[0].length();
        for (int i = 0; i <= s.length() - M * N; ++i) {
            HashMap<String, Integer> current = new HashMap<String, Integer>();
            int j = i;
            for (; j < i + M * N; j += M) {
                String w = s.substring(j, j + M);
                if (!target.containsKey(w)) break;
                int cnt = 1;
                if (current.containsKey(w)) cnt += current.get(w);
                if (cnt > target.get(w)) break;
                current.put(w, cnt);
            }
            if (j == i + M * N) res.add(i);
        }
        return res;
    }

    // O(L) time: http://blog.csdn.net/linhuanmars/article/details/20342851
}
