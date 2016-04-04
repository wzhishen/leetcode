package solutions;

/**
 * https://leetcode.com/problems/factorial-trailing-zeroes/
 *
 * Given an integer n, return the number of trailing zeroes in n!.
 * Note: Your solution should be in logarithmic time complexity.
 */
public class FactorialTrailingZeroes_172 {
    // O(log5 n) time
    public int trailingZeroes(int n) {
        int cnt = 0;
        while (n > 0) {
            cnt += n / 5;
            n /= 5;
        }
        return cnt;
    }

    // Can't handle test case n = 1808548329 which makes i overflow:
    // i = 5^14 = 6103515625 > (2^32-1) / 2 = 2147483647
    public int trailingZeroes2(int n) {
        int cnt = 0;
        for (int i = 5; i <= n; i *= 5) {
            cnt += n / i;
        }
        return cnt;
    }
}
