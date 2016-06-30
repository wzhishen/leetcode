package solutions;

import java.util.ArrayList;

/**
 * https://leetcode.com/problems/permutation-sequence/
 *
 * The set [1,2,3,...,n] contains a total of n! unique permutations.
 * By listing and labeling all of the permutations in order,
 * We get the following sequence (ie, for n = 3):
 * 1. "123"
 * 2. "132"
 * 3. "213"
 * 4. "231"
 * 5. "312"
 * 6. "321"
 *
 * Given n and k, return the kth permutation sequence.
 * Note: Given n will be between 1 and 9 inclusive.
 */
public class PermutationSequence_060 {
    /*
     * Math problem: O(n) time.
     * Procedure:
     * for i in (n..1):
     *   curNumIndex = k/(i-1)!
     *   result.add(nums[curNumIndex])
     *   nums.remove(curNumIndex)
     *   k = k%(i-1)!
     *
     * Reference:
     * http://www.lifeincode.net/programming/leetcode-permutation-sequence-java/
     */
    public String getPermutation(int n, int k) {
        if (n < 1 || n > 9 || k <= 0) return null;
        ArrayList<Integer> nums = new ArrayList<Integer>();
        int fac = 1;
        for (int i = 1; i <= n; ++i) {
            nums.add(i);
            fac *= i;
        }

        fac /= n;
        k = k - 1; // start from 0

        String result = "";
        for (int i = n - 1; i >= 0; --i) {
            int index = k / fac;
            result += nums.get(index);
            nums.remove(index);
            k %= fac;
            if (i > 0) fac /= i;
        }
        return result;
    }
}
