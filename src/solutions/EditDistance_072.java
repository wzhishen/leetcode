package solutions;

public class EditDistance_072 {
    /* DP recurrence:
     * dp[i+1][j+1]: min edit distance between word1[0..i] and word2[0..j]
     *
     * if word1[i] == word2[j]:
     *    dp[i+1][j+1] = dp[i][j]
     *
     * if word1[i] != word2[j]:
     *    dp[i+1][j+1] = 1 + min(dp[i][j],   // replace word1[i] with word2[j] at i in word1
     *                           dp[i+1][j], // insert word2[j] at i+1 in word1
     *                           dp[i][j+1]) // delete word1[i] at i in word1
     *
     * Ref: http://www.programcreek.com/2013/12/edit-distance-in-java/
     */
    public int minDistance(String word1, String word2) {
        if (word1 == null || word2 == null) return -1;

        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 0; i < word1.length(); ++i) dp[i + 1][0] = i + 1;
        for (int j = 0; j < word2.length(); ++j) dp[0][j + 1] = j + 1;

        for (int i = 0; i < word1.length(); ++i) {
            for (int j = 0; j < word2.length(); ++j) {
                if (word1.charAt(i) == word2.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i][j];
                } else {
                    dp[i + 1][j + 1] = Math.min(dp[i][j], Math.min(dp[i][j + 1], dp[i + 1][j])) + 1;
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }
}
