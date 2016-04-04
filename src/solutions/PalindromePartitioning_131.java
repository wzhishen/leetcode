package solutions;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/palindrome-partitioning/
 *
 * Given a string s, partition s such that every substring of the partition
 * is a palindrome.
 * Return all possible palindrome partitioning of s.
 *
 * For example, given s = "aab",
 * Return
 * [
 *   ["aa","b"],
 *   ["a","a","b"]
 * ]
 */
public class PalindromePartitioning_131 {
    public List<List<String>> partition(String s) {
        List<List<String>> solutions = new ArrayList<List<String>>();
        if (s == null) return solutions;

        boolean[][] isPalindrome = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); ++i) {
            for (int j = 0; j <= i; ++j) {
                isPalindrome[j][i] = s.charAt(j) == s.charAt(i) && (j + 1 > i - 1 || isPalindrome[j + 1][i - 1]);
            }
        }
        partition(s, 0, new ArrayList<String>(), solutions, isPalindrome);
        return solutions;
    }

    private void partition(String s, int index, List<String> solution, List<List<String>> solutions, boolean[][] isPalindrome) {
        if (index == s.length()) {
            solutions.add(new ArrayList<String>(solution));
        } else {
            for (int i = index; i < s.length(); ++i) {
                if (isPalindrome[index][i]) {
                    solution.add(s.substring(index, i + 1));
                    partition(s, i + 1, solution, solutions, isPalindrome);
                    solution.remove(solution.size() - 1);
                }
            }
        }
    }
}
