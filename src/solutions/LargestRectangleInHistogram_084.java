package solutions;

import java.util.Stack;

/**
 * https://leetcode.com/problems/largest-rectangle-in-histogram/
 *
 * Given n non-negative integers representing the histogram's bar height where
 * the width of each bar is 1, find the area of largest rectangle in the histogram.
 *
 * http://www.leetcode.com/wp-content/uploads/2012/04/histogram.png
 * Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].
 *
 * http://www.leetcode.com/wp-content/uploads/2012/04/histogram_area.png
 * The largest rectangle is shown in the shaded area, which has area = 10 unit.
 *
 * For example,
 * Given heights = [2,1,5,6,2,3],
 * return 10.
 */
public class LargestRectangleInHistogram_084 {
    /* Reference:
     * https://siddontang.gitbooks.io/leetcode-solution/content/array/largest_rectangle_in_histogram.html
     */
    public int largestRectangleArea(int[] heights) {
        if (heights == null) return 0;
        Stack<Integer> s = new Stack<Integer>();
        int maxArea = 0;
        for (int i = 0; i <= heights.length; ++i) {
            int currHeight = i == heights.length ? 0 : heights[i];
            while (!s.isEmpty() && heights[s.peek()] >= currHeight) {
                int prev = s.pop();
                int width = s.isEmpty() ? i : i - 1 - s.peek();
                maxArea = Math.max(maxArea, heights[prev] * width);
            }
            s.push(i);
        }
        return maxArea;
    }
}
