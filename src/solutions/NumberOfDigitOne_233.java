package solutions;

/**
 * https://leetcode.com/problems/number-of-digit-one/
 *
 * Given an integer n, count the total number of digit 1 appearing in all
 * non-negative integers less than or equal to n.
 *
 * For example:
 * Given n = 13,
 * Return 6, because digit 1 occurred in the following numbers:
 * 1, 10, 11, 12, 13.
 *
 * Hint:
 * Beware of overflow.
 */
public class NumberOfDigitOne_233 {
    /* Count 1s digit by digit
     *
     * Eg.,
     * n = 54215, counting at hundred position:
     * divide n into two parts, left = 542, right = 15, and a base value b = 100
     * digit is 2 (> 1), matched numbers are XX100~XX199 where XX is 0~54, ie,:
     * 100~199,
     * 1100~1199, 2100~2199, 3100~3199 ... 9100~9199,
     * 10100~10199, 11100~11199 ... 53100~53199,
     * 54100~54199
     *
     * total number is (54+1) * 100, ie., (left/10+1) * b
     * 
     * n = 54115, counting at hundred position:
     * divide n into left = 541, right = 15, b = 100
     * digit is 1, matched numbers are XX100~XX199 where XX is 0~54, ie,:
     * 100~199,
     * 1100~1199, 2100~2199, 3100~3199 ... 9100~9199,
     * 10100~10199, 11100~11199 ... 53100~53199,
     * 54100~54115
     *
     * total number is 54 * 100 + 15 + 1, ie., left/10 * b + right + 1
     *
     * n = 54015, counting at hundred position:
     * divide n into left = 540, right = 15, b = 100
     * digit is 0 (< 1), matched numbers are XX100~XX199 where XX is 0~53, ie,:
     * 100~199,
     * 1100~1199, 2100~2199, 3100~3199 ... 9100~9199,
     * 10100~10199, 11100~11199 ... 53100~53199
     *
     * total number is 54 * 100, ie., left/10 * b
     *
     * In sum, total number of 1s at current digit n is:
     * if n > 1: (left/10+1) * b
     * if n = 1: left/10 * b + right + 1
     * if n < 1: left/10 * b
     */
    // O(lg n) time, O(1) space
    public int countDigitOne(int n) {
        if (n <= 0) return 0;

        int cnt = 0;
        int b = (int) Math.pow(10, String.valueOf(n).length() - 1);
        while (b >= 1) {
            int left = n / b, right = n % b;
            int d = left % 10;
            if (d > 1) {
                cnt += (left / 10 + 1) * b;
            } else if (d == 1) {
                cnt += left / 10 * b + right + 1;
            } else {
                cnt += left / 10 * b;
            }
            b /= 10; // divide instead of multiply to avoid overflow
        }
        return cnt;
    }
}
