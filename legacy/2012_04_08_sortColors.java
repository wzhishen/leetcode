public class Solution {
    // Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.

    // Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

    // Note:
    // You are not suppose to use the library's sort function for this problem.

    // click to show follow up.

    // Follow up:
    // A rather straight forward solution is a two-pass algorithm using counting sort.
    // First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.

    // Could you come up with an one-pass algorithm using only constant space?
    
    public void sortColors(int[] A) {
        if (A == null) return;
        int zeros = 0;
        int ones = 0;
        for (int i = 0; i < A.length; ++i) {
            if (A[i] == 0) ++zeros;
            else if (A[i] == 1) ++ones;
        }
        for (int i = 0; i < A.length; ++i) {
            if (zeros-- > 0) A[i] = 0;
            else if (ones-- > 0) A[i] = 1;
            else A[i] = 2;
        }
    }
}