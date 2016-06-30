package solutions;

/**
 * https://leetcode.com/problems/trapping-rain-water/
 *
 * Given n non-negative integers representing an elevation map where the width
 * of each bar is 1, compute how much water it is able to trap after raining.
 *
 * For example,
 * Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
 */
public class TrappingRainWater_042 {
    /* Two pointers: O(n) time, O(1) space
     * Ref: https://leetcode.com/discuss/16171/sharing-my-simple-c-code-o-n-time-o-1-space
     */
    public int trap(int[] height) {
        if (height == null) return -1;
        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0, rain = 0;
        while (left <= right) {
            if (height[left] <= height[right]) {
                if (height[left] > leftMax) leftMax = height[left];
                else rain += leftMax - height[left];
                ++left;
            } else {
                if (height[right] > rightMax) rightMax = height[right];
                else rain += rightMax - height[right];
                --right;
            }
        }
        return rain;
    }

    /* O(n) time, O(n) space
     * Key:
     * currentRainAmount = min(leftMaxHeight, rightMaxHeight) - currentHeight
     */
    public int trap2(int[] height) {
        if (height == null) return -1;
        int[] left = new int[height.length];
        int leftMax = 0;
        for (int i = 0; i < height.length; ++i) {
            leftMax = Math.max(leftMax, height[i]);
            left[i] = leftMax;
        }
  
        int rightMax = 0;
        int rain = 0;
        for (int i = height.length - 1; i >= 0; --i) {
            rightMax = Math.max(rightMax, height[i]);
            int diff = Math.min(rightMax, left[i]);
            if (diff - height[i] > 0) rain += diff - height[i];
        }
        return rain;
    }
}
