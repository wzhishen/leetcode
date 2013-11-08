public class Solution {
    // Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

    // The same repeated number may be chosen from C unlimited number of times.

    // Note:
    // All numbers (including target) will be positive integers.
    // Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
    // The solution set must not contain duplicate combinations.
    // For example, given candidate set 2,3,6,7 and target 7, 
    // A solution set is: 
    // [7] 
    // [2, 2, 3] 
    
    public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) return null;
        HashSet<ArrayList<Integer>> ret = new HashSet<ArrayList<Integer>>();
        combinationSum(candidates, target, new ArrayList<Integer>(), ret);
        return new ArrayList<ArrayList<Integer>>(ret);
    }
    
    private void combinationSum(int[] a, int target, ArrayList<Integer> subset, HashSet<ArrayList<Integer>> res) {
        if (target <= 0) return;
        for (int n : a) {
            subset.add(n);
            if (n == target) {
                ArrayList<Integer> r = (ArrayList<Integer>) subset.clone();
                Collections.sort(r);
                res.add(r);
            }
            combinationSum(a, target - n, subset, res);
            subset.remove(subset.size() - 1);
        }
    }
}