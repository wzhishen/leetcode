package solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/alien-dictionary/
 *
 * There is a new alien language which uses the latin alphabet. However,
 * the order among letters are unknown to you. You receive a list of words
 * from the dictionary, where words are sorted lexicographically by the
 * rules of this new language. Derive the order of letters in this language.
 *
 * For example,
 * Given the following words in dictionary,
 * [
 *   "wrt",
 *   "wrf",
 *   "er",
 *   "ett",
 *   "rftt"
 * ]
 * The correct order is: "wertf".
 *
 * Note:
 * 1. You may assume all letters are in lowercase.
 * 2. If the order is invalid, return an empty string.
 * 3. There may be multiple valid order of letters, return any one of them
 * is fine.
 */
public class AlienDictionary_269 {
    public String alienOrder(String[] words) {
        if (words == null) return "";

        // init
        HashMap<Character, ArrayList<Character>> graph = new HashMap<Character, ArrayList<Character>>();
        HashMap<Character, Integer> indegree = new HashMap<Character, Integer>();
        for (String word : words) {
            for (int i = 0; i < word.length(); ++i) {
                char ch = word.charAt(i);
                if (!graph.containsKey(ch)) graph.put(ch, new ArrayList<Character>());
                if (!indegree.containsKey(ch)) indegree.put(ch, 0);
            }
        }

        /* Key: how to build the graph?
         * For every two adjacent words w1, w2, find first char index i that distinguishes them,
         * then the edge is w1[i] -> w2[i]
         */
        for (int i = 0; i < words.length - 1; ++i) {
            String word1 = words[i], word2 = words[i + 1];
            int j = 0;
            while (j < word1.length() && j < word2.length() && word1.charAt(j) == word2.charAt(j)) {
                ++j;
            }
            if (j == word1.length() || j == word2.length()) continue;

            char ch1 = word1.charAt(j), ch2 = word2.charAt(j);
            ArrayList<Character> list = graph.get(ch1);
            if (!list.contains(ch2)) { // avoid adding duplicate edges
                list.add(ch2);
                graph.put(ch1, list);
                indegree.put(ch2, indegree.get(ch2) + 1);
            }
        }

        // topological sort
        Queue<Character> q = new LinkedList<Character>();
        for (Character c : indegree.keySet()) {
            if (indegree.get(c) == 0) q.add(c);
        }
        StringBuilder sb = new StringBuilder();
        while (!q.isEmpty()) {
            char node = q.remove();
            sb.append(node);
            for (char next : graph.get(node)) {
                int in = indegree.get(next) - 1;
                if (in >= 0) indegree.put(next, in);
                if (in == 0) q.add(next);
            }
        }
        return sb.length() == indegree.size() ? sb.toString() : "";
    }
}
