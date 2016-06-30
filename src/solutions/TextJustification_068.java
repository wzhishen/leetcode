package solutions;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/text-justification/
 *
 * Given an array of words and a length L, format the text such that each
 * line has exactly L characters and is fully (left and right) justified.
 *
 * You should pack your words in a greedy approach; that is, pack as many
 * words as you can in each line. Pad extra spaces ' ' when necessary so
 * that each line has exactly L characters.
 *
 * Extra spaces between words should be distributed as evenly as possible.
 * If the number of spaces on a line do not divide evenly between words,
 * the empty slots on the left will be assigned more spaces than the slots
 * on the right.
 *
 * For the last line of text, it should be left justified and no extra space
 * is inserted between words.
 *
 * For example,
 * words: ["This", "is", "an", "example", "of", "text", "justification."]
 * L: 16.
 * Return the formatted lines as:
 * [
 *    "This    is    an",
 *    "example  of text",
 *    "justification.  "
 * ]
 *
 * Note: Each word is guaranteed not to exceed L in length.
 *
 * Corner Cases:
 * A line other than the last line might contain only one word. What should
 * you do in this case?
 * In this case, that line should be left-justified.
 */
public class TextJustification_068 {
    /* Ref:
     * https://leetcode.com/discuss/100959/less-than-20-line-easy-to-understand-c-solution
     */
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<String>();
        if (words == null || maxWidth < 0) return res;

        int s = 0;
        int charsLen = 0;
        for (int e = 0; e < words.length; ++e)  {
            int span = charsLen + words[e].length() + (e - s); // length of words and spaces
            if (span <= maxWidth) charsLen += words[e].length(); // length of words
            else --e;

            if (span > maxWidth) {
                res.add(makeLine(s, e, words, maxWidth, charsLen, false));
                charsLen = 0;
                s = e + 1;
            } else if (e == words.length - 1) {
                res.add(makeLine(s, e, words, maxWidth, charsLen, true));
            }
        }
        return res;
    }

    private String makeLine(int s, int e, String[] words, int maxWidth, int charsLen, boolean lastLine) {
        int spacesLen = maxWidth - charsLen;
        StringBuilder sb = new StringBuilder();
        for (int i = s; i < e; ++i) {
            sb.append(words[i]);

            // Key: calculate padding spaces needed in between
            int spacesNum = 1; // last line
            if (!lastLine) { // not last line
                // calculate least amount of spaces needed for each gap
                spacesNum = spacesLen / (e - s);
                // assign more spaces on the left gaps
                if (i - s < spacesLen % (e - s)) ++spacesNum;
            }
            padSpaces(sb, spacesNum);
        }

        sb.append(words[e]);
        // padding spaces at the end
        padSpaces(sb, maxWidth - sb.length());
        return sb.toString();
    }

    private void padSpaces(StringBuilder sb, int spacesNum) {
        for (int i = 0; i < spacesNum; ++i) sb.append(' ');
    }
}
