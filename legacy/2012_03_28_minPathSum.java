public class Solution {
    // Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

    // Note: You can only move either down or right at any point in time.
    
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        return minPathSum(grid, grid.length - 1, grid[0].length - 1, new int[grid.length][grid[0].length]);
    }
    
    // greedy, recursion with memoization
    private int minPathSum(int[][] grid, int i, int j, int[][] cache) {
        if (i < 0 || j < 0) return Integer.MAX_VALUE;
        if (i == 0 && j == 0) return grid[i][j];
        if (cache[i][j] != 0) return cache[i][j];
        int sum = 0;
        int upval = minPathSum(grid, i - 1, j, cache);
        int leftval = minPathSum(grid, i, j - 1, cache);
        sum += grid[i][j] + (upval < leftval ? upval : leftval);
        cache[i][j] = sum;
        return sum;
    }
}