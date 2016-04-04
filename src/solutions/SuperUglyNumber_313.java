package solutions;

/**
 * https://leetcode.com/problems/super-ugly-number/
 *
 * Write a program to find the nth super ugly number.
 * Super ugly numbers are positive numbers whose all prime factors are in the
 * given prime list primes of size k.
 * For example, [1, 2, 4, 7, 8, 13, 14, 16, 19, 26, 28, 32] is the sequence of
 * the first 12 super ugly numbers given primes = [2, 7, 13, 19] of size 4.
 * Note:
 * 1. 1 is a super ugly number for any given primes.
 * 2. The given numbers in primes are in ascending order.
 * 3. 0 < k <= 100, 0 < n <= 106, 0 < primes[i] < 1000.
 */
public class SuperUglyNumber_313 {
    // O(nm) time, O(n + m) space, where m = primes.length
    public int nthSuperUglyNumber(int n, int[] primes) {
        if (n <= 0 || primes == null || primes.length == 0) return -1;
        int[] ugly = new int[n];
        int[] index = new int[primes.length];
        ugly[0] = 1;
        for (int i = 1; i < n; ++i) {
            int min = Integer.MAX_VALUE;
            for (int k = 0; k < primes.length; ++k) {
                int num = primes[k] * ugly[index[k]];
                if (num < min) min = num;
            }
            ugly[i] = min;
            for (int k = 0; k < primes.length; ++k) {
                if (min == primes[k] * ugly[index[k]]) ++index[k];
            }
        }
        return ugly[n - 1];
    }
}
