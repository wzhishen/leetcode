package solutions;

/**
 * https://leetcode.com/problems/search-insert-position/
 *
 * Given a sorted array and a target value, return the index if the target
 * is found. If not, return the index where it would be if it were inserted
 * in order.
 * You may assume no duplicates in the array.
 *
 * Here are few examples.
 * [1,3,5,6], 5 -> 2
 * [1,3,5,6], 2 -> 1
 * [1,3,5,6], 7 -> 4
 * [1,3,5,6], 0 -> 0
 */
public class SearchInsertPosition_035 {
    /*
     * After the loop, low will always point to the expected insertion index;
     * high will always point to the index with first value smaller than target.
     *
     *  [1,3,5,6]   5 -> 2
     *     H L
     *  [1,3,5,6]   2 -> 1
     *   H L
     *  [1,3,5,6]   7 -> 4
     *         H L
     *  [1,3,5,6]   0 -> 0
     * H L
     *
     * This holds even if array contains duplicates.
     */
    public int searchInsert(int[] nums, int target) {
        if (nums == null) return -1;
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }
}
