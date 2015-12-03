public class Solution {
    // A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

    // The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

    // How many possible unique paths are there?

    // Above is a 3 x 7 grid. How many possible unique paths are there?

    // Note: m and n will be at most 100.

    // DP, iterative
    public int uniquePaths(int m, int n) {
        if (m <= 0 || n <= 0) return 0;
        int[][] matrix = new int[m][n];
        for (int i = m - 1; i >= 0; --i) {
            for (int j = n - 1; j >= 0; --j) {
                if (i == m - 1 || j == n - 1) {
                    matrix[i][j] = 1;
                }
                else {
                    matrix[i][j] = matrix[i + 1][j] + matrix[i][j + 1];
                }
            }
        }
        return matrix[0][0];
    }
    
    // naive recursion with memoization
    public int uniquePathsRecursive(int m, int n) {
        return uniquePathsRecursive(m, n, new HashMap<String, Integer>());
    }
    
    private int uniquePathsRecursive(int m, int n, HashMap<String, Integer> cache) {
        String key = "" + m + n;
        if (cache.containsKey(key)) return cache.get(key);
        if (m < 0 || n < 0) return 0;
        if (m == 0 && n == 0) return 1;
        int res = uniquePathsRecursive(m - 1, n) + uniquePathsRecursive(m, n - 1);
        cache.put(key, res);
        return res;
    }
}