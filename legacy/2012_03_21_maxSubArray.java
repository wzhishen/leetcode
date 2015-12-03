public class Solution {
    // Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

    // For example, given the array [−2,1,−3,4,−1,2,1,−5,4],
    // the contiguous subarray [4,−1,2,1] has the largest sum = 6.

    // click to show more practice.

    // More practice:
    // If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
    
    //improved
    public int maxSubArray(int[] A) {
        if (A == null) return -1;
        int sum = 0;
        int ret = A[0];
        for (int i = 0; i < A.length; ++i) {
            sum = Math.max(sum + A[i], A[i]);
            ret = Math.max(ret, sum);
        }
        return ret;
    }

    //naive
    public int maxSubArray2(int[] A) {
        if (A == null) return -1;
        
        boolean allNeg = true;
        int max = Integer.MIN_VALUE;
        for (int a : A) {
            if (a >= 0) {
                allNeg = false;
                break;
            }
            if (a > max) max = a;
        }
        if (allNeg) return max;
        
        int sum = 0;
        int maxSum = 0;
        for (int i = 0; i < A.length; ++i) {
            sum += A[i];
            if (sum > maxSum) {
                maxSum = sum;
            }
            else if (sum < 0) {
                sum = 0;
            }
        }
        return maxSum;
    }
}