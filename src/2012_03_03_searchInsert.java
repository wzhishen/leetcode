public class Solution {
    // Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

    // You may assume no duplicates in the array.

    // Here are few examples.
    // [1,3,5,6], 5 → 2
    // [1,3,5,6], 2 → 1
    // [1,3,5,6], 7 → 4
    // [1,3,5,6], 0 → 0
    
    // recursive, O(log n) time
    public int searchInsert(int[] A, int target) {
        if (A == null || A.length == 0) return 0;
        return searchInsert(A, target, 0, A.length - 1, 0);
    }
    
    // pass extra param to get the most recent index we compared
    private int searchInsert(int[] A, int target, int low, int high, int last) {
        if (low > high) {
            if (target > A[last]) return last + 1;
            else if (target < A[last]) return last;
        }
        int mid = low + (high - low) / 2;
        if (A[mid] == target) return mid;
        else if (A[mid] > target) return searchInsert(A, target, low, mid - 1, mid);
        else return searchInsert(A, target, mid + 1, high, mid);
    }
}