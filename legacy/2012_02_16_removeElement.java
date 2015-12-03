public class Solution {
    public int removeElement(int[] A, int elem) {
        // Given an array and a value, remove all instances of that value in place and return the new length.

        // The order of elements can be changed. It doesn't matter what you leave beyond the new length.
        
        if (A == null || A.length == 0) return 0;
        int tail = A.length - 1;
        int head = 0;
        while (head <= tail) {
            if (A[head] == elem) {
                while (A[tail] == elem && head != tail) {
                    --tail;
                    if (tail < 0) return 0;
                }
                int tmp = A[head];
                A[head] = A[tail];
                A[tail] = tmp;
                --tail;
            }
            ++head;
        }
        return tail + 1;
    }
}