public class Solution {
    // Given an array of integers, every element appears twice except for one. Find that single one.

    // Note:
    // Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

    //use XOR property
    public int singleNumber(int[] A) {
        if (A == null || A.length == 0) return -1;
        int ret = 0;
        for (int a : A) {
            ret ^= a;
        }
        return ret;
    }
}