package solutions;

/**
 * https://leetcode.com/problems/palindrome-permutation/
 *
 * Given a string, determine if a permutation of the string could
 * form a palindrome.
 * For example,
 * "code" -> False, "aab" -> True, "carerac" -> True.
 * Hint:
 * 1. Consider the palindromes of odd vs even length. What difference
 * do you notice?
 * 2. Count the frequency of each character.
 * 3. If each character occurs even number of times, then it must be
 * a palindrome. How about character which occurs odd number of times?
 */
public class PalindromePermutation_266 {
    public boolean canPermutePalindrome(String s) {
        if (s == null) return false;

        int[] map = new int[256];
        for (int i = 0; i < s.length(); ++i) ++map[s.charAt(i)];

        int oddCnt = 0;
        for (int cnt : map) {
            if ((cnt & 1) == 1) ++oddCnt;
            if (oddCnt > 1) return false;
        }
        return oddCnt <= 1;
    }

    // Ref: http://www.cnblogs.com/jcliBlogger/p/4748554.html
    public boolean canPermutePalindrome2(String s) {
        if (s == null) return false;

        int[] map = new int[256];
        int oddCnt = 0;
        for (int i = 0; i < s.length(); ++i) oddCnt += (++map[s.charAt(i)] & 1) == 1 ? +1 : -1;
        return oddCnt <= 1;
    }
}
