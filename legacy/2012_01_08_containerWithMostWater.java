public class Solution {
    // Given n non-negative integers a1, a2, ..., an, where each 
    // represents a point at coordinate (i, ai). n vertical lines 
    // are drawn such that the two endpoints of line i is at (i, ai)
    // and (i, 0). Find two lines, which together with x-axis 
    // forms a container, such that the container contains the most 
    // water.
    // Note: You may not slant the container.

    // two-pointer, O(n) time
    public int maxArea(int[] height) {
        if (height == null || height.length == 0) return 0;
        int head = 0;
        int tail = height.length - 1;
        int maxArea = 0;
        while (head < tail) {
            int area = (tail - head) * Math.min(height[head], height[tail]);
            if (area > maxArea) maxArea = area;
            // Trick is that if we already compute the area of container
            // with a short bar, there's no need to compute any inward
            // containers with this short bar because their areas must be 
            // smaller than the outermost one, so just move the short bar 
            // pointer to the next bar.
            if (height[head] < height[tail]) {
                ++head;
            }
            else {
                --tail;
            }
        }
        return maxArea;
    }
    
    // brute force, O(n^2) time
    public int maxAreaBF(int[] height) {
        if (height == null || height.length == 0) return 0;
        int maxArea = 0;
        for (int i = 0; i < height.length - 1; ++i) {
            for (int j = i + 1; j < height.length; ++j) {
                int area = (j - i) * Math.min(height[i], height[j]);
                if (area > maxArea) maxArea = area;
            }
        }
        return maxArea;
    }
}