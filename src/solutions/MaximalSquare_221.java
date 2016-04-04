package solutions;

public class MaximalSquare_221 {
    // O(n^2) time, O(n^2) space
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;

        int maxArea = 0;
        int[][] m = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[0].length; ++j) {
                if (i == 0 || j == 0) {
                    m[i][j] = matrix[i][j] - '0';
                } else {
                    m[i][j] = matrix[i][j] == '0' ? 0 : Math.min(m[i - 1][j - 1], Math.min(m[i - 1][j], m[i][j - 1])) + 1;
                }
                maxArea = Math.max(maxArea, m[i][j] * m[i][j]);
            }
        }
        return maxArea;
    }

    // O(n^2) time, O(n) space with a rolling array
    public int maximalSquare2(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;

        int maxArea = 0;
        int[][] m = new int[2][matrix[0].length];
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[0].length; ++j) {
                if (i == 0 || j == 0) {
                    m[i % 2][j] = matrix[i][j] - '0';
                } else {
                    m[i % 2][j] = matrix[i][j] == '0' ? 0 : Math.min(m[(i - 1) % 2][j - 1], Math.min(m[(i - 1) % 2][j], m[i % 2][j - 1])) + 1;
                }
                maxArea = Math.max(maxArea, m[i % 2][j] * m[i % 2][j]);
            }
        }
        return maxArea;
    }

    // Reference: https://segmentfault.com/a/1190000003709497
}
