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
    // Ref: https://segmentfault.com/a/1190000003894670
    public int minMeetingRooms(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) return 0;

        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override public int compare(Interval i1, Interval i2) {
                return ((Integer) i1.start).compareTo(i2.start);
            }
        });

        int cnt = 1;
        PriorityQueue<Integer> q = new PriorityQueue<Integer>();
        q.offer(intervals[0].end);
        for (int i = 1; i < intervals.length; ++i) {
            if (q.peek() <= intervals[i].start) {
                q.poll();
            } else {
                ++cnt;
            }
            q.offer(intervals[i].end);
        }
        return cnt;
    }
}
