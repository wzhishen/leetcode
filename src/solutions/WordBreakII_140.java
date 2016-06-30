package solutions;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode.com/problems/word-break-ii/
 *
 * Given a string s and a dictionary of words dict, add spaces in s to construct
 * a sentence where each word is a valid dictionary word.
 * Return all such possible sentences.
 *
 * For example, given
 * s = "catsanddog",
 * dict = ["cat", "cats", "and", "sand", "dog"].
 * A solution is ["cats and dog", "cat sand dog"].
 */
public class WordBreakII_140 {
    public List<String> wordBreak(String s, Set<String> dict) {
        List<String> result = new ArrayList<String>();
        if (s == null || dict == null) return result;
        // Records if S[i+1,n] can be split into valid dictionary words
        // use this pruning to speed up
        boolean[] canBreak = new boolean[s.length()];
        for (int i = 0; i < canBreak.length; ++i) canBreak[i] = true;
        wordBreak(s, dict, 0, "", result, canBreak);
        return result;
    }

    private void wordBreak(String s, Set<String> dict, int index, String sentence, List<String> result, boolean[] canBreak) {
        if (index == s.length()) {
            result.add(sentence);
        } else {
            for (int i = index; i < s.length(); ++i) {
                String word = s.substring(index, i + 1);
                if (dict.contains(word) && canBreak[i]) {
                    String newSentence = sentence.isEmpty() ? word : sentence + " " + word;
                    int oldSize = result.size();
                    wordBreak(s, dict, i + 1, newSentence, result, canBreak);
                    // No new solution found, cannot break between i and i+1
                    if (result.size() == oldSize) canBreak[i] = false;
                }
            }
        }
    }
}
