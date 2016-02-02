package solutions;

/**
 * https://leetcode.com/problems/single-number/
 *
 * Given an array of integers, every element appears twice except for one.
 * Find that single one.
 *
 * Note:
 * Your algorithm should have a linear runtime complexity. Could you implement
 * it without using extra memory?
 */
public class SingleNumber_136 {
    public int singleNumber(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        int result = 0;
        for (int n : nums) result ^= n;
        return result;
    }
}
