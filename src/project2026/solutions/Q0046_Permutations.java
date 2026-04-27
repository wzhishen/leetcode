package project2026.solutions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/*
https://leetcode.com/problems/permutations/description/

Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.



Example 1:

Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]

Example 2:

Input: nums = [0,1]
Output: [[0,1],[1,0]]

Example 3:

Input: nums = [1]
Output: [[1]]


Constraints:

1 <= nums.length <= 6
-10 <= nums[i] <= 10
All the integers of nums are unique.

 */
public class Q0046_Permutations {
    public List<List<Integer>> permute(int[] nums) {
        backtrack(nums);
        return res;
    }

    HashSet<Integer> used = new HashSet<>();
    List<Integer> path = new LinkedList<>();
    List<List<Integer>> res = new ArrayList<>();
    private void backtrack(int[] nums) {
        if (path.size() == nums.length) {
            res.add(new LinkedList<>(path));
            return;
        }
        for (int num : nums) {
            if (used.contains(num)) continue;
            used.add(num);
            path.add(num);
            backtrack(nums);
            path.removeLast();
            used.remove(num);
        }
    }
}
