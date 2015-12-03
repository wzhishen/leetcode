public class Solution {
    // There are two sorted arrays A and B of size m and n 
    // respectively. Find the median of the two sorted arrays. The 
    // overall run time complexity should be O(log (m+n)).

    public double findMedianSortedArrays(int A[], int B[]) {
        if (A == null || B == null) return -1;
        int len = A.length + B.length;
        if (len % 2 == 0)
            return (findKth(A, B, len / 2) + findKth(A, B, len / 2 + 1)) / 2.0;
        else
            return findKth(A, B, len / 2 + 1);
    }
    
    // Another general problem: find kth element in two sorted arrays
    private int findKth(int[] A, int[] B, int k) { // k starts from 1
        if (A.length > B.length) return findKth(B, A, k);
        if (A.length == 0) return B[k - 1];
        if (k == 1) return Math.min(A[0], B[0]);
        int pa = Math.min(k / 2, A.length);
        int pb = k - pa;
        if (A[pa - 1] == B[pb - 1]) 
            return A[pa - 1];
        else if (A[pa - 1] < B[pb - 1]) 
            return findKth(Arrays.copyOfRange(A, pa, A.length), B, k - pa);
        else 
            return findKth(A, Arrays.copyOfRange(B, pb, B.length), k - pb);
    }
}