package solutions;

import java.util.ArrayList;
import java.util.Collections;

/**
 * https://leetcode.com/problems/best-meeting-point/
 *
 * A group of two or more people wants to meet and minimize the total
 * travel distance. You are given a 2D grid of values 0 or 1, where
 * each 1 marks the home of someone in the group. The distance is
 * calculated using Manhattan Distance, where:
 * distance(p1, p2) = |p2.x - p1.x| + |p2.y - p1.y|.
 *
 * For example, given three people living at (0,0), (0,4), and (2,2):
 * 1 - 0 - 0 - 0 - 1
 * |   |   |   |   |
 * 0 - 0 - 0 - 0 - 0
 * |   |   |   |   |
 * 0 - 0 - 1 - 0 - 0
 * The point (0,2) is an ideal meeting point, as the total travel
 * distance of 2+2+2=6 is minimal. So return 6.
 *
 * Hint:
 * 1. Try to solve it in one dimension first. How can this solution
 * apply to the two dimension case?
 */
public class BestMeetingPoint_296 {
    /* For 1D case, best meeting point for min distance is the mid
     * point where left and right sides have equal number of people.
     *
     * For 2D case, we can calculate on X and Y axis separately and
     * then combine the sum, since it's Manhattan Distance.
     *
     * Ref:
     * https://leetcode.com/discuss/65336/14ms-java-solution
     * https://segmentfault.com/a/1190000003894693
     */
    public int minTotalDistance(int[][] grid) {
        if (grid == null) return 0;

        ArrayList<Integer> xs = new ArrayList<Integer>();
        ArrayList<Integer> ys = new ArrayList<Integer>();
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                if (grid[i][j] == 1) {
                    xs.add(i);
                    ys.add(j);
                }
            }
        }
        // actually no need to sort xs since it's already in order
        Collections.sort(ys);
        return getMinDistance(xs) + getMinDistance(ys);
    }

    private int getMinDistance(ArrayList<Integer> list) {
        int i = 0, j = list.size() - 1, dis = 0;
        while (i < j) dis += list.get(j--) - list.get(i++);
        return dis;
    }
}
