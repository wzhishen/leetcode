package solutions;

/**
 * https://leetcode.com/problems/count-primes/
 *
 * Count the number of prime numbers less than a non-negative number, n.
 */
public class CountPrimes_204 {
    // Sieve of Eratosthenes
    public int countPrimes(int n) {
        boolean[] isPrime = new boolean[n];
        for (int i = 2; i < n; ++i) isPrime[i] = true;

        for (int i = 2; i * i < n; ++i) {
            if (!isPrime[i]) continue;
            for (int j = i * i; j < n; j += i) {
                isPrime[j] = false;
            }
        }

        int cnt = 0;
        for (int i = 2; i < n; ++i) {
            if (isPrime[i]) ++cnt;
        }
        return cnt;
    }
}
