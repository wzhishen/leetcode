package solutions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/the-skyline-problem/
 *
 * A city's skyline is the outer contour of the silhouette formed by all the buildings
 * in that city when viewed from a distance. Now suppose you are given the locations and
 * height of all the buildings as shown on a cityscape photo (Figure A), write a program
 * to output the skyline formed by these buildings collectively (Figure B).
 * https://leetcode.com/static/images/problemset/skyline1.jpg
 * https://leetcode.com/static/images/problemset/skyline2.jpg
 *
 * The geometric information of each building is represented by a triplet of integers
 * [Li, Ri, Hi], where Li and Ri are the x coordinates of the left and right edge of the
 * ith building, respectively, and Hi is its height. It is guaranteed that 0 <= Li,
 * Ri <= INT_MAX, 0 < Hi <= INT_MAX, and Ri - Li > 0. You may assume all buildings are
 * perfect rectangles grounded on an absolutely flat surface at height 0.
 *
 * For instance, the dimensions of all buildings in Figure A are recorded as:
 * [ [2 9 10], [3 7 15], [5 12 12], [15 20 10], [19 24 8] ] .
 *
 * The output is a list of "key points" (red dots in Figure B) in the format of
 * [ [x1,y1], [x2, y2], [x3, y3], ... ] that uniquely defines a skyline. A key point is
 * the left endpoint of a horizontal line segment. Note that the last key point, where the
 * rightmost building ends, is merely used to mark the termination of the skyline and always
 * has zero height. Also, the ground in between any two adjacent buildings should be considered
 * part of the skyline contour.
 *
 * For instance, the skyline in Figure B should be represented as:
 * [ [2 10], [3 15], [7 12], [12 0], [15 10], [20 8], [24, 0] ].
 *
 * Notes:
 * 1. The number of buildings in any input list is guaranteed to be in the range [0, 10000].
 * 2. The input list is already sorted in ascending order by the left x position Li.
 * 3. The output list must be sorted by the x position.
 * 4. There must be no consecutive horizontal lines of equal height in the output skyline.
 * 5. For instance, [...[2 3], [4 5], [7 5], [11 5], [12 7]...] is not acceptable; the three lines
 * of height 5 should be merged into one in the final output as such: [...[2 3], [4 5], [12 7], ...]
 */
public class TheSkylineProblem_218 {
    /* Sort all left and right points on x coordinate.
     * Scan thru all points and see if the current max height changes, every change
     * means a key point occurs.
     * To get the current max height, use a max heap to maintain:
     * for left points, add corresponding heights to the heap (a rectangle starts);
     * for right points, remove corresponding heights from the heap (a rectangle ends).
     *
     * Ref: https://segmentfault.com/a/1190000003786782
     *
     * worst case O(n^2) time (since PriorityQueue.remove(o) is O(n) time), O(n) space
     */
    public List<int[]> getSkyline(int[][] buildings) {
        LinkedList<int[]> res = new LinkedList<int[]>();
        if (buildings == null) return res;

        List<int[]> points = new ArrayList<int[]>();
        for (int[] b : buildings) {
            points.add(new int[] {b[0], b[2], LEFT}); // left point
            points.add(new int[] {b[1], b[2], RIGHT}); // right point
        }
        /* Properly sort left and right points so that we can correctly handle special
         * case like: [x1,x2,h1], [x1,x2,h2], [x1,x2,h3].
         * For left points with same x, the ones with greater height should come first.
         * For right points with same x, the ones with smaller height should come first.
         * Otherwise for points with same x, left points should come first.
         */
        Collections.sort(points, new Comparator<int[]>() {
            public int compare(int[] p1, int[] p2) {
                if (p1[0] == p2[0]) {
                    if (p1[2] == LEFT && p2[2] == LEFT) return p2[1] - p1[1];
                    else if (p1[2] == RIGHT && p2[2] == RIGHT) return p1[1] - p2[1];
                    else return p1[2] - p2[2];
                } else {
                    return p1[0] - p2[0];
                }
            }
        });

        PriorityQueue<Integer> q = new PriorityQueue<Integer>(Collections.reverseOrder());
        q.offer(0);
        int maxHeight = 0;
        for (int[] p : points) {
            if (p[2] == LEFT) q.offer(p[1]);
            else q.remove(p[1]);

            int currMaxHeight = q.peek();
            if (currMaxHeight != maxHeight) {
                res.add(new int[] {p[0], currMaxHeight});
                maxHeight = currMaxHeight;
            }
        }
        return res;
    }

    private final int LEFT = 0, RIGHT = 1;
}
