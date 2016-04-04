package solutions;

/**
 * https://leetcode.com/problems/h-index-ii/
 *
 * Follow up for H-Index: What if the citations array is sorted in
 * ascending order? Could you optimize your algorithm?
 *
 * Hint:
 * Expected runtime complexity is in O(log n) and the input is sorted.
 */
public class HIndexII_275 {
    public int hIndex(int[] citations) {
        if (citations == null) return 0;
        int n = citations.length;
        int low = 0, high = n - 1;
        while (low <= high) {
            int mid = (low + high) >> 1;
            /* current paper citations can be a valid H index when:
             * current paper citations <= rest number of papers with equal/higher citations
             * ie., citations[mid] <= n - mid - 1
             */
            if (citations[mid] < n - mid) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return n - low;
    }

    public int hIndex2(int[] citations) {
        if (citations == null) return 0;
        int n = citations.length;
        int low = 0, high = n - 1;
        while (low <= high) {
            int mid = (low + high) >> 1;
            if (n - mid == citations[mid]) {
                return n - mid;
            } else if (n - mid > citations[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return n - low;
    }
}
