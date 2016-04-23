package solutions;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * https://leetcode.com/problems/shortest-word-distance-ii/
 *
 * This is a follow up of Shortest Word Distance. The only difference
 * is now you are given the list of words and your method will be called
 * repeatedly many times with different parameters. How would you optimize
 * it?
 *
 * Design a class which receives a list of words in the constructor, and
 * implements a method that takes two words word1 and word2 and return the
 * shortest distance between these two words in the list.
 *
 * For example,
 * Assume that words = ["practice", "makes", "perfect", "coding", "makes"].
 * Given word1 = “coding”, word2 = “practice”, return 3.
 * Given word1 = "makes", word2 = "coding", return 1.
 *
 * Note:
 * You may assume that word1 does not equal to word2, and word1 and word2
 * are both in the list.
 */
public class ShortestWordDistanceII_244 {

    public class WordDistance {
        private HashMap<String, ArrayList<Integer>> map;

        public WordDistance(String[] words) {
            map = new HashMap<String, ArrayList<Integer>>();
            if (words == null) return;

            for (int i = 0; i < words.length; ++i) {
                ArrayList<Integer> list = map.containsKey(words[i]) ?
                    map.get(words[i]) : new ArrayList<Integer>();
                list.add(i);
                map.put(words[i], list);
            }
        }

        public int shortest(String word1, String word2) {
            if (word1 == null || word2 == null) return -1;

            int minDist = Integer.MAX_VALUE;
            ArrayList<Integer> list1 = map.get(word1);
            ArrayList<Integer> list2 = map.get(word2);
            int i = 0, j = 0;
            while (i < list1.size() && j < list2.size()) {
                int pos1 = list1.get(i);
                int pos2 = list2.get(j);
                minDist = Math.min(minDist, Math.abs(pos1 - pos2));
                if (pos1 < pos2) ++i;
                else ++j;
            }
            return minDist;
        }
    }

    // Your WordDistance object will be instantiated and called as such:
    // WordDistance wordDistance = new WordDistance(words);
    // wordDistance.shortest("word1", "word2");
    // wordDistance.shortest("anotherWord1", "anotherWord2");
}
