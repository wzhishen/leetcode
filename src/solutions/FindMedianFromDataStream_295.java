package solutions;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/find-median-from-data-stream/
 *
 * Median is the middle value in an ordered integer list. If the size of the
 * list is even, there is no middle value. So the median is the mean of the
 * two middle value.
 *
 * Examples:
 * [2,3,4] , the median is 3
 * [2,3], the median is (2 + 3) / 2 = 2.5
 *
 * Design a data structure that supports the following two operations:
 * void addNum(int num) - Add a integer number from the data stream to the
 * data structure.
 * double findMedian() - Return the median of all elements so far.
 *
 * For example:
 * add(1)
 * add(2)
 * findMedian() -> 1.5
 * add(3) 
 * findMedian() -> 2
 */
public class FindMedianFromDataStream_295 {

    class MedianFinder {
        private PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
        private PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();

        // Adds a number into the data structure.
        public void addNum(int n) {
            if (maxHeap.size() == minHeap.size()) {
                if (maxHeap.isEmpty() || n < minHeap.peek()) {
                    maxHeap.offer(n);
                } else {
                    maxHeap.offer(minHeap.poll());
                    minHeap.offer(n);
                }
            } else {
                if (n > maxHeap.peek()) {
                    minHeap.offer(n);
                } else {
                    minHeap.offer(maxHeap.poll());
                    maxHeap.offer(n);
                }
            }
        }

        // Returns the median of current data stream
        public double findMedian() {
            if (maxHeap.isEmpty()) {
                throw new IllegalStateException();
            } else if (maxHeap.size() == minHeap.size()) {
                return (maxHeap.peek() + minHeap.peek()) / 2.0;
            } else {
                return maxHeap.peek();
            }
        }
    };

    // Your MedianFinder object will be instantiated and called as such:
    // MedianFinder mf = new MedianFinder();
    // mf.addNum(1);
    // mf.findMedian();
}
