package solutions;

/**
 * https://leetcode.com/problems/rectangle-area/
 *
 * Find the total area covered by two rectilinear rectangles in a 2D plane.
 * Each rectangle is defined by its bottom left corner and top right corner
 * as shown in the figure.
 *
 * https://leetcode.com/static/images/problemset/rectangle_area.png
 *
 * Assume that the total area is never beyond the maximum possible value of int.
 */
public class RectangleArea_223 {
    /*
     * Look at each axis as an overlap interval problem.
     * If 2 rectangles do not have overlap, the total area is the sum of 2 rectangle
     * areas; otherwise, the total area should minus the overlap area.
     */
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int twoArea = (C - A) * (D - B) + (G - E) * (H - F);
        if (C < E || G < A || H < B || D < F) return twoArea;
        int L1 = Math.min(C, G) - Math.max(A, E);
        int L2 = Math.min(D, H) - Math.max(B, F);
        return twoArea - L1 * L2;
    }
}
