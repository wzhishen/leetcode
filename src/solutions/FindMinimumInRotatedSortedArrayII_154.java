package solutions;

/**
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
 *
 * Follow up for "Find Minimum in Rotated Sorted Array":
 * What if duplicates are allowed?
 * Would this affect the run-time complexity? How and why?
 *
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * Find the minimum element.
 * The array may contain duplicates.
 */
public class FindMinimumInRotatedSortedArrayII_154 {
    // worst case becomes O(n) time
    public int findMin(int[] nums) {
        if (nums == null) return -1;
        int low = 0, high = nums.length - 1;
        int res = Integer.MAX_VALUE;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            // right half is sorted
            if (nums[low] > nums[mid]) {
                res = Math.min(res, nums[mid]);
                high = mid - 1;
            // left half is sorted
            } else if (nums[low] < nums[mid]) {
                res = Math.min(res, nums[low]);
                low = mid + 1;
            // default to brute force
            } else {
                res = Math.min(res, nums[low]);
                ++low;
            }
        }
        return res;
    }
}
