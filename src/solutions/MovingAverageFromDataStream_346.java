package solutions;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/moving-average-from-data-stream/
 *
 * Given a stream of integers and a window size, calculate the moving
 * average of all integers in the sliding window.
 *
 * For example,
 * MovingAverage m = new MovingAverage(3);
 * m.next(1) = 1
 * m.next(10) = (1 + 10) / 2
 * m.next(3) = (1 + 10 + 3) / 3
 * m.next(5) = (10 + 3 + 5) / 3
 */
public class MovingAverageFromDataStream_346 {

    public class MovingAverage {
        private Queue<Integer> q = new LinkedList<Integer>();
        private int windowSize;
        private double sum;

        /** Initialize your data structure here. */
        public MovingAverage(int size) {
            q = new LinkedList<Integer>();
            windowSize = size;
            sum = 0.0;
        }

        public double next(int val) {
            if (q.size() == windowSize) sum -= q.remove();
            q.add(val);
            sum += val;
            return sum / q.size();
        }
    }

    /**
     * Your MovingAverage object will be instantiated and called as such:
     * MovingAverage obj = new MovingAverage(size);
     * double param_1 = obj.next(val);
     */
}
