package solutions;

import java.util.Stack;

/**
 * https://leetcode.com/problems/maximal-rectangle/
 *
 * Given a 2D binary matrix filled with 0's and 1's, find the largest
 * rectangle containing all ones and return its area.
 */
public class MaximalRectangle_085 {
    /* Optimal:
     * O(n^2) time, O(n^2) space if not allowed to modify original matrix,
     * otherwise O(n) space (for the stack)
     */
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
         // Convert each row to a histogram of heights
        int[][] m = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < m.length; ++i) {
            for (int j = 0; j < m[0].length; ++j) {
                if (matrix[i][j] == '0') {
                    m[i][j] = 0;
                } else {
                    if (i == 0) m[0][j] = 1;
                    else m[i][j] = m[i - 1][j] + 1;
                }
            }
        }
        int maxArea = 0;
        for (int i = 0; i < m.length; ++i) {
             // Use "Largest Rectangle in Histogram" solution to solve each row
            Stack<Integer> s = new Stack<Integer>();
            for (int j = 0; j <= m[0].length; ++j) {
                int currHeight = j == m[0].length ? 0 : m[i][j];
                while (!s.isEmpty() && m[i][s.peek()] >= currHeight) {
                    int prev = s.pop();
                    int width = s.isEmpty() ? j : j - 1 - s.peek();
                    maxArea = Math.max(maxArea, width * m[i][prev]);
                }
                s.push(j);
            }
        }
        return maxArea;
    }
}
