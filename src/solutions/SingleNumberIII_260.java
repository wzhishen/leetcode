package solutions;

/**
 * https://leetcode.com/problems/single-number-iii/
 *
 * Given an array of numbers nums, in which exactly two elements appear only
 * once and all the other elements appear exactly twice. Find the two elements
 * that appear only once.
 *
 * For example:
 * Given nums = [1, 2, 1, 3, 2, 5], return [3, 5].
 *
 * Note:
 * 1. The order of the result is not important. So in the above example, [5, 3]
 * is also correct.
 * 2. Your algorithm should run in linear runtime complexity. Could you implement
 * it using only constant space complexity?
 */
public class SingleNumberIII_260 {
    // Divide nums into two groups in order to apply solution of Single Number I
    public int[] singleNumber(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        int xor = 0;
        for (int n : nums) xor ^= n;

        int i = 0;
        for(; i <= 31; ++i) {
            if ((xor >> i & 1) == 1) break;
        }

        int a = 0, b = 0;
        for (int n : nums) {
            if ((n >> i & 1) == 1) a ^= n;
            else b ^= n;
        }
        return new int[] {a, b};
    }
}
