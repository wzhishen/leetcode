package solutions;

/**
 * https://leetcode.com/problems/maximum-gap/
 *
 * Given an unsorted array, find the maximum difference between the
 * successive elements in its sorted form.
 * Try to solve it in linear time/space.
 * Return 0 if the array contains less than 2 elements.
 * You may assume all elements in the array are non-negative integers
 * and fit in the 32-bit signed integer range.
 */
public class MaximumGap_164 {
    /* bucket sort: O(n) time, O(n) space
     * Ref: http://blog.csdn.net/u012162613/article/details/41936569
     */
    public int maximumGap(int[] nums) {
        if (nums == null || nums.length < 2) return 0;

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int n : nums) {
            min = Math.min(min, n);
            max = Math.max(max, n);
        }
        // the length of each bucket
        int bucketLen = (max - min) / nums.length + 1;
        // the total number of buckets
        int bucketNum = (max - min) / bucketLen + 1;
        int[][] buckets = new int[bucketNum][];
        for (int n : nums) {
            // find the bucket this number belongs to
            int i = (n - min) / bucketLen;
            // only need to store min/max in each bucket
            if (buckets[i] == null) {
                buckets[i] = new int[] {n, n};
            } else {
                buckets[i][0] = Math.min(buckets[i][0], n);
                buckets[i][1] = Math.max(buckets[i][1], n);
            }
        }
        int maxGap = 0;
        int prev = 0;
        for (int i = 1; i < buckets.length; ++i) {
            if (buckets[i] != null) {
                // the max gap only happens across adjacent buckets
                maxGap = Math.max(maxGap, buckets[i][0] - buckets[prev][1]);
                prev = i;
            }
        }
        return maxGap;
    }
}
