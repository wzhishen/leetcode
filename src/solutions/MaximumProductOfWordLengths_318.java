package solutions;

/**
 * https://leetcode.com/problems/maximum-product-of-word-lengths/
 *
 * Given a string array words, find the maximum value of length(word[i]) *
 * length(word[j]) where the two words do not share common letters. You may
 * assume that each word will contain only lower case letters. If no such
 * two words exist, return 0.
 *
 * Example 1:
 * Given ["abcw", "baz", "foo", "bar", "xtfn", "abcdef"]
 * Return 16
 * The two words can be "abcw", "xtfn".
 *
 * Example 2:
 * Given ["a", "ab", "abc", "d", "cd", "bcd", "abcd"]
 * Return 4
 * The two words can be "ab", "cd".
 *
 * Example 3:
 * Given ["a", "aa", "aaa", "aaaa"]
 * Return 0
 * No such pair of words.
 */
public class MaximumProductOfWordLengths_318 {
    public int maxProduct(String[] words) {
        if (words == null) return 0;

        // Maps each word to a bit vector
        int[] map = new int[words.length];
        for (int i = 0; i < words.length; ++i) {
            for (int j = 0; j < words[i].length(); ++j) {
                int n = words[i].charAt(j) - 'a';
                map[i] |= 1 << n;
            }
        }
        int maxLen = 0;
        for (int i = 1; i < words.length; ++i) {
            for (int j = 0; j < i; ++j) {
                if ((map[i] & map[j]) == 0) {
                    maxLen = Math.max(maxLen, words[i].length() * words[j].length());
                }
            }
        }
        return maxLen;
    }
}
