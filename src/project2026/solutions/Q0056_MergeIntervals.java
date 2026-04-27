package project2026.solutions;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
https://leetcode.com/problems/merge-intervals/

Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.



Example 1:

Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].

Example 2:

Input: intervals = [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.

Example 3:

Input: intervals = [[4,7],[1,4]]
Output: [[1,7]]
Explanation: Intervals [1,4] and [4,7] are considered overlapping.


Constraints:

1 <= intervals.length <= 104
intervals[i].length == 2
0 <= starti <= endi <= 104

 */
public class Q0056_MergeIntervals {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> res = new LinkedList<>();
        for (int[] interval : intervals) {
            if (res.isEmpty() || res.getLast()[1] < interval[0]) {
                res.add(interval);
            } else {
                int[] last = res.getLast();
                last[1] = Math.max(last[1], interval[1]);
            }
        }
        return res.toArray(new int[][] {});
    }

    // public int[][] merge(int[][] intervals) {
    //     Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
    //     LinkedList<int[]> res = new LinkedList<>();
    //     res.add(intervals[0]);
    //     for (int i = 1; i < intervals.length; ++i) {
    //         int[] last = res.getLast();
    //         if (intervals[i][0] > last[1]) {
    //             res.add(intervals[i]);
    //         } else {
    //             last[1] = Math.max(last[1], intervals[i][1]);
    //         }
    //     }
    //     return res.toArray(new int[][] {});
    // }
}
