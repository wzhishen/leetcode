package solutions;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import datastructure.Interval;

/**
 * https://leetcode.com/problems/merge-intervals/
 *
 * Given a collection of intervals, merge all overlapping intervals.
 *
 * For example,
 * Given [1,3],[2,6],[8,10],[15,18],
 * return [1,6],[8,10],[15,18].
 */
public class MergeIntervals_056 {
    // O(n) time, O(n) space
    public List<Interval> merge(List<Interval> intervals) {
        LinkedList<Interval> result = new LinkedList<Interval>();
        if (intervals == null) return result;
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval i1, Interval i2) {
                return ((Integer) i1.start).compareTo(i2.start);
            }
        });

        for (Interval interval : intervals) {
            if (result.isEmpty() || interval.start > result.getLast().end) {
                result.add(interval);
            } else {
                result.getLast().end = Math.max(interval.end, result.getLast().end);
            }
        }
        return result;
    }
}
