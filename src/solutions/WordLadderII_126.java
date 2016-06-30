package solutions;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * https://leetcode.com/problems/word-ladder-ii/
 *
 * Given two words (beginWord and endWord), and a dictionary's word list, find
 * all shortest transformation sequence(s) from beginWord to endWord, such that:
 * 1. Only one letter can be changed at a time
 * 2. Each intermediate word must exist in the word list
 *
 * For example,
 * Given:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 * Return
 * [
 *   ["hit","hot","dot","dog","cog"],
 *   ["hit","hot","lot","log","cog"]
 * ]
 *
 * Note:
 * All words have the same length.
 * All words contain only lowercase alphabetic characters.
 */
public class WordLadderII_126 {
    public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
        if (beginWord == null || endWord == null || wordList == null) return null;
        Queue<String> q = new LinkedList<String>();
        HashMap<String, Integer> distance = new HashMap<String, Integer>();
        HashMap<String, List<String>> backtrack = new HashMap<String, List<String>>();
        List<List<String>> result = new LinkedList<List<String>>();
        q.add(beginWord);
        distance.put(beginWord, 0);
        while (!q.isEmpty()) {
            String curr = q.remove();
            for (String next : expand(curr, wordList)) {
                if (!distance.containsKey(next)) {
                    distance.put(next, distance.get(curr) + 1);
                    q.add(next);
                }
                if (!backtrack.containsKey(next)) {
                    backtrack.put(next, new LinkedList<String>());
                }
                backtrack.get(next).add(curr);
            }
        }
        buildResult(endWord, beginWord, new LinkedList<String>(), result, distance, backtrack);
        return result;
    }

    private void buildResult(String curr, String begin, LinkedList<String> path, List<List<String>> result,
            HashMap<String, Integer> distance, HashMap<String, List<String>> backtrack) {
        path.add(0, curr);
        if (curr.equals(begin)) {
            result.add(new LinkedList<String>(path));
        } else {
            if (backtrack.containsKey(curr)) {
                for (String prev : backtrack.get(curr)) {
                    if (distance.containsKey(prev) && distance.get(curr) == distance.get(prev) + 1) {
                        buildResult(prev, begin, path, result, distance, backtrack);
                    }
                }
            }
        }
        path.remove(0);
    }

    private List<String> expand(String word, Set<String> wordList) {
        List<String> result = new LinkedList<String>();
        char[] chars = word.toCharArray();
        for (int i = 0; i < chars.length; ++i) {
            char old = chars[i];
            for (char ch = 'a'; ch <= 'z'; ++ch) {
                if (ch != old) {
                    chars[i] = ch;
                    String newWord = new String(chars);
                    if (wordList.contains(newWord)) result.add(newWord);
                }
            }
            chars[i] = old;
        }
        return result;
    }
}
