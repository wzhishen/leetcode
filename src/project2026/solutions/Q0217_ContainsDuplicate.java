package project2026.solutions;

import java.util.Arrays;
import java.util.stream.Collectors;

/*
https://leetcode.com/problems/contains-duplicate

Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.



Example 1:

Input: nums = [1,2,3,1]

Output: true

Explanation:

The element 1 occurs at the indices 0 and 3.

Example 2:

Input: nums = [1,2,3,4]

Output: false

Explanation:

All elements are distinct.

Example 3:

Input: nums = [1,1,1,3,3,4,3,2,4,2]

Output: true



Constraints:

1 <= nums.length <= 105
-109 <= nums[i] <= 109

 */
public class Q0217_ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        return  Arrays.stream(nums).boxed().collect(Collectors.toSet()).size() < nums.length;
    }
}
