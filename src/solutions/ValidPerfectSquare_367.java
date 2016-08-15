package solutions;

/**
 * https://leetcode.com/problems/valid-perfect-square/
 *
 * Given a positive integer num, write a function which returns True if
 * num is a perfect square else False.
 *
 * Note: Do not use any built-in library function such as sqrt.
 *
 * Example 1:
 * Input: 16
 * Returns: True
 *
 * Example 2:
 * Input: 14
 * Returns: False
 */
public class ValidPerfectSquare_367 {
    /* Binary search
     * O(log n) time
     */
    public boolean isPerfectSquare(int num) {
        if (num < 0) return false;
        if (num == 0) return true;
        long low = 1, high = num;
        while (low <= high) {
            long mid = (low + high) >> 1;
            if (mid * mid == num) return true;
            else if (mid * mid < num) low = mid + 1;
            else high = mid - 1;
        }
        return false;
    }

    /* Ref: http://tinyurl.com/jqeff9h
     *
     * Any perfect square number equals 1 + 3 + 5 + 7 + ...
     *
     * Time analysis:
     * Let k be the # of iterations we need to do, then
     * 1 + 3 + 5 + 7 + ... + (2k - 1) = n
     * => (1 + 2k - 1) * k / 2 = n
     * => k * k = n
     * => k = sqrt n
     * ie., O(sqrt n) time
     */
    public boolean isPerfectSquare2(int num) {
        int i = 1;
        while (num > 0) {
            num -= i;
            i += 2;
        }
        return num == 0;
    }

    /* Newton's method
     * O(1) time
     */
    public boolean isPerfectSquare3(int num) {
        double res = 1.0;
        for (int i = 0; i < 20; ++i) res = (res + num / res) / 2;
        int r = (int) res;
        return r * r == num;
    }
}
