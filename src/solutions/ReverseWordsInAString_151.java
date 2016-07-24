package solutions;

/**
 * https://leetcode.com/problems/reverse-words-in-a-string/
 *
 * Given an input string, reverse the string word by word.
 * For example,
 * Given s = "the sky is blue",
 * return "blue is sky the".
 *
 * Update (2015-02-12):
 * For C programmers: Try to solve it in-place in O(1) space.
 *
 * Clarification:
 * 1. What constitutes a word?
 *    A sequence of non-space characters constitutes a word.
 * 2. Could the input string contain leading or trailing spaces?
 *    Yes. However, your reversed string should not contain leading
 *    or trailing spaces.
 * 3. How about multiple spaces between two words?
 *    Reduce them to a single space in the reversed string.
 */
public class ReverseWordsInAString_151 {
    public String reverseWords(String s) {
        if (s == null) return null;
        String result = "";
        String word = "";
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            if (ch == ' ' && word.isEmpty()) continue;
            else if (ch == ' ' && !word.isEmpty()) {
                result = word + " " + result;
                word = "";
            }
            else if (ch != ' ') {
                word += ch;
            }
        }
        if (!word.isEmpty()) result = word + " " + result;
        if (!result.isEmpty()) result = result.substring(0, result.length() - 1);
        return result;
    }

    public String reverseWords2(String s) {
        if (s == null) return null;
        String[] words = s.trim().split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (int i = words.length - 1; i > 0; --i) sb.append(words[i]).append(" ");
        return sb.append(words[0]).toString();
    }
}
