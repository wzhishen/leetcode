public class Solution {
    // Follow up for "Search in Rotated Sorted Array":
    // What if duplicates are allowed?

    // Would this affect the run-time complexity? How and why?

    // Write a function to determine if a given target is in the array.
    
    public boolean search(int[] A, int target) {
        if (A == null || A.length == 0) return false;
        return search(A, target, 0, A.length - 1);
    }
    
    // average: O(log n) time; worst-case: O(n) time
    private boolean search(int[] A, int target, int low, int high) {
        if (low > high) return false;
        int mid = low + (high - low) / 2;
        if (A[mid] == target) return true;
        else if (A[low] > A[mid]) {
            if (target > A[mid] && target <= A[high]) {
                return search(A, target, mid + 1, high);
            }
            else {
                return search(A, target, low, mid - 1);
            }
        }
        else if (A[low] < A[mid]) {
            if (target >= A[low] && target < A[mid]) {
                return search(A, target, low, mid - 1);
            }
            else {
                return search(A, target, mid + 1, high);
            }
        }
        else {
            boolean res = search(A, target, low, mid - 1);
            if (!res) res = search(A, target, mid + 1, high);
            return res;
        }
    }
}