package solutions;

/**
 * https://leetcode.com/problems/power-of-three/
 *
 * Given an integer, write a function to determine if it is a power of
 * three.
 *
 * Follow up:
 * Could you do it without using any loop / recursion?
 */
public class PowerOfThree_326 {
    public boolean isPowerOfThree(int n) {
        if (n < 1) return false;
        while (n > 1) {
            if (n % 3 != 0) return false;
            n /= 3;
        }
        return true;
    }

    public boolean isPowerOfThree2(int n) {
        return n > 0 && Math.pow(3, 19) % n == 0;
    }
}
