public class Solution {
    // Follow up for "Unique Paths":

    // Now consider if some obstacles are added to the grids. How many unique paths would there be?

    // An obstacle and empty space is marked as 1 and 0 respectively in the grid.

    // For example,
    // There is one obstacle in the middle of a 3x3 grid as illustrated below.

    // [
    //   [0,0,0],
    //   [0,1,0],
    //   [0,0,0]
    // ]
    // The total number of unique paths is 2.

    // Note: m and n will be at most 100.
    
    // DP, iterative
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0) return 0;
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] matrix = new int[m][n];
        // set zeros for bottom side
        for (int j = n - 1; j >= 0; --j) {
            matrix[m - 1][j] = 1;
            if (obstacleGrid[m - 1][j] == 1) {
                while (j >= 0) {
                    matrix[m - 1][j] = 0;
                    --j;
                }
                break;
            }
        }
        // set zeros for right side
        for (int i = m - 1; i >= 0; --i) {
            matrix[i][n - 1] = 1;
            if (obstacleGrid[i][n - 1] == 1) {
                while (i >= 0) {
                    matrix[i][n - 1] = 0;
                    --i;
                }
                break;
            }
        }
        for (int i = m - 1; i >= 0; --i) {
            for (int j = n - 1; j >= 0; --j) {
                if (obstacleGrid[i][j] == 1) {
                    matrix[i][j] = 0;
                }
                else if (i < m - 1 && j < n - 1) {
                    matrix[i][j] = matrix[i + 1][j] + matrix[i][j + 1];
                }
            }
        }
        return matrix[0][0];
    }
    
    // naive recursion with memoization
    public int uniquePathsWithObstaclesRecursive(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0) return 0;
        return uniquePathsWithObstaclesRecursive(obstacleGrid, obstacleGrid.length - 1, obstacleGrid[0].length - 1, 
            new int[obstacleGrid.length][obstacleGrid[0].length]);
    }
    
    private int uniquePathsWithObstaclesRecursive(int[][] grid, int m, int n, int[][] cache) {
        if (m < 0 || n < 0) return 0;
        if (grid[m][n] == 1) return 0;
        if (m == 0 && n == 0) return 1;
        if (cache[m][n] != 0) return cache[m][n];
        cache[m][n] = uniquePathsWithObstaclesRecursive(grid, m - 1, n, cache) + 
            uniquePathsWithObstaclesRecursive(grid, m, n - 1, cache);
        return cache[m][n];
    }
}