package solutions;

/**
 * https://leetcode.com/problems/scramble-string/
 *
 * Given a string s1, we may represent it as a binary tree by partitioning
 * it to two non-empty substrings recursively.
 * Below is one possible representation of s1 = "great":
 *     great
 *    /    \
 *   gr    eat
 *  / \    /  \
 * g   r  e   at
 *           / \
 *          a   t
 *
 * To scramble the string, we may choose any non-leaf node and swap its two
 * children.
 *
 * For example, if we choose the node "gr" and swap its two children, it
 * produces a scrambled string "rgeat".
 *     rgeat
 *    /    \
 *   rg    eat
 *  / \    /  \
 * r   g  e   at
 *            / \
 *           a   t
 *
 * We say that "rgeat" is a scrambled string of "great".
 *
 * Similarly, if we continue to swap the children of nodes "eat" and "at",
 * it produces a scrambled string "rgtae".
 *     rgtae
 *    /    \
 *   rg    tae
 *  / \    /  \
 * r   g  ta  e
 *        / \
 *       t   a
 *
 * We say that "rgtae" is a scrambled string of "great".
 *
 * Given two strings s1 and s2 of the same length, determine if s2 is a
 * scrambled string of s1.
 */
public class ScrambleString_087 {
    /* Time complexity:
     *
     * In worst case,
     * T(n) = 2[T(1) + T(n-1)] +2[T(2) + T(n-2)] + ... + 2[T(n/2) + T(n/2+1)]
     * => T(n) = 2[T(1) + T(2) + ... + T(n-1)]          ---- (A)
     *
     * Plus 1 to both sides of formula (A):
     * T(n+1) = 2[T(1) + T(2) + ... + T(n-1) + T(n)]    ---- (B)
     *
     * (B) minus (A):
     * T(n+1) - T(n) = 2[T(n) - T(1)]
     * => T(n+1) = 3T(n) + C, which is a geometric progression
     * => T(n) = O(3^n)
     */
    public boolean isScramble(String s1, String s2) {
        if (s1 == null || s2 == null) return false;

        if (s1.length() != s2.length()) return false;
        if (s1.equals(s2)) return true;

        // prune branches by using an anagram check
        int[] chars = new int[256];
        for (int i = 0; i < s1.length(); ++i) ++chars[s1.charAt(i)];
        for (int i = 0; i < s2.length(); ++i) {
            if (--chars[s2.charAt(i)] < 0) return false;
        }

        // naive recursion
        for (int i = 1; i < s1.length(); ++i) {
            String s11 = s1.substring(0, i);
            String s12 = s1.substring(i);
            String s21 = s2.substring(0, i);
            String s22 = s2.substring(i);
            // AB matches AB
            if (isScramble(s11, s21) && isScramble(s12, s22)) return true;

            s21 = s2.substring(0, s2.length() - i);
            s22 = s2.substring(s2.length() - i);
            // AB matches BA
            if (isScramble(s11, s22) && isScramble(s12, s21)) return true;
        }
        return false;
    }
}
