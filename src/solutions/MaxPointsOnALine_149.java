package solutions;

import java.util.HashMap;

import datastructure.Point;

/**
 * https://leetcode.com/problems/max-points-on-a-line/
 *
 * Given n points on a 2D plane, find the maximum number of points that lie
 * on the same straight line.
 * (Plane might contain duplicate points.)
 */
public class MaxPointsOnALine_149 {
 // Beware that floating point types have numeric limits - in this version
    // we didn't address it.
    public static int maxPoints(Point[] points) {
        if (points == null) return 0;
        int maxCnt = 0;
        for (int i = 0; i < points.length; ++i) {
            HashMap<Double, Integer> map = new HashMap<Double, Integer>();
            int dup = 1;
            // We iterate like this to cover keys like -0.0, +0.0,
            // which have different numeric values in floating point
            // types as keyed to a map.
            for (int j = 0; j < points.length; ++j) {
                 if (i == j) continue;
                if (points[i].x == points[j].x && points[i].y == points[j].y) {
                    ++dup;
                    continue;
                }
                double slope = points[i].x - points[j].x == 0 ?
                    Integer.MAX_VALUE :
                    (double)(points[i].y - points[j].y) / (points[i].x - points[j].x);
                int cnt = 1;
                if (map.containsKey(slope)) cnt += map.get(slope);
                map.put(slope, cnt);
            }

            if (map.isEmpty()) {
                if (dup > maxCnt) maxCnt = dup;
            } else {
                for (double key : map.keySet()) {
                    int pointCnt = map.get(key);
                    if (pointCnt + dup > maxCnt) maxCnt = pointCnt + dup;
                }
            }
        }
        return maxCnt;
    }

    // This version considers and addresses the limits of floating point types.
    // Ref: https://github.com/wzhishen/cracking-the-coding-interview/blob/master/src/chap07/Q6.java
    public int maxPoints2(Point[] points) {
        if (points == null) return 0;
        int maxCnt = 0;
        for (int i = 0; i < points.length; ++i) {
            HashMap<Double, Integer> map = new HashMap<Double, Integer>();
            int dup = 1;
            // Don't have to iterate on visited indexes now.
            for (int j = i + 1; j < points.length; ++j) {
                if (isEqual(points[i].x, points[j].x) && isEqual(points[i].y, points[j].y)) {
                    ++dup;
                    continue;
                }
                double slope = isEqual(points[i].x, points[j].x) ?
                    Integer.MAX_VALUE :
                    (double)(points[i].y - points[j].y) / (points[i].x - points[j].x);
                double key = floor(slope);
                map.put(key, map.getOrDefault(key, 0) + 1);
            }

            if (map.isEmpty()) { // all dups
                maxCnt = Math.max(maxCnt, dup);
            } else {
                for (double key : map.keySet()) {
                    key = floor(key);
                    int pointCnt = 0;
                    if (map.containsKey(key)) pointCnt += map.get(key);
                    if (map.containsKey(key + EPS)) pointCnt += map.get(key + EPS);
                    if (map.containsKey(key - EPS)) pointCnt += map.get(key - EPS);
                    maxCnt = Math.max(maxCnt, dup + pointCnt);
                }
            }
        }
        return maxCnt;
    }

    final double EPS = 0.0000001;

    private double floor(double d) {
        return (int) (d / EPS) * EPS;
    }

    private boolean isEqual(double d1, double d2) {
        return Math.abs(d1 - d2) <= EPS;
    }
}
