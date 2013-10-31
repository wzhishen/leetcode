public class Solution {
    // Given a sorted array of integers, find the starting and ending position of a given target value.

    // Your algorithm's runtime complexity must be in the order of O(log n).

    // If the target is not found in the array, return [-1, -1].

    // For example,
    // Given [5, 7, 7, 8, 8, 10] and target value 8,
    // return [3, 4].
    
    // public int[] searchRange(int[] A, int target) {
    //     if (A == null || A.length == 0) return new int[] {-1, -1};
    //     return searchRange(A, target, 0, A.length - 1);
    // }
    
    // iterative, O(log n) time, O(1) space
    private int[] searchRange(int[] A, int target, int low, int high) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            // if target found, use binary search branching to left/right 
            // respectively to find leftmost/rightmost index
            if (A[mid] == target) {
                int retLow = low;
                int retHigh = high;
                
                // do binary search again on left half
                int leftHigh = mid;
                while (low < leftHigh) {
                    int leftMid = low + (leftHigh - low) / 2;
                    if (A[leftMid] == target) {
                        leftHigh = leftMid - 1;
                        if (leftHigh >= 0 && A[leftHigh] != target) {
                            retLow = leftMid;
                            break;
                        }
                    }
                    else {
                        low = leftMid + 1;
                        if (A[low] == target) {
                            retLow = low;
                            break;
                        }
                    }
                }
                
                // do binary search again on right half
                int rightLow = mid;
                while (rightLow < high) {
                    int rightMid = rightLow + (high - rightLow) / 2;
                    if (A[rightMid] == target) {
                        rightLow = rightMid + 1;
                        if (rightLow <= A.length - 1 && A[rightLow] != target) {
                            retHigh = rightMid;
                            break;
                        }
                    }
                    else {
                        high = rightMid - 1;
                        if (A[high] == target) {
                            retHigh = high;
                            break;
                        }
                    }
                }
                return new int[] {retLow, retHigh};
            }
            else if (A[mid] < target) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        return new int[] {-1, -1};
    }
}