package project2026.solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/*
https://leetcode.com/problems/alien-dictionary/description

There is a new alien language that uses the English alphabet. However, the order of the letters is unknown to you.

You are given a list of strings words from the alien language's dictionary. Now it is claimed that the strings in words are sorted lexicographically by the rules of this new language.

If this claim is incorrect, and the given arrangement of string in words cannot correspond to any order of letters, return "".

Otherwise, return a string of the unique letters in the new alien language sorted in lexicographically increasing order by the new language's rules. If there are multiple solutions, return any of them.



Example 1:

Input: words = ["wrt","wrf","er","ett","rftt"]
Output: "wertf"

Example 2:

Input: words = ["z","x"]
Output: "zx"

Example 3:

Input: words = ["z","x","z"]
Output: ""
Explanation: The order is invalid, so return "".


Constraints:

1 <= words.length <= 100
1 <= words[i].length <= 100
words[i] consists of only lowercase English letters.

 */
public class Q0269_AlienDictionary {
    public String alienOrder(String[] words) {
        HashMap<Character, ArrayList<Character>> graph = new HashMap<>();
        HashMap<Character, Integer> indegree = new HashMap<>();
        for (String word : words) {
            for (char ch : word.toCharArray()) {
                graph.putIfAbsent(ch, new ArrayList<>());
                indegree.putIfAbsent(ch, 0);
            }
        }

        /* Key: how to build the graph?
         * For every two adjacent words w1, w2, find first char index i that distinguishes them,
         * then the edge is w1[i] -> w2[i]
         */
        for (int i = 0; i < words.length - 1; ++i) {
            String word1 = words[i];
            String word2 = words[i + 1];
            if (word1.length() > word2.length() && word1.startsWith(word2)) return ""; // new test cases: ab, abc -> OK; abc, ab -> NO
            int j = 0;
            while (j < word1.length() && j < word2.length() && word1.charAt(j) == word2.charAt(j)) ++j;
            if (j == word1.length() || j == word2.length()) continue;
            char ch1 = word1.charAt(j);
            char ch2 = word2.charAt(j);
            graph.get(ch1).add(ch2);
            indegree.put(ch2, indegree.get(ch2) + 1);
        }

        Queue<Character> q = new LinkedList<>();
        for (char ch : indegree.keySet()) {
            if (indegree.get(ch) == 0) {
                q.offer(ch);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!q.isEmpty()) {
            char ch = q.poll();
            sb.append(ch);
            for (char next : graph.get(ch)) {
                int indeg = indegree.get(next) - 1;
                indegree.put(next, indeg);
                if (indeg == 0) {
                    q.offer(next);
                }
            }
        }
        return sb.length() == indegree.size() ? sb.toString() : "";
    }
}
