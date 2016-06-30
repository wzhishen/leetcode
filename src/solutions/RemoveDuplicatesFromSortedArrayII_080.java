package solutions;

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/
 *
 * Follow up for "Remove Duplicates":
 * What if duplicates are allowed at most twice?
 *
 * For example,
 * Given sorted array nums = [1,1,1,2,2,3],
 * Your function should return length = 5, with the first five elements
 * of nums being 1, 1, 2, 2 and 3. It doesn't matter what you leave beyond
 * the new length.
 */
public class RemoveDuplicatesFromSortedArrayII_080 {
    // Ref: http://bangbingsyb.blogspot.com/2014/11/leetcode-remove-duplicates-from-sorted.html
    public int removeDuplicates(int[] nums) {
        if (nums == null) return -1;
        int p = 2;
        for (int i = p; i < nums.length; ++i) {
            if (nums[i] != nums[p - 2]) {
                nums[p++] = nums[i];
            }
        }
        return p;
    }
}
