package project2026.solutions;

/*
https://leetcode.com/problems/majority-element/description/

Given an array nums of size n, return the majority element.

The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.



Example 1:

Input: nums = [3,2,3]
Output: 3

Example 2:

Input: nums = [2,2,1,1,1,2,2]
Output: 2


Constraints:

n == nums.length
1 <= n <= 5 * 104
-109 <= nums[i] <= 109
The input is generated such that a majority element will exist in the array.


Follow-up: Could you solve the problem in linear time and in O(1) space?

 */
public class Q0169_MajorityElement {
public int majorityElement(int[] nums) {
        // Moore Voting: O(n) time, O(1) space
        int candidate = 0, cnt = 0;
        for (int num : nums) {
            if (cnt == 0) {
                candidate = num;
                cnt = 1;
            } else if (num == candidate) {
                ++cnt;
            } else {
                --cnt;
            }
        }
        return candidate;
    }
}
