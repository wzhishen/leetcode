package solutions;

/**
 * https://leetcode.com/problems/bitwise-and-of-numbers-range/
 *
 * Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise
 * AND of all numbers in this range, inclusive.
 * For example, given the range [5, 7], you should return 4.
 */
public class BitwiseANDOfNumbersRange_201 {
    /*
     * Find the common left sequence
     * O(32) or O(log n) time
     */
    public int rangeBitwiseAnd(int m, int n) {
        if (m < 0 || n < 0 || m > n) return -1;

        int i = 0;
        while (m != n) {
            m >>= 1;
            n >>= 1;
            ++i;
        }
        return m << i;
    }
}
