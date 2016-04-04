package solutions;

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 *
 * Given a sorted array, remove the duplicates in place such that each
 * element appear only once and return the new length.
 * Do not allocate extra space for another array, you must do this in
 * place with constant memory.
 *
 * For example,
 * Given input array nums = [1,1,2],
 * Your function should return length = 2, with the first two elements
 * of nums being 1 and 2 respectively. It doesn't matter what you leave
 * beyond the new length.
 */
public class RemoveDuplicatesFromSortedArray_026 {
    public int removeDuplicates(int[] nums) {
        if (nums == null) return -1;
        int p = 1;
        for (int i = p; i < nums.length; ++i) {
            if (nums[i] != nums[p - 1]) {
                nums[p++] = nums[i];
            }
        }
        return p;
    }
}
