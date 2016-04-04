package solutions;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/ugly-number-ii/
 *
 * Write a program to find the n-th ugly number.
 * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.
 * For example, 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10
 * ugly numbers.
 * Note that 1 is typically treated as an ugly number.
 *
 * Hint:
 * 1. The naive approach is to call isUgly for every number until you reach the
 * nth one. Most numbers are not ugly. Try to focus your effort on generating
 * only the ugly ones.
 * 2. An ugly number must be multiplied by either 2, 3, or 5 from a smaller ugly
 * number.
 * 3. The key is how to maintain the order of the ugly numbers. Try a similar
 * approach of merging from three sorted lists: L1, L2, and L3.
 * 4. Assume you have Uk, the kth ugly number. Then Uk+1 must be Min(L1 * 2,
 * L2 * 3, L3 * 5).
 */
public class UglyNumberII_264 {
    // Reference: http://blog.listnukira.com/LeetCode-Ugly-Number-II/
    // O(n) time, O(n) space
    public int nthUglyNumber(int n) {
        int[] ugly = new int[n];
        int i2 = 0, i3 = 0, i5 = 0;
        ugly[0] = 1;
        for (int i = 1; i < n; ++i) {
            int min = Math.min(ugly[i2] * 2, Math.min(ugly[i3] * 3, ugly[i5] * 5));
            ugly[i] = min;
            if (min == ugly[i2] * 2) ++i2;
            if (min == ugly[i3] * 3) ++i3;
            if (min == ugly[i5] * 5) ++i5;
        }
        return ugly[n - 1];
    }

    // O(n) time, O(3n) space
    public int nthUglyNumber2(int n) {
        Queue<Long> q2 = new LinkedList<Long>();
        Queue<Long> q3 = new LinkedList<Long>();
        Queue<Long> q5 = new LinkedList<Long>();
        q2.offer(1l);
        long num = -1;
        for (int i = 0; i < n; ++i) {
            long n2 = q2.peek();
            long n3 = q3.isEmpty() ? Integer.MAX_VALUE : q3.peek();
            long n5 = q5.isEmpty() ? Integer.MAX_VALUE : q5.peek();
            num = Math.min(n2, Math.min(n3, n5));
            if (num == n2) {
                q2.poll();
                q2.offer(2 * num);
                q3.offer(3 * num);
                q5.offer(5 * num);
            } else if (num == n3) {
                q3.poll();
                q3.offer(3 * num);
                q5.offer(5 * num);
            } else {
                q5.poll();
                q5.offer(5 * num);
            }
        }
        return (int) num;
    }
}
