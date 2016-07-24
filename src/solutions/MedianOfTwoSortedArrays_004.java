package solutions;

/**
 * https://leetcode.com/problems/median-of-two-sorted-arrays/
 *
 * There are two sorted arrays nums1 and nums2 of size m and n
 * respectively. Find the median of the two sorted arrays. The
 * overall run time complexity should be O(log (m+n)).
 */
public class MedianOfTwoSortedArrays_004 {
    /* Ref:
     * http://www.acmerblog.com/leetcode-median-of-two-sorted-arrays-5330.html
     * https://leetcode.com/discuss/74981/java-easy-version-to-understand
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length, len2 = nums2.length;
        int N = len1 + len2;
        if (N % 2 == 1) {
            return findKth(nums1, 0, len1, nums2, 0, len2, N / 2 + 1);
        } else {
            return (findKth(nums1, 0, len1, nums2, 0, len2, N / 2) +
                    findKth(nums1, 0, len1, nums2, 0, len2, N / 2 + 1)) / 2.0;
        }
    }

    // 1 based
    private int findKth(int[] a1, int s1, int len1, int[] a2, int s2, int len2, int k) {
        // let a1.length <= a2.length
        if (len1 > len2) return findKth(a2, s2, len2, a1, s1, len1, k);

        if (len1 == 0) return a2[s2 + k - 1];
        if (k == 1) return Math.min(a1[s1], a2[s2]);

        int p1 = Math.min(k / 2, len1); // middle count for a1
        int p2 = k - p1; // middle count for a2

        // a1[s1 + p1 - 1]: the k/2 th element in a1
        // a2[s2 + p2 - 1]: the k/2 th element in a2
        if (a1[s1 + p1 - 1] < a2[s2 + p2 - 1]) {
            return findKth(a1, s1 + p1, len1 - p1, a2, s2, len2, k - p1);
        } else {
            return findKth(a1, s1, len1, a2, s2 + p2, len2 - p2, k - p2);
        }
    }
}
