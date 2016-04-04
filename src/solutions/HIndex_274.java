package solutions;

import java.util.Arrays;
import java.util.Collections;

/**
 * https://leetcode.com/problems/h-index/
 *
 * Given an array of citations (each citation is a non-negative integer)
 * of a researcher, write a function to compute the researcher's h-index.
 * According to the definition of h-index on Wikipedia: "A scientist has
 * index h if h of his/her N papers have at least h citations each, and
 * the other N − h papers have no more than h citations each."
 * For example, given citations = [3, 0, 6, 1, 5], which means the researcher
 * has 5 papers in total and each of them had received 3, 0, 6, 1, 5 citations
 * respectively.
 * Since the researcher has 3 papers with at least 3 citations each and
 * the remaining two with no more than 3 citations each, his h-index is 3.
 *
 * Note: If there are several possible values for h, the maximum one is taken
 * as the h-index.
 *
 * Hint:
 * 1. An easy approach is to sort the array first.
 * 2. What are the possible values of h-index?
 * 3. A faster approach is to use extra space.
 */
public class HIndex_274 {
    // O(n log n) time, O(log n) space
    public int hIndex(int[] citations) {
        if (citations == null) return 0;

        int n = citations.length;
        Integer[] c = new Integer[n];
        for (int i = 0; i < n; ++i) c[i] = citations[i];
        Arrays.sort(c, Collections.reverseOrder());

        int low = 0, high = n - 1;
        // find first element that satisfies c[mid] <= mid
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (c[mid] <= mid) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    // O(n) time, O(n) space
    public int hIndex2(int[] citations) {
        if (citations == null) return 0;
        int n = citations.length;
        int[] cnts = new int[n + 1];
        for (int c : citations) {
            ++cnts[c >= n ? n : c];
        }
        int paperCnt = 0;
        for (int i = n; i >= 0; --i) {
            paperCnt += cnts[i];
            if (paperCnt >= i) return i;
        }
        return 0;
    }
}
