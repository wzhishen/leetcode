/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    // Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

    // You may assume that the intervals were initially sorted according to their start times.

    // Example 1:
    // Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].

    // Example 2:
    // Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].

    // This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].
    
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        if (intervals == null) return null;
        if (newInterval == null) return intervals;
        intervals.add(newInterval);
        return merge(intervals);
    }
    
    private ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        if (intervals == null || intervals.isEmpty()) return intervals;
        Collections.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval a, Interval b) {
                if (a.start > b.start) return 1;
                else if (a.start == b.start) return 0;
                else return -1;
            }
        });
        ArrayList<Interval> stack = new ArrayList<Interval>();
        stack.add(intervals.get(0));
        for (int i = 1; i < intervals.size(); ++i) {
            Interval interval = intervals.get(i);
            Interval topInterval = stack.get(stack.size()-1);
            if (interval.start > topInterval.end) {
                stack.add(interval);
            }
            else {
                if (interval.end > topInterval.end) {
                    topInterval.end = interval.end;
                }
            }
        }
        return stack;
    }
}