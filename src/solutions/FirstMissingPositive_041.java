package solutions;

/**
 * https://leetcode.com/problems/first-missing-positive/
 *
 * Given an unsorted integer array, find the first missing positive integer.
 *
 * For example,
 * Given [1,2,0] return 3,
 * and [3,4,-1,1] return 2.
 * Your algorithm should run in O(n) time and uses constant space.
 */
public class FirstMissingPositive_041 {
    /*
     * Try to let array hold value i + 1 at index i.
     * O(n) time, O(1) space
     * Ref: http://www.cnblogs.com/AnnieKim/archive/2013/04/21/3034631.html
     */
    public int firstMissingPositive(int[] nums) {
        if (nums == null) return 1;

        int i = 0;
        while (i < nums.length) {
            if (nums[i] != i + 1 && nums[i] >= 1 && nums[i] <= nums.length && nums[i] != nums[nums[i] - 1]) {
                swap(nums, i, nums[i] - 1);
            } else {
                ++i;
            }
        }
        for (i = 0; i < nums.length; ++i) {
            if (nums[i] != i + 1) return i + 1;
        }
        return nums.length + 1;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
