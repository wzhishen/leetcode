package solutions;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/generalized-abbreviation/
 *
 * Write a function to generate the generalized abbreviations of a word.
 *
 * Example:
 * Given word = "word", return the following list (order does not matter):
 * ["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d",
 *  "1or1", "w1r1", "1o2", "2r1", "3d", "w3", "4"]
 */
public class GeneralizedAbbreviation_320 {
    public List<String> generateAbbreviations(String word) {
        List<String> res = new ArrayList<String>();
        if (word == null) return res;

        for (int mask = 0; mask < 1<<word.length(); ++mask) {
            res.add(generate(word, mask));
        }
        return res;
    }

    // bit 1 denotes a letter, 0 denotes a number
    private String generate(String word, int mask) {
        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        for (int i = 0; i < word.length(); ++i) {
            if ((mask & (1 << i)) != 0) {
                if (cnt > 0) {
                    sb.append(cnt);
                    cnt = 0;
                }
                sb.append(word.charAt(i));
            } else {
                ++cnt;
            }
        }
        if (cnt > 0) sb.append(cnt);
        return sb.toString();
    }
}
