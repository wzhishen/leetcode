public class Solution {
    // O(n) time, O(n) space
    public int trap(int[] A) {
        if (A == null || A.length == 0) return 0;
        int[] leftHeights = new int[A.length];
        // The first/last bar will always trap no water,
        // so safely start from the next bar.
        int leftMaxHeight = A[0];
        for (int i = 1; i < A.length; ++i) {
            leftHeights[i] = leftMaxHeight;
            if (A[i] > leftMaxHeight) leftMaxHeight = A[i];
        }
        int rain = 0;
        int rightMaxHeight = A[A.length - 1];
        for (int i = A.length - 2; i >= 0; --i) {
            int height = Math.min(leftHeights[i], rightMaxHeight);
            if (height > A[i]) rain += height - A[i];
            if (A[i] > rightMaxHeight) rightMaxHeight = A[i];
        }
        return rain;
    }
}