package solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/3sum/
 *
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0?
 * Find all unique triplets in the array which gives the sum of zero.
 *
 * Note:
 * 1. Elements in a triplet (a,b,c) must be in non-descending order. (ie, a <= b <= c)
 * 2. The solution set must NOT contain duplicate triplets.
 *
 * For example, given array S = {-1 0 1 2 -1 -4},
 * A solution set is: (-1, 0, 1), (-1, -1, 2)
 */
public class ThreeSum_015 {
    // Two pointers: O(n^2) time, O(1) space
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (nums == null || nums.length < 3) return result;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; ++i) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                if (nums[i] + nums[left] + nums[right] == 0) {
                    ArrayList<Integer> r = new ArrayList<Integer>();
                    r.add(nums[i]); r.add(nums[left]); r.add(nums[right]);
                    result.add(r);
                    ++left;
                    --right;
                    while (left < right && nums[left] == nums[left - 1]) ++left;
                    while (left < right && nums[right] == nums[right + 1]) --right;
                } else if (nums[i] + nums[left] + nums[right] < 0) {
                    ++left;
                } else {
                    --right;
                }
            }
        }
        return result;
    }
}
