package solutions;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/combination-sum/
 *
 * Given a set of candidate numbers (C) and a target number (T), find all
 * unique combinations in C where the candidate numbers sums to T.
 * The same repeated number may be chosen from C unlimited number of times.
 *
 * Note:
 * 1. All numbers (including target) will be positive integers.
 * 2. Elements in a combination (a1, a2, ... , ak) must be in non-descending
 *    order. (ie, a1 <= a2 <= ... <= ak).
 * 3. The solution set must not contain duplicate combinations.
 *
 * For example, given candidate set 2,3,6,7 and target 7,
 * A solution set is:
 * [7]
 * [2, 2, 3]
 */
public class CombinationSum_039 {
    // assumes candidates contain no duplicates
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> solutions = new ArrayList<List<Integer>>();
        if (candidates == null || candidates.length == 0) return solutions;
        combinationSum(candidates, target, 0, new ArrayList<Integer>(), solutions);
        return solutions;
    }

    private void combinationSum(int[] candidates, int target, int index, List<Integer> solution, List<List<Integer>> solutions) {
        if (target < 0) {
            return;
        } else if (target == 0) {
            solutions.add(new ArrayList<Integer>(solution));
        } else {
            for (int i = index; i < candidates.length; ++i) {
                solution.add(candidates[i]);
                combinationSum(candidates, target - candidates[i], i, solution, solutions);
                solution.remove(solution.size() - 1);
            }
        }
    }
}
