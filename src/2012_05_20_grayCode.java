public class Solution {
    // The gray code is a binary numeral system where two successive values differ in only one bit.

    // Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code. A gray code sequence must begin with 0.

    // For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:

    // 00 - 0
    // 01 - 1
    // 11 - 3
    // 10 - 2
    // Note:
    // For a given n, a gray code sequence is not uniquely defined.

    // For example, [0,2,3,1] is also a valid gray code sequence according to the above definition.

    // For now, the judge is able to judge based on one instance of gray code sequence. Sorry about that.
    
    public ArrayList<Integer> grayCode(int n) {
        ArrayList<Integer> ret = new ArrayList<Integer>();
        if (n < 0) return ret;
        for (int i = 0; i < 1<<n; ++i) {
            ret.add(i>>1 ^ i);
        }
        return ret;
    }
}