public class Solution {
    // Given n non-negative integers representing the histogram's 
    // bar height where the width of each bar is 1, find the area 
    // of largest rectangle in the histogram.

    // Above is a histogram where width of each bar is 1, given 
    // height = [2,1,5,6,2,3].

    // The largest rectangle is shown in the shaded area, which has 
    // area = 10 unit.

    // For example,
    // Given height = [2,1,5,6,2,3],
    // return 10.

    // use a stack, O(n) time
    public int largestRectangleArea(int[] height) {
        if (height == null || height.length == 0) return 0;
        height = Arrays.copyOfRange(height, 0, height.length + 1);
        Stack<Integer> stack = new Stack<Integer>();
        int maxArea = 0;
        for (int i = 0; i < height.length; ++i) {
            while (!stack.isEmpty() && height[stack.peek()] > height[i]) {
                int currHeight = height[stack.pop()];
                int left = stack.isEmpty() ? -1 : stack.peek();
                int area = currHeight * (i - left - 1);
                if (area > maxArea) maxArea = area;
            }
            stack.push(i);
        }
        return maxArea;
    }
}