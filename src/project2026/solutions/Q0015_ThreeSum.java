package project2026.solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
https://leetcode.com/problems/3sum/description/

Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

Notice that the solution set must not contain duplicate triplets.



Example 1:

Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
Explanation:
nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
The distinct triplets are [-1,0,1] and [-1,-1,2].
Notice that the order of the output and the order of the triplets does not matter.
Example 2:

Input: nums = [0,1,1]
Output: []
Explanation: The only possible triplet does not sum up to 0.
Example 3:

Input: nums = [0,0,0]
Output: [[0,0,0]]
Explanation: The only possible triplet sums up to 0.


Constraints:

3 <= nums.length <= 3000
-105 <= nums[i] <= 105

 */
public class Q0015_ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length; ++i) {
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                if (nums[i] + nums[left] + nums[right] == 0) {
                    res.add(List.of(nums[i], nums[left], nums[right]));
                    ++left;
                    --right;
                    while (left < right && nums[left] == nums[left - 1]) ++left;
                    while (left < right && nums[right] == nums[right + 1]) --right;
                } else if (nums[i] + nums[left] + nums[right] > 0) {
                    --right;
                } else {
                    ++left;
                }
            }
            while (i < nums.length - 1 && nums[i] == nums[i + 1]) ++i;
        }
        return res;
    }

    // public List<List<Integer>> threeSum(int[] nums) {
    //     int n = nums.length;
    //     Arrays.sort(nums);
    //     List<List<Integer>> res = new ArrayList<>();
    //     for (int i = 0; i < n; ++i) {
    //         int l = i + 1, r = n - 1;
    //         while (l < r) {
    //             if (nums[i] + nums[l] + nums[r] < 0) {
    //                 ++l;
    //             } else if (nums[i] + nums[l] + nums[r] > 0) {
    //                 --r;
    //             } else {
    //                 res.add(List.of(nums[i], nums[l], nums[r]));
    //                 ++l;
    //                 --r;
    //                 while (l < n && nums[l] == nums[l - 1]) ++l;
    //                 while (r >= 0 && nums[r] == nums[r + 1]) --r;
    //             }
    //         }
    //         while (i < n - 1 && nums[i] == nums[i + 1]) ++i;
    //     }
    //     return res;
    // }
}
