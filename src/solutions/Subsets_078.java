package solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/subsets/
 *
 * Given a set of distinct integers, nums, return all possible subsets.
 * Note:
 * 1. Elements in a subset must be in non-descending order.
 * 2. The solution set must not contain duplicate subsets.
 *
 * For example,
 * If nums = [1,2,3], a solution is:
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 */
public class Subsets_078 {
    // backtracking
    public List<List<Integer>> subsets(int[] nums) {
        if (nums == null) return null;
        Arrays.sort(nums);
        List<List<Integer>> solutions = new ArrayList<List<Integer>>();
        subsets(solutions, new ArrayList<Integer>(), nums, 0);
        return solutions;
    }

    private void subsets(List<List<Integer>> solutions, List<Integer> solution, int[] nums, int index) {
        solutions.add(new ArrayList<Integer>(solution));
        for (int i = index; i < nums.length; ++i) {
            solution.add(nums[i]);
            subsets(solutions, solution, nums, i + 1);
            solution.remove(solution.size() - 1);
        }
    }

    // bit manipulation
    public List<List<Integer>> subsets2(int[] nums) {
        if (nums == null) return null;
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for (int i = 0; i < 1<<nums.length; ++i) {
            result.add(ConvertNumToSubset(nums, i));
        }
        return result;
    }

    private List<Integer> ConvertNumToSubset(int[] nums, int n) {
        List<Integer> subset = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; ++i) {
            if ((n & 1 << i) != 0) subset.add(nums[i]);
        }
        return subset;
    }
}
