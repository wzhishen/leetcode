package solutions;

/**
 * https://leetcode.com/problems/create-maximum-number/
 *
 * Given two arrays of length m and n with digits 0-9 representing two
 * numbers. Create the maximum number of length k <= m + n from digits
 * of the two. The relative order of the digits from the same array must
 * be preserved. Return an array of the k digits. You should try to
 * optimize your time and space complexity.
 *
 * Example 1:
 * nums1 = [3, 4, 6, 5]
 * nums2 = [9, 1, 2, 5, 8, 3]
 * k = 5
 * return [9, 8, 6, 5, 3]
 *
 * Example 2:
 * nums1 = [6, 7]
 * nums2 = [6, 0, 4]
 * k = 5
 * return [6, 7, 6, 0, 4]
 *
 * Example 3:
 * nums1 = [3, 9]
 * nums2 = [8, 9]
 * k = 3
 * return [9, 8, 9]
 */
public class CreateMaximumNumber_321 {
    /* O(k^3) time, O(k) space
     * Ref: http://www.cnblogs.com/Liok3187/p/5079343.html
     */
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        if (nums1 == null || nums2 == null || k <= 0) return null;

        int[] max = new int[k];
        for (int i = 0; i <= k; ++i) {
            if (i > nums1.length || k - i > nums2.length) continue;
            int[] res = merge(selectMaxNumber(nums1, i), selectMaxNumber(nums2, k - i));
            if (greater(res, 0, max, 0)) max = res;
        }
        return max;
    }

    private int[] selectMaxNumber(int[] nums, int n) {
        int[] stack = new int[n];
        int top = -1;
        for (int i = 0; i < nums.length; ++i) {
            while (top >= 0 && nums[i] > stack[top] && nums.length - i >= n - top) --top;
            if (top + 1 < n) stack[++top] = nums[i];
        }
        return stack;
    }

    private int[] merge(int[] a, int[] b) {
        int[] res = new int[a.length + b.length];
        int i = 0, j = 0, k = 0;
        while (i < a.length && j < b.length) {
            if (greater(a, i, b, j)) {
                res[k++] = a[i++];
            } else {
                res[k++] = b[j++];
            }
        }
        while (i < a.length) res[k++] = a[i++];
        while (j < b.length) res[k++] = b[j++];
        return res;
    }

    private boolean greater(int[] a, int i, int[] b, int j) {
        while (i < a.length && j < b.length && a[i] == b[j]) {
            ++i; ++j;
        }
        if (i == a.length) return false;
        if (j == b.length) return true;
        return a[i] > b[j];
    }
}
