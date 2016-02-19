package solutions;

/**
 * https://leetcode.com/problems/next-permutation/
 *
 * Implement next permutation, which rearranges numbers into the lexicographically
 * next greater permutation of numbers. If such arrangement is not possible, it
 * must rearrange it as the lowest possible order (ie, sorted in ascending order).
 * The replacement must be in-place, do not allocate extra memory.
 *
 * Here are some examples. Inputs are in the left-hand column and its corresponding
 * outputs are in the right-hand column.
 * 1,2,3 -> 1,3,2
 * 3,2,1 -> 1,2,3
 * 1,1,5 -> 1,5,1
 */
public class NextPermutation_031 {
    /*
     * Procedure:
     * 1. Scan from right to left, find first i such that A[i] < A[i+1]
     *    (if i reaches -1 jump to step 4)
     * 2. Scan from right to left, find first j such that A[j] > A[i]
     * 3. Swap A[i] and A[j]
     * 4. Reverse A[i+1..end]
     */
    public void nextPermutation(int[] nums) {
        if (nums == null) return;
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            --i;
        }
        if (i < 0) {
            reverse(nums, 0, nums.length - 1);
            return;
        }
        int j = nums.length - 1;
        while (j >= i + 1 && nums[j] <= nums[i]) {
            --j;
        }
        swap(nums, i, j);
        reverse(nums, i + 1, nums.length - 1);
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    private void reverse(int[] nums, int i, int j) {
        while (i < j) {
            swap(nums, i, j);
            ++i; --j;
        }
    }
}
