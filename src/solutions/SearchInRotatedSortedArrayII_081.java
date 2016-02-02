package solutions;

/**
 * https://leetcode.com/problems/search-in-rotated-sorted-array-ii/
 *
 * Follow up for "Search in Rotated Sorted Array":
 * What if duplicates are allowed?
 * Would this affect the run-time complexity? How and why?
 * Write a function to determine if a given target is in the array.
 */
public class SearchInRotatedSortedArrayII_081 {
    public boolean search(int[] nums, int target) {
        if (nums == null) return false;
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                return true;
            // right half is sorted
            } else if (nums[low] > nums[mid]) {
                if (target > nums[mid] && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            // left half is sorted
            } else if (nums[low] < nums[mid]) {
                if (target >= nums[low] && target < nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                // left half must be all repeats
                if (nums[mid] != nums[high]) {
                    low = mid + 1;
                // default to brute force
                } else {
                    ++low;
                }
            }
        }
        return false;
    }
}
