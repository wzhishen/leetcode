package solutions;

/**
 * https://leetcode.com/problems/shortest-word-distance-iii/
 *
 * This is a follow up of Shortest Word Distance. The only difference
 * is now word1 could be the same as word2.
 *
 * Given a list of words and two words word1 and word2, return the
 * shortest distance between these two words in the list.
 * word1 and word2 may be the same and they represent two individual
 * words in the list.
 *
 * For example,
 * Assume that words = ["practice", "makes", "perfect", "coding", "makes"].
 * Given word1 = “makes”, word2 = “coding”, return 1.
 * Given word1 = "makes", word2 = "makes", return 3.
 *
 * Note:
 * You may assume word1 and word2 are both in the list.
 */
public class ShortestWordDistanceIII_245 {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        if (words == null || word1 == null || word2 == null) return -1;

        int p1 = -1, p2 = -1, minDist = words.length;
        for (int i = 0; i < words.length; ++i) {
            // handle same word
            if (word1.equals(word2)) {
                if (words[i].equals(word1)) {
                    if (p1 < p2) p1 = i;
                    else p2 = i;
                }
            // normal case
            } else {
                if (words[i].equals(word1)) p1 = i;
                else if (words[i].equals(word2)) p2 = i;
            }
            if (p1 != -1 && p2 != -1) minDist = Math.min(minDist, Math.abs(p1 - p2));
        }
        return minDist;
    }
}
