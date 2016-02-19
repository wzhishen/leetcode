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
    public int maxPoints(Point[] points) {
        if (points == null) return 0;
        int maxCnt = 0;
        for (int i = 0; i < points.length; ++i) {
            HashMap<Double, Integer> map = new HashMap<Double, Integer>();
            int dup = 1;
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
}
