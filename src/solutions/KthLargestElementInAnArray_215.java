package solutions;

/**
 * https://leetcode.com/problems/kth-largest-element-in-an-array/
 *
 * Find the kth largest element in an unsorted array. Note that it is the kth
 * largest element in the sorted order, not the kth distinct element.
 *
 * For example,
 * Given [3,2,1,5,6,4] and k = 2, return 5.
 *
 * Note:
 * You may assume k is always valid, 1 <= k <= array's length.
 */
public class KthLargestElementInAnArray_215 {
    /*
     * Quick select:
     * O(n) avg time, O(n^2) worst time, O(1) space
     *
     * Reference: https://en.wikipedia.org/wiki/Quickselect
     */
    public int findKthLargest(int[] nums, int k) {
        if (nums == null) return -1;
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int p = partition(nums, low, high);
            if (p == k - 1) return nums[p];
            else if (p < k - 1) low = p + 1;
            else high = p - 1;
        }
        return -1;
    }

    private int partition(int[] nums, int low, int high) {
        int pivot = nums[high];
        int storeIndex = low;
        for (int i = low; i < high; ++i) {
            if (nums[i] > pivot) {
                swap(nums, i, storeIndex);
                ++storeIndex;
            }
        }
        swap(nums, storeIndex, high);
        return storeIndex;
    }

    /* Recap
     * Quick sort:
     * O(n log n) avg time, O(n^2) worst time, O(log n) space
     */
    public void quicksort(int[] nums) {
        if (nums == null) return;
        quicksort(nums, 0, nums.length - 1);
    }

    private void quicksort(int[] nums, int low, int high) {
        if (low > high) return;
        int p = partition(nums, low, high);
        quicksort(nums, low, p - 1);
        quicksort(nums, p + 1, high);
    }

    private void swap(int[] nums, int i, int j) {
        if (i == j) return;
        nums[i] ^= nums[j];
        nums[j] ^= nums[i];
        nums[i] ^= nums[j];
    }
}
