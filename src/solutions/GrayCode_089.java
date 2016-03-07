package solutions;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/gray-code/
 *
 * The gray code is a binary numeral system where two successive values
 * differ in only one bit.
 * Given a non-negative integer n representing the total number of bits
 * in the code, print the sequence of gray code. A gray code sequence must
 * begin with 0.
 *
 * For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:
 * 00 - 0
 * 01 - 1
 * 11 - 3
 * 10 - 2
 *
 * Note:
 * For a given n, a gray code sequence is not uniquely defined.
 * For example, [0,2,3,1] is also a valid gray code sequence according to
 * the above definition.
 * For now, the judge is able to judge based on one instance of gray code
 * sequence. Sorry about that.
 */
public class GrayCode_089 {
    /* Reference:
     * http://bangbingsyb.blogspot.com/2014/11/leetcode-gray-code.html
     * https://leetcode.com/discuss/2978/what-solution-gray-code-problem-extra-space-used-recursion
     */
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<Integer>();
        if (n < 0) return res;

        res.add(0);
        for (int i = 0; i < n; ++i) {
            int b = 1 << i;
            for (int j = res.size() - 1; j >= 0; --j) {
                res.add(res.get(j) + b);
            }
        }
        return res;
    }
}
