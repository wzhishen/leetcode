package solutions;

import java.util.Deque;
import java.util.LinkedList;

/**
 * https://leetcode.com/problems/sliding-window-maximum/
 *
 * Given an array nums, there is a sliding window of size k which is moving
 * from the very left of the array to the very right. You can only see the k
 * numbers in the window. Each time the sliding window moves right by one
 * position.
 *
 * For example,
 * Given nums = [1,3,-1,-3,5,3,6,7], and k = 3.
 * Window position                Max
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 * Therefore, return the max sliding window as [3,3,5,5,6,7].
 *
 * Note: 
 * You may assume k is always valid, ie: 1 ¡Ü k ¡Ü input array's size for
 * non-empty array.
 *
 * Follow up:
 * Could you solve it in linear time?
 *
 * Hint:
 * 1. How about using a data structure such as deque (double-ended queue)?
 * 2. The queue size need not be the same as the window¡¯s size.
 * 3. Remove redundant elements and the queue should store only elements that
 * need to be considered.
 */
public class SlidingWindowMaximum_239 {
    /*
     * Approaches:
     * 1. BF: O(nk) time, O(1) space
     * 2. Heap: O(nlogk) time, O(k) space
     * 3. Deque: O(n) time, at most O(k) space
     *
     * Use a monotonic queue.
     * Reference: https://leetcode.com/discuss/46594/clean-c-o-n-solution-using-a-deque
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || k <= 0) return new int[0];

        int[] res = new int[nums.length - k + 1]; int j = 0;
        Deque<Integer> d = new LinkedList<Integer>();
        for (int i = 0; i < nums.length; ++i) {
            while (!d.isEmpty() && nums[d.getLast()] <= nums[i]) d.removeLast();
            d.addLast(i);
            if (!d.isEmpty() && d.getFirst() < i - k + 1) d.removeFirst();
            if (i >= k - 1) res[j++] = nums[d.getFirst()];
        }
        return res;
    }
}
