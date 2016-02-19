package solutions;

import java.util.HashSet;

/**
 * https://leetcode.com/problems/happy-number/
 *
 * Write an algorithm to determine if a number is "happy".
 * A happy number is a number defined by the following process: Starting with
 * any positive integer, replace the number by the sum of the squares of its
 * digits, and repeat the process until the number equals 1 (where it will
 * stay), or it loops endlessly in a cycle which does not include 1. Those
 * numbers for which this process ends in 1 are happy numbers.
 * 
 * Example: 19 is a happy number
 * 1^2 + 9^2 = 82
 * 8^2 + 2^2 = 68
 * 8^2 + 2^2 = 68
 * 1^2 + 0^2 + 0^2 = 1
 */
public class HappyNumber_202 {
    public boolean isHappy(int n) {
        if (n <= 0) return false;
        HashSet<Integer> set = new HashSet<Integer>();
        while (n != 1) {
            if (!set.contains(n)) {
                set.add(n);
                n = nextHappy(n);
            } else {
                return false;
            }
        }
        return true;
    }

    private int nextHappy(int n) {
        int sum = 0;
        while (n > 0) {
            sum += (n % 10) * (n % 10);
            n /= 10;
        }
        return sum;
    }
}
