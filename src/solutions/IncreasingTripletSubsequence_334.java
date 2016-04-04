package solutions;

/**
 * https://leetcode.com/problems/increasing-triplet-subsequence/
 *
 * Given an unsorted array return whether an increasing subsequence
 * of length 3 exists or not in the array.
 * Formally the function should:
 * Return true if there exists i, j, k
 * such that arr[i] < arr[j] < arr[k] given 0 ≤ i < j < k ≤ n-1
 * else return false.
 * Your algorithm should run in O(n) time complexity and O(1) space
 * complexity.
 *
 * Examples:
 * Given [1, 2, 3, 4, 5],
 * return true.
 * Given [5, 4, 3, 2, 1],
 * return false.
 */
public class IncreasingTripletSubsequence_334 {
    public boolean increasingTriplet(int[] nums) {
        int smallest = Integer.MAX_VALUE, smaller = Integer.MAX_VALUE;
        for (int n : nums) {
            if (n <= smallest) smallest = n;
            else if (n <= smaller) smaller = n;
            else return true;
        }
        return false;
    }
}
