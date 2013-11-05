public class Solution {
    // Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.

    // Do not allocate extra space for another array, you must do this in place with constant memory.

    // For example,
    // Given input array A = [1,1,2],

    // Your function should return length = 2, and A is now [1,2].
    
    //Use two pointers: one points to the head of sorted array, 
    //the other tries to find the first distinct element.
    public int removeDuplicates(int[] A) {
        if (A == null || A.length == 0) return 0;
        int i = 0;
        for (int j = 1; j < A.length; ++j) {
            if (A[i] != A[j]) {
                A[i + 1] = A[j];
                ++i;
            }
        }
        return i + 1;
    }
}