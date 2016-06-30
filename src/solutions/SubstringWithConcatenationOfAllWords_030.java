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
    /* Two pointers:
     * Worst case T = M * (2L/M) = O(L) time, O(N*M) space
     * L: length of string s, N: size of words, M: length of a word in words
     *
     * Ref:
     * http://www.programcreek.com/2014/06/leetcode-substring-with-concatenation-of-all-words-java/
     * http://blog.csdn.net/linhuanmars/article/details/20342851
     */
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if (s == null || words == null) return res;

        // translate words to a frequency map
        HashMap<String, Integer> target = new HashMap<>();
        for (String word : words) target.put(word, target.getOrDefault(word, 0) + 1);

        int wordLen = words[0].length();
        // traverse all starting points to cover all substrings
        for (int i = 0; i < wordLen; ++i) {
            int left = i;
            int cnt = 0;
            HashMap<String, Integer> curr = new HashMap<>();
            // two pointers
            for (int j = i; j <= s.length() - wordLen; j += wordLen) {
                String str = s.substring(j, j + wordLen);
                if (target.containsKey(str)) {
                    // expand window:
                    // add right words when possible
                    curr.put(str, curr.getOrDefault(str, 0) + 1);
                    ++cnt;
                    // narrow window:
                    // keep removing left words when violating frequency match
                    while (curr.get(str) > target.get(str)) {
                        String strLeft = s.substring(left, left + wordLen);
                        curr.put(strLeft, curr.get(strLeft) - 1);
                        --cnt;
                        left += wordLen;
                    }
                    // find a solution:
                    // remove one left word to trigger another window expansion
                    if (cnt == words.length) {
                        res.add(left);
                        String strLeft = s.substring(left, left + wordLen);
                        curr.put(strLeft, curr.get(strLeft) - 1);
                        --cnt;
                        left += wordLen;
                    }
                // non matched word found:
                // move left to new starting point and reset state
                } else {
                    left = j + wordLen;
                    cnt = 0;
                    curr.clear();
                }
            }
        }
        return res;
    }

    /* BF: O(L*N*M) time, O(N*M) space
     * L: length of string s, N: size of words, M: length of a word in words
     */
    public List<Integer> findSubstring2(String s, String[] words) {
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
}
