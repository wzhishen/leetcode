package solutions;

/**
 * https://leetcode.com/problems/search-for-a-range/
 *
 * Given a sorted array of integers, find the starting and ending position
 * of a given target value.
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * If the target is not found in the array, return [-1, -1].
 *
 * For example,
 * Given [5, 7, 7, 8, 8, 10] and target value 8,
 * return [3, 4].
 */
public class SearchForARange_034 {
    public int[] searchRange(int[] nums, int target) {
        int[] result = {-1, -1};
        if (nums == null) return result;

        // Search for left bound
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] < target) {
                low = mid + 1;
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                high = mid - 1; // if target found, keep searching left
            }
        }
        if (low >= 0 && low < nums.length && nums[low] == target) {
            result[0] = low;
        } else {
            return result;
        }

        // Search for right bound
        low = 0; high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] < target) {
                low = mid + 1;
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1; // if target found, keep searching right
            }
        }
        if (high >=0 && high < nums.length && nums[high] == target) {
            result[1] = high;
        }
        return result;
    }
}
