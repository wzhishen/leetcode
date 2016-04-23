package solutions;

/**
 * https://leetcode.com/problems/reverse-words-in-a-string-ii/
 *
 * Given an input string, reverse the string word by word. A word is
 * defined as a sequence of non-space characters.
 * The input string does not contain leading or trailing spaces and
 * the words are always separated by a single space.
 *
 * For example,
 * Given s = "the sky is blue",
 * return "blue is sky the".
 *
 * Could you do it in-place without allocating extra space?
 * Related problem: Rotate Array
 */
public class ReverseWordsInAStringII_186 {
    /* "Two" pass reverse: O(n) time, O(1) space
     * 1. reverse whole string
     * 2. reverse individual words
     */
    public void reverseWords(char[] s) {
        if (s == null) return;

        reverse(s, 0, s.length - 1);
        int i = 0, j = 0;
        while (j < s.length) {
            while (j < s.length && s[j] != ' ') ++j;
            reverse(s, i, j - 1);
            i = j = j + 1;
        }
    }

    private void reverse(char[] s, int i, int j) {
        while (i < j) {
            char tmp = s[i];
            s[i] = s[j];
            s[j] = tmp;
            ++i; --j;
        }
    }
}
