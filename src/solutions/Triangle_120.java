package solutions;

import java.util.List;

/**
 * https://leetcode.com/problems/triangle/
 *
 * Given a triangle, find the minimum path sum from top to bottom. Each step
 * you may move to adjacent numbers on the row below.
 *
 * For example, given the following triangle
 * [
 *      [2],
 *     [3,4],
 *    [6,5,7],
 *   [4,1,8,3]
 * ]
 * The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 *
 * Note:
 * Bonus point if you are able to do this using only O(n) extra space, where
 * n is the total number of rows in the triangle.
 */
public class Triangle_120 {
    // O(n) space where n is the total number of rows.
    // Use a rolling array to always maintain one row.
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null) return -1;
        int m = triangle.size();
        Integer[] dp = new Integer[m];
        dp = triangle.get(m - 1).toArray(dp);
        for (int i = triangle.size() - 2; i >= 0 ; --i) {
            for (int j = 0; j <= i; ++j) {
                dp[j] = triangle.get(i).get(j) + Math.min(dp[j], dp[j + 1]);
            }
        }
        return dp[0];
    }

    // O(1) space if allowed to modify original triangle.
    public int minimumTotal2(List<List<Integer>> triangle) {
        if (triangle == null) return -1;
        for (int i = triangle.size() - 2; i >= 0 ; --i) {
            for (int j = 0; j <= i; ++j) {
                int v = triangle.get(i).get(j);
                int v1 = triangle.get(i + 1).get(j);
                int v2 = triangle.get(i + 1).get(j + 1);
                triangle.get(i).set(j, v + Math.min(v1, v2));
            }
        }
        return triangle.get(0).get(0);
    }
}
