package solutions;

/**
 * https://leetcode.com/problems/sort-colors/
 *
 * Given an array with n objects colored red, white or blue, sort them so that
 * objects of the same color are adjacent, with the colors in the order red,
 * white and blue.
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white,
 * and blue respectively.
 *
 * Note:
 * You are not suppose to use the library's sort function for this problem.
 *
 * Follow up:
 * A rather straight forward solution is a two-pass algorithm using counting sort.
 * First, iterate the array counting number of 0's, 1's, and 2's, then overwrite
 * array with total number of 0's, then 1's and followed by 2's.
 * Could you come up with an one-pass algorithm using only constant space?
 */
public class SortColors_075 {
    /*
     * Algorithm
     * Reference: http://bangbingsyb.blogspot.com/2014/11/leetcode-sort-colors.html
     *
     * Suppose current state is:
     * a: [0 ... 0 1 ... 1 x1 x2 ... xn 2 ... 2]
     *             |       |         |
     *            left    curr      right
     * Repeat:
     * 1) if a[curr] == 1: already in place, move curr forward.
     * 2) if a[curr] == 0: swap a[curr] with a[left], move left and curr forward.
     * 3) if a[curr] == 2: swap a[curr] with a[right], move right backward,
     *    don't move curr forward as we don't know what element is a[right]
     * Break if curr > right.
     *
     * One-pass O(n) time, O(1) space
     */
    public void sortColors(int[] nums) {
        if (nums == null) return;
        int left = 0, curr = 0, right = nums.length - 1;
        while (curr <= right) {
            if (nums[curr] == 1) {
                ++curr;
            } else if (nums[curr] == 0) {
                swap(nums, curr, left);
                ++curr;
                ++left;
            } else if (nums[curr] == 2) {
                swap(nums, curr, right);
                --right;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
