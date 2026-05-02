package project2026.solutions;

/*
https://leetcode.com/problems/trapping-rain-water/

Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.



Example 1:
https://assets.leetcode.com/uploads/2018/10/22/rainwatertrap.png

Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.

Example 2:

Input: height = [4,2,0,3,2,5]
Output: 9


Constraints:

n == height.length
1 <= n <= 2 * 104
0 <= height[i] <= 105

 */
public class Q0042_TrappingRainWater {
    // Key: currentAmount = min(leftMaxHeight, rightMaxHeight) - currentHeight
    public int trap(int[] height) {
         int n = height.length;
         int[] leftMax = new int[n], rightMax = new int[n];
         leftMax[0] = height[0];
         rightMax[n - 1] = height[n - 1];
         for (int i = 1; i < n; ++i) {
             leftMax[i] = Math.max(height[i],leftMax[i - 1]);
         }
         for (int i = n - 2; i >= 0; --i) {
             rightMax[i] = Math.max(height[i],rightMax[i + 1]);
         }

         int res = 0;
         for (int i = 1; i < n - 1; ++i) {
             res += Math.min(leftMax[i], rightMax[i]) - height[i];
         }
         return res;
     }

    public int trap2(int[] height) {
        int n = height.length;
        int left = 0, right = n - 1;
        int leftMax = 0, rightMax = 0;
        int res = 0;
        while (left < right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);

            if (leftMax < rightMax) {
                res += leftMax - height[left];
                ++left;
            } else {
                res += rightMax - height[right];
                --right;
            }
        }
        return res;
    }

}
