package solutions;

/**
 * https://leetcode.com/problems/rotate-array/
 *
 * Rotate an array of n elements to the right by k steps.
 * For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to
 * [5,6,7,1,2,3,4].
 *
 * Note:
 * Try to come up as many solutions as you can, there are at least 3 different
 * ways to solve this problem.
 *
 * Hint:
 * Could you do it in-place with O(1) extra space?
 * Related problem: Reverse Words in a String II
 */
public class RotateArray_189 {
    /*
     * 3-pass reverse: O(n) time, O(1) space
     *
     * eg., k = 3, nums = [1 2 3 4 5 6 7 8 9]
     * 1. reverse all:       [9 8 7   6 5 4 3 2 1]
     * 2. reverse first k:   [7 8 9 | 6 5 4 3 2 1]
     * 3. reverse remaining: [7 8 9 | 1 2 3 4 5 6]
     */
    public void rotate(int[] nums, int k) {
        if (nums == null) return;
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    private void reverse(int[] nums, int i, int j) {
        while (i < j) {
            int tmp = nums[j];
            nums[j] = nums[i];
            nums[i] = tmp;
            ++i; --j;
        }
    }
}
