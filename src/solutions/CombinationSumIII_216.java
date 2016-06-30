package solutions;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/combination-sum-iii/
 *
 * Find all possible combinations of k numbers that add up to a number n,
 * given that only numbers from 1 to 9 can be used and each combination
 * should be a unique set of numbers.
 * Ensure that numbers within the set are sorted in ascending order.
 *
 * Example 1:
 * Input: k = 3, n = 7
 * Output: [[1,2,4]]
 *
 * Example 2:
 * Input: k = 3, n = 9
 * Output: [[1,2,6], [1,3,5], [2,3,4]]
 */
public class CombinationSumIII_216 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> solutions = new ArrayList<List<Integer>>();
        if (k <= 0 || n <= 0 || k > 9) return solutions;
        combinationSum3(k, n, 1, new ArrayList<Integer>(), solutions);
        return solutions;
    }

    private void combinationSum3(int k, int n, int start, List<Integer> solution, List<List<Integer>> solutions) {
        if (k == 0 && n == 0) {
            solutions.add(new ArrayList<Integer>(solution));
        } else {
            for (int i = start; i <= 9; ++i) {
                solution.add(i);
                combinationSum3(k - 1, n - i, i + 1, solution, solutions);
                solution.remove(solution.size() - 1);
            }
        }
    }
}
