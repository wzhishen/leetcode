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
    // Given a collection of intervals, merge all overlapping intervals.

    // For example,
    // Given [1,3],[2,6],[8,10],[15,18],
    // return [1,6],[8,10],[15,18].
    
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
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
            if (topInterval.end < interval.start) {
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