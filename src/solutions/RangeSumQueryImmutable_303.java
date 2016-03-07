package solutions;

/**
 * https://leetcode.com/problems/range-sum-query-immutable/
 *
 * Given an integer array nums, find the sum of the elements between indices
 * i and j (i ¡Ü j), inclusive.
 *
 * Example:
 * Given nums = [-2, 0, 3, -5, 2, -1]
 * sumRange(0, 2) -> 1
 * sumRange(2, 5) -> -1
 * sumRange(0, 5) -> -3
 *
 * Note:
 * 1. You may assume that the array does not change.
 * 2. There are many calls to sumRange function.
 */
public class RangeSumQueryImmutable_303 {

    public class NumArray {
        private int[] a;

        public NumArray(int[] nums) {
            if (nums == null || nums.length == 0) return;
            a = nums;
            for (int i = 1; i < nums.length; ++i) {
                a[i] += a[i - 1];
            }
        }

        public int sumRange(int i, int j) {
            return i == 0 ? a[j] : a[j] - a[i - 1];
        }
    }


    // Your NumArray object will be instantiated and called as such:
    // NumArray numArray = new NumArray(nums);
    // numArray.sumRange(0, 1);
    // numArray.sumRange(1, 2);
}
