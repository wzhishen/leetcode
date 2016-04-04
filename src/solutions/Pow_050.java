package solutions;

/**
 * https://leetcode.com/problems/powx-n/
 *
 * Implement pow(x, n).
 */
public class Pow_050 {
    // Need to consider edge cases like (x = -1, n = Integer.MIN_VALUE)
    public double myPow(double x, int n) {
        if (x == 0) return 0;
        if (n == 0) return 1;
        double val = myPow(x, n / 2);
        if (n % 2 == 0) {
            return val * val;
        } else {
            if (n > 0) return x * val * val;
            else return (1 / x) * val * val;
        }
    }
}
