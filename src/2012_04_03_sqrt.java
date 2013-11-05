public class Solution {
    // Implement int sqrt(int x).

    // Compute and return the square root of x.

    // O(log X) time
    // using binary search:
    // Note that we need *long* type to hold the value
    // (instead of int) in order to compute all valid sqrt 
    // for any 32-bit ints. Otherwise the max input will 
    // be limited to 92680.
    public int sqrt(int x) {
        if (x == 0) return 0;
        long low = 1;
        long high = x;
        while (high - low > 1) {
            long mid = low + (high - low) / 2;
            if (mid * mid <= x) low = mid;
            else high = mid;
        }
        return (int) low;
    }
    
    // O(1) time
    // using Newton's iterative method:
    // X[k+1] = (X[k] + N/X[k])/2 where X[0] = 1
    public int sqrtNewton(int x) {
        final int PRECISION = 20;
        if (x < 0) return -1;
        double ret = 1;
        for (int i = 0; i < PRECISION; ++i) {
            ret = (ret * ret + x) / (2 * ret);
        }
        return (int) ret;
    }
}