public class Solution {
    // Given two sorted integer arrays A and B, merge B into A as one sorted array.

    // Note:
    // You may assume that A has enough space to hold additional elements from B. The number of elements initialized in A and B are m and n respectively.
    
    public void merge(int A[], int m, int B[], int n) {
        int end = m + n - 1;
        int enda = m - 1;
        int endb = n - 1;
        while (enda >= 0 && endb >= 0) {
            if (A[enda] > B[endb]) {
                A[end] = A[enda];
                --enda;
            }
            else {
                A[end] = B[endb];
                --endb;
            }
            --end;
        }
        while (endb >= 0) {
            A[end--] = B[endb--];
        }
    }
}