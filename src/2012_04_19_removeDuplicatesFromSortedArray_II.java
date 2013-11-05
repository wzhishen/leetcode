public class Solution {
    // Follow up for "Remove Duplicates":
    // What if duplicates are allowed at most twice?

    // For example,
    // Given sorted array A = [1,1,1,2,2,3],

    // Your function should return length = 5, and A is now [1,1,2,2,3].

    
    // This can be generalized to the problem of Removing Duplicates 
    // from Sorted Array where duplicates are allowed at most N times.
    final int MAX_DUP_ALLOWED = 2;
    
    public int removeDuplicates(int[] A) {
        if (A == null || A.length == 0) return 0;
        if (A.length == 1) return 1;
        int i = 0;
        int cnt = 1;
        for (int j = 1; j < A.length; ++j) {
            if (A[i] == A[j] && cnt < MAX_DUP_ALLOWED) {
                A[i + 1] = A[j];
                ++i;
                ++cnt;
            }
            else if (A[i] != A[j]) {
                A[i + 1] = A[j];
                ++i;
                cnt = 1;
            }
        }
        return i + 1;
    }
}