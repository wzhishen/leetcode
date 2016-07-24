package solutions;

import java.util.Arrays;
import java.util.Comparator;

/**
 * https://leetcode.com/problems/russian-doll-envelopes/
 *
 * You have a number of envelopes with widths and heights given as a
 * pair of integers (w, h). One envelope can fit into another if and
 * only if both the width and height of one envelope is greater than
 * the width and height of the other envelope.
 * What is the maximum number of envelopes can you Russian doll? (put
 * one inside other)
 *
 * Example:
 * Given envelopes = [[5,4],[6,4],[6,7],[2,3]], the maximum number of
 * envelopes you can Russian doll is 3 ([2,3] => [5,4] => [6,7]).
 */
public class RussianDollEnvelopes_354 {
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes == null) return 0;
        Arrays.sort(envelopes, new Comparator<int[]>() {
            public int compare(int[] e1, int[] e2) {
                if (e1[0] == e2[0]) return e1[1] - e2[1];
                else return e1[0] - e2[0];
            }
        });

        int[] dp = new int[envelopes.length];
        int maxLen = 0;
        for (int i = 0; i < envelopes.length; ++i) {
            dp[i] = 1;
            for (int j = 0; j < i; ++j) {
                if (envelopes[j][0] < envelopes[i][0] &&
                    envelopes[j][1] < envelopes[i][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxLen = Math.max(maxLen, dp[i]);
        }
        return maxLen;
    }
}
