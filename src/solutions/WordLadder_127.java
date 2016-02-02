package solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * https://leetcode.com/problems/word-ladder/
 *
 * Given two words (beginWord and endWord), and a dictionary's word list,
 * find the length of shortest transformation sequence from beginWord to
 * endWord, such that:
 * 1. Only one letter can be changed at a time
 * 2. Each intermediate word must exist in the word list
 *
 * For example,
 * Given:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 * As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" ->
 * "cog", return its length 5.
 *
 * Note:
 * Return 0 if there is no such transformation sequence.
 * All words have the same length.
 * All words contain only lowercase alphabetic characters.
 */
public class WordLadder_127 {
    // BFS while caching word distance.
    // Need extra space but good for repeated queries for endWord.
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        if (beginWord == null || endWord == null || wordList == null) return -1;
        Queue<String> q = new LinkedList<String>();
        HashMap<String, Integer> distance = new HashMap<String, Integer>();
        q.add(beginWord);
        distance.put(beginWord, 1);
        while (!q.isEmpty()) {
            String word = q.remove();
            for (String next : expand(word, wordList)) {
                if (!distance.containsKey(next)) {
                    distance.put(next, distance.get(word) + 1);
                    q.add(next);
                }
            }
        }
        return distance.containsKey(endWord) ? distance.get(endWord) : 0;
    }

    // BFS calculating length on the fly.
    public int ladderLength2(String beginWord, String endWord, Set<String> wordList) {
        if (beginWord == null || endWord == null || wordList == null) return -1;
        Queue<String> q = new LinkedList<String>();
        Set<String> visited = new HashSet<String>();
        q.add(beginWord);
        visited.add(beginWord);
        int length = 1;
        while (!q.isEmpty()) {
            ++length;
            final int SIZE = q.size();
            for (int i = 0; i < SIZE; ++i) {
                String word = q.remove();
                for (String next : expand(word, wordList)) {
                    if (!visited.contains(next)) {
                        visited.add(next);
                        if (next.equals(endWord)) {
                            return length;
                        }
                        q.add(next);
                    }
                }
            }
        }
        return 0;
    }

    private List<String> expand(String word, Set<String> wordList) {
        char[] chars = word.toCharArray();
        List<String> result = new ArrayList<String>();
        for (int i = 0; i < chars.length; ++i) {
            char old = chars[i];
            for (char ch = 'a'; ch <= 'z'; ++ch) {
                if (ch != old) {
                    chars[i] = ch;
                    String newWord = new String(chars);
                    if (wordList.contains(newWord)) {
                        result.add(newWord);
                    }
                }
            }
            chars[i] = old;
        }
        return result;
    }
}
