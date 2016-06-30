package solutions;

/**
 * https://leetcode.com/problems/reverse-bits/
 *
 * Reverse bits of a given 32 bits unsigned integer.
 * For example, given input 43261596 (represented in binary as
 * 00000010100101000001111010011100), return 964176192 (represented
 * in binary as 00111001011110000010100101000000).
 *
 * Follow up:
 * If this function is called many times, how would you optimize it?
 *
 * Related problem: Reverse Integer
 * (https://leetcode.com/problems/reverse-integer/)
 */
public class ReverseBits_190 {

    // O(8) time
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int r = 0;
        for (int i = 0; i < 8; ++i) {
            r <<= 4;
            int curr = n & 0xF;
            r |= table[curr];
            n >>>= 4;
        }
        return r;
    }
    private final int[] table = {0,8,4,12,2,10,6,14,1,9,5,13,3,11,7,15};

    // O(32) time
    public int reverseBitsNaive(int n) {
        int r = 0;
        for (int i = 0; i < 32; ++i) {
            r <<= 1;
            r |= n & 1;
            n >>>= 1;
        }
        return r;
    }

    // O(32) time
    public int reverseBitsNaive2(int n) {
        int r = 0, cnt = 32;
        while (n != 0) {
            r <<= 1;
            r |= n & 1;
            n >>>= 1;
            --cnt;
        }
        return r << cnt;
    }

    // O(1) time: https://leetcode.com/discuss/27405/o-1-bit-operation-c-solution-8ms
}
