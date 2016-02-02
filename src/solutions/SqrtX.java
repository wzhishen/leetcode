package solutions;

/**
 * https://leetcode.com/problems/sqrtx/
 *
 * Implement int sqrt(int x).
 * Compute and return the square root of x.
 */
public class SqrtX {
    /*
     * Binary search: O(log n) time
     * Note: need long type to hold value for any 32-bit ints. Otherwise
     * (mid * mid) may overflow and limit max input to 92680.
     */
    public int mySqrt(int x) {
        if (x < 0) return -1;
        long low = 1, high = x / 2 + 1;
        while (low <= high) {
            long mid = low + (high - low) / 2;
            if (mid * mid == x) return (int) mid;
            else if (mid * mid < x) low = mid + 1;
            else high = mid - 1;
        }
        return (int) high;
    }

    /*
     * Newton's iterative method: O(1) time
     * X[k+1] = (X[k] + N/X[k]) / 2 where X[0] = 1
     */
    public int mySqrt2(int x) {
        if (x < 0) return -1;
        final int PRECISION = 20;
        double res = 1;
        for (int i = 0; i < PRECISION; ++i) {
            res = (res + x / res) / 2;
        }
        return (int) res;
    }
}
