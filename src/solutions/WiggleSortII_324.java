package solutions;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/wiggle-sort-ii/
 *
 * Given an unsorted array nums, reorder it such that
 * nums[0] < nums[1] > nums[2] < nums[3]....
 *
 * Example:
 * (1) Given nums = [1, 5, 1, 1, 6, 4], one possible
 * answer is [1, 4, 1, 5, 1, 6].
 * (2) Given nums = [1, 3, 2, 2, 3, 1], one possible
 * answer is [2, 3, 1, 3, 1, 2].
 *
 * Note:
 * You may assume all input has valid answer.
 *
 * Follow Up:
 * Can you do it in O(n) time and/or in-place with O(1)
 * extra space?
 */
public class WiggleSortII_324 {
    public void wiggleSort(int[] nums) {
        if (nums == null) return;

        int n = nums.length;
        int[] tmp = new int[n];
        for (int i = 0; i < n; ++i) tmp[i] = nums[i];
        Arrays.sort(tmp);
        int low = (n - 1) / 2, high = n - 1;
        for (int i = 0; i < n; ++i) nums[i] = tmp[(i & 1) == 0 ? low-- : high--];
    }
}
