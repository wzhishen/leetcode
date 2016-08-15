package solutions;

/**
 * https://leetcode.com/problems/power-of-two/
 *
 * Given an integer, write a function to determine if it is a power of two.
 */
public class PowerOfTwo_231 {
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }

    // check low bit
    public boolean isPowerOfTwo2(int n) {
        return n > 0 && (n & -n) == n;
    }

    public boolean isPowerOfTwo3(int n) {
        return n > 0 && Math.pow(2, 30) % n == 0;
    }

    public boolean isPowerOfTwo4(int n) {
        return n > 0 && (1 << 31) % n == 0;
    }

    public boolean isPowerOfTwo5(int n) {
        return n > 0 && Integer.bitCount(n) == 1;
    }
}
