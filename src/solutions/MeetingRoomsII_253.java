package solutions;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

import datastructure.Interval;

/**
 * https://leetcode.com/problems/meeting-rooms-ii/
 *
 * Given an array of meeting time intervals consisting of start and end
 * times [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of
 * conference rooms required.
 *
 * For example,
 * Given [[0, 30],[5, 10],[15, 20]],
 * return 2.
 */
public class MeetingRoomsII_253 {
    /* Greedy: O(n log n) time, O(n) space
     *
     * Fit as many meetings as we can into one room as long as they don't
     * overlap; if they do, open a new room.
     * Use a heap to track the end time of each room. For every incoming
     * meeting, if it can be fit into the room with earliest end time (heap
     * root), reuse that room (update heap root's end time); otherwise open
     * a new room (push the new end time to the heap).
     * Total room number would be the heap size.
     *
     * Ref:
     * https://segmentfault.com/a/1190000003894670
     * https://leetcode.com/discuss/50911/ac-java-solution-using-min-heap
     */
    public int minMeetingRooms(Interval[] intervals) {
        if (intervals == null) return 0;

        Arrays.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval i1, Interval i2) {
                return i1.start - i2.start;
            }
        });

        PriorityQueue<Integer> q = new PriorityQueue<Integer>();
        for (Interval i : intervals) {
            if (!q.isEmpty() && i.start >= q.peek()) q.poll();
            q.offer(i.end);
        }
        return q.size();
    }
}
