public class Solution {
    // Given an array of non-negative integers, you are initially positioned at the first index of the array.

    // Each element in the array represents your maximum jump length at that position.

    // Determine if you are able to reach the last index.

    // For example:
    // A = [2,3,1,1,4], return true.

    // A = [3,2,1,0,4], return false.
    
    // iterative
    public boolean canJump(int[] A) {
        if (A == null || A.length == 0)  return false;
        if (A.length == 1) return true; //edge case!
        int pos = 0;
        while (pos <= A.length - 1) {
            int oldpos = pos;
            int steps = A[oldpos];
            while (steps > 0) {
                ++pos;
                --steps;
                if (pos >= A.length - 1) return true;
                // failed, retry other paths
                if (A[pos] == 0 && steps == 0) {
                    steps = --A[oldpos];
                    pos = oldpos;
                }
            }
            if (A[pos] == 0) return false;
        }
        return false;
    }
    
    // recursive, with memoization
    public boolean canJumpRecursive(int[] A) {
        if (A == null || A.length == 0)  return false;
        if (A.length == 1) return true; //edge case!
        return canJumpRecursive(A, 0, new HashMap<Integer, Boolean>());
    }
    
    private boolean canJumpRecursive(int[] A, int pos, HashMap<Integer, Boolean> cache) {
        if (cache.containsKey(pos)) return cache.get(pos);
        if (pos >= A.length - 1) return true;
        if (A[pos] == 0) return false;
        int steps = A[pos];
        for (int i = 1; i <= steps; ++i) {
            if (canJumpRecursive(A, pos + i, cache)) {
                cache.put(pos + i, true);
                return true;
            }
        }
        cache.put(pos, false);
        return false;
    }
}