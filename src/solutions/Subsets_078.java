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
    public List<List<Integer>> subsets(int[] nums) {
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
        int i = 0;
        while (n != 0) {
            if ((n & 1) == 1) {
                subset.add(nums[i]);
            }
            ++i;
            n >>>= 1;
        }
        return subset;
    }
}
