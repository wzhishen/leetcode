package solutions;

import java.util.HashSet;

/**
 * https://leetcode.com/problems/line-reflection/
 *
 * Given n points on a 2D plane, find if there is such a line parallel
 * to y-axis that reflect the given points.
 * Example 1:
 * Given points = [[1,1],[-1,1]], return true.
 * Example 2:
 * Given points = [[1,1],[-1,-1]], return false.
 * Follow up:
 * Could you do better than O(n2)?
 * 
 * Hint:
 * 1. Find the smallest and largest x-value for all points.
 * 2. If there is a line then it should be at y = (minX + maxX) / 2.
 * 3. For each point, make sure that it has a reflected point in the
 *    opposite side.
 */
public class LineReflection_356 {
    public boolean isReflected(int[][] points) {
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        HashSet<String> set = new HashSet<>();
        for (int[] p : points) {
            max = Math.max(max, p[0]);
            min = Math.min(min, p[0]);
            set.add(p[0] + "x" + p[1]);
        }
        int sum = min + max;
        for (int[] p : points) {
            if (!set.contains((sum - p[0]) + "x" + p[1])) return false;
        }
        return true;
    }
}
