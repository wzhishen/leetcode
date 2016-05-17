package solutions;

/**
 * https://leetcode.com/problems/smallest-rectangle-enclosing-black-pixels/
 *
 * An image is represented by a binary matrix with 0 as a white pixel
 * and 1 as a black pixel. The black pixels are connected, i.e., there
 * is only one black region. Pixels are connected horizontally and
 * vertically. Given the location (x, y) of one of the black pixels,
 * return the area of the smallest (axis-aligned) rectangle that encloses
 * all black pixels.
 *
 * For example, given the following image:
 * [
 *   "0010",
 *   "0110",
 *   "0100"
 * ]
 * and x = 0, y = 2,
 * Return 6.
 */
public class SmallestRectangleEnclosingBlackPixels_302 {
    /* BF: O(mn) time, O(1) space
     * Traverse whole matrix, keep track of 4 boundary points
     *
     * Binary Search: O(mlogn + nlogm) time, O(1) space
     * Binary search 4 boundary points
     */
    public int minArea(char[][] image, int x, int y) {
        return (searchRight(image, y) - searchLeft(image, y) + 1) *
               (searchBottom(image, x) - searchTop(image, x) + 1);
    }

    private int searchLeft(char[][] image, int y) {
        int low = 0, high = y;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int i = 0;
            while (i < image.length && image[i][mid] == '0') ++i;
            if (i < image.length) high = mid - 1;
            else low = mid + 1;
        }
        return low;
    }

    private int searchRight(char[][] image, int y) {
        int low = y, high = image[0].length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int i = 0;
            while (i < image.length && image[i][mid] == '0') ++i;
            if (i < image.length) low = mid + 1;
            else high = mid - 1;
        }
        return high;
    }

    private int searchTop(char[][] image, int x) {
        int low = 0, high = x;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int i = 0;
            while (i < image[0].length && image[mid][i] == '0') ++i;
            if (i < image[0].length) high = mid - 1;
            else low = mid + 1;
        }
        return low;
    }

    private int searchBottom(char[][] image, int x) {
        int low = x, high = image.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int i = 0;
            while (i < image[0].length && image[mid][i] == '0') ++i;
            if (i < image[0].length) low = mid + 1;
            else high = mid - 1;
        }
        return high;
    }
}
