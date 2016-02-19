package solutions;

/**
 * https://leetcode.com/problems/ugly-number/
 *
 * Write a program to check whether a given number is an ugly number.
 * Ugly numbers are positive numbers whose prime factors only include
 * 2, 3, 5. For example, 6, 8 are ugly while 14 is not ugly since it
 * includes another prime factor 7.
 * Note that 1 is typically treated as an ugly number.
 */
public class UglyNumber_263 {
    public boolean isUgly(int n) {
        if (n <= 0) return false;
        while (n > 1) {
            if (n % 2 == 0) n /= 2;
            else if (n % 3 == 0) n /= 3;
            else if (n % 5 == 0) n /= 5;
            else return false;
        }
        return true;
    }
}
