package solutions;

/**
 * https://leetcode.com/problems/move-zeroes/
 *
 * Given an array nums, write a function to move all 0's to the end of it
 * while maintaining the relative order of the non-zero elements.
 *
 * For example, given nums = [0, 1, 0, 3, 12], after calling your function,
 * nums should be [1, 3, 12, 0, 0].
 *
 * Note:
 * 1. You must do this in-place without making a copy of the array.
 * 2. Minimize the total number of operations.
 */
public class MoveZeroes_283 {
    public void moveZeroes(int[] nums) {
        int p = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] != 0) {
                if (i != p) {
                    nums[p] = nums[i];
                    nums[i] = 0;
                }
                ++p;
            }
        }
    }
}
