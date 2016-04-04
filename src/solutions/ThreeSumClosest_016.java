package solutions;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/3sum-closest/
 *
 * Given an array S of n integers, find three integers in S such that the sum
 * is closest to a given number, target. Return the sum of the three integers.
 * You may assume that each input would have exactly one solution.
 *
 * For example, given array S = {-1 2 1 -4}, and target = 1.
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 */
public class ThreeSumClosest_016 {
    // Two pointers: O(n^2) time, O(1) space
    public int threeSumClosest(int[] num, int target) {
        if (num == null || num.length < 3) return Integer.MAX_VALUE;
        Arrays.sort(num);
        int minDiff = Integer.MAX_VALUE;
        for(int i = 0; i < num.length - 2; i++) {
            int left = i + 1, right = num.length - 1;
            while(left < right) {
                int diff = num[i] + num[left] + num[right] - target;
                if(Math.abs(diff) < Math.abs(minDiff)) {
                    minDiff = diff;
                }
                if(diff == 0) {
                    return target;
                } else if(diff < 0) {
                    ++left;
                } else {
                    --right;
                }
            }
        }
        return target + minDiff;
    }
}
