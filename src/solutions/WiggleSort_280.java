package solutions;

/**
 * https://leetcode.com/problems/wiggle-sort/
 *
 * Given an unsorted array nums, reorder it in-place such that
 * nums[0] <= nums[1] >= nums[2] <= nums[3]....
 *
 * For example, given nums = [3, 5, 2, 1, 6, 4], one possible
 * answer is [1, 6, 2, 5, 3, 4].
 */
public class WiggleSort_280 {
    /* O(n) time, O(1) space
     *
     * Original requirement is equivalent to:
     * if i is odd,  nums[i] >= nums[i - 1]
     * if i is even, nums[i] <= nums[i - 1]
     *
     * So just scan array and swap any unsatisfied pairs.
     *
     * Ref: https://segmentfault.com/a/1190000003783283
     */
    public void wiggleSort(int[] nums) {
        if (nums == null) return;

        for (int i = 1; i < nums.length; ++i) {
            if ((i & 1) == 1) {
                if (nums[i] < nums[i - 1]) swap(nums, i, i - 1);
            } else {
                if (nums[i] > nums[i - 1]) swap(nums, i, i - 1);
            }
        }
    }

    private void swap(int[] a, int i, int j) {
        int tmp = a[i]; a[i] = a[j]; a[j] = tmp;
    }
}
