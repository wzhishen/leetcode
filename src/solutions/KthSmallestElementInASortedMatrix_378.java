package solutions;

import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/
 *
 * Given a n x n matrix where each of the rows and columns are sorted
 * in ascending order, find the kth smallest element in the matrix.
 * Note that it is the kth smallest element in the sorted order, not
 * the kth distinct element.
 *
 * Example:
 * matrix = [
 *    [ 1,  5,  9],
 *    [10, 11, 13],
 *    [12, 13, 15]
 * ],
 * k = 8,
 *
 * return 13.
 *
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ n^2.
 */
public class KthSmallestElementInASortedMatrix_378 {
    public int kthSmallest(int[][] matrix, int k) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return -1;

        int m = matrix.length, n = matrix[0].length;
        PriorityQueue<Integer> q = new PriorityQueue<>((p1, p2) -> matrix[p1 / n][p1 % n] - matrix[p2 / n][p2 % n]);
        for (int j = 0; j < n && j < k; ++j) q.offer(j);

        int node = 0;
        while (k-- > 0) {
            node = q.poll();
            int x = node / n, y = node % n;
            if (x < m - 1) q.offer((x + 1) * n + y);
        }
        return matrix[node / n][node % n];
    }
}
