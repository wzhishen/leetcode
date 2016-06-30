package solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * https://leetcode.com/problems/palindrome-pairs/
 *
 * Given a list of unique words. Find all pairs of distinct indices
 * (i, j) in the given list, so that the concatenation of the two words,
 * i.e. words[i] + words[j] is a palindrome.
 *
 * Example 1:
 * Given words = ["bat", "tab", "cat"]
 * Return [[0, 1], [1, 0]]
 * The palindromes are ["battab", "tabbat"]
 *
 * Example 2:
 * Given words = ["abcd", "dcba", "lls", "s", "sssll"]
 * Return [[0, 1], [1, 0], [3, 2], [2, 4]]
 * The palindromes are ["dcbaabcd", "abcddcba", "slls", "llssssll"]
 */
public class PalindromePairs_336 {
    /* BF: O(n^2 * m) time O(1) space
     * Hashtable: O(m^2 * n) time, O(nm) space
     * n: number of words, m: avg length of each word
     *
     * Ref: http://bookshadow.com/weblog/2016/03/10/leetcode-palindrome-pairs/
     */
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (words == null) return res;

        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for (int i = 0; i < words.length; ++i) map.put(words[i], i);

        for (int i = 0; i < words.length; ++i) {
            for (int k = 0; k <= words[i].length(); ++k) {
                String left = words[i].substring(0, k);
                String right = words[i].substring(k);
                String rleft = new StringBuilder(left).reverse().toString();
                String rright = new StringBuilder(right).reverse().toString();
                if (isPalindrome(left) && map.containsKey(rright)) {
                    if (map.get(rright) != i) res.add(Arrays.asList(map.get(rright), i));
                }
                if (isPalindrome(right) && map.containsKey(rleft) && !right.isEmpty()) { // remove dups
                    if (map.get(rleft) != i) res.add(Arrays.asList(i, map.get(rleft)));
                }
            }
        }
        return res;
    }

    private boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) return false;
        }
        return true;
    }
}
