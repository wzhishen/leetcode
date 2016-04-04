package solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/subsets-ii/
 *
 * Given a collection of integers that might contain duplicates, nums,
 * return all possible subsets.
 * Note:
 * 1. Elements in a subset must be in non-descending order.
 * 2. The solution set must not contain duplicate subsets.
 *
 * For example,
 * If nums = [1,2,2], a solution is:
 * [
 *   [2],
 *   [1],
 *   [1,2,2],
 *   [2,2],
 *   [1,2],
 *   []
 * ]
 */
public class SubsetsII_090 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if (nums == null) return null;
        Arrays.sort(nums);
        List<List<Integer>> solutions = new ArrayList<List<Integer>>();
        subsetsWithDup(solutions, new ArrayList<Integer>(), nums, 0);
        return solutions;
    }

    private void subsetsWithDup(List<List<Integer>> solutions, List<Integer> solution, int[] nums, int index) {
        solutions.add(new ArrayList<Integer>(solution));
        for (int i = index; i < nums.length; ++i) {
            solution.add(nums[i]);
            subsetsWithDup(solutions, solution, nums, i + 1);
            solution.remove(solution.size() - 1);
            while (i < nums.length - 1 && nums[i] == nums[i + 1]) ++i;
        }
    }
}
