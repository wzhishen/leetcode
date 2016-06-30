package solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/combination-sum-ii/
 *
 * Given a collection of candidate numbers (C) and a target number (T), find
 * all unique combinations in C where the candidate numbers sums to T.
 * Each number in C may only be used once in the combination.
 *
 * Note:
 * 1. All numbers (including target) will be positive integers.
 * 2. Elements in a combination (a1, a2, ... , ak) must be in non-descending
 *    order. (ie, a1 <= a2 <= ... <= ak).
 * 3. The solution set must not contain duplicate combinations.
 *
 * For example, given candidate set 10,1,2,7,6,1,5 and target 8,
 * A solution set is:
 * [1, 7]
 * [1, 2, 5]
 * [2, 6]
 * [1, 1, 6]
 */
public class CombinationSumII_040 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> solutions = new ArrayList<List<Integer>>();
        if (candidates == null || candidates.length == 0) return solutions;
        Arrays.sort(candidates);
        combinationSum2(candidates, target, 0, new ArrayList<Integer>(), solutions);
        return solutions;
    }

    private void combinationSum2(int[] candidates, int target, int index, List<Integer> solution, List<List<Integer>> solutions) {
        if (target < 0) {
            return;
        } else if (target == 0) {
            solutions.add(new ArrayList<Integer>(solution));
        } else {
            for (int i = index; i < candidates.length; ++i) {
                solution.add(candidates[i]);
                combinationSum2(candidates, target - candidates[i], i + 1, solution, solutions);
                solution.remove(solution.size() - 1);
                while (i < candidates.length - 1 && candidates[i] == candidates[i + 1]) ++i; // skip dups
            }
        }
    }
}
