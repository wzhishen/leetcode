package solutions;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/pascals-triangle/
 *
 * Given numRows, generate the first numRows of Pascal's triangle.
 *
 * For example, given numRows = 5,
 * Return
 * [
 *      [1],
 *     [1,1],
 *    [1,2,1],
 *   [1,3,3,1],
 *  [1,4,6,4,1]
 * ]
 */
public class PascalsTriangle_118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (numRows <= 0) return result;
        ArrayList<Integer> prev = new ArrayList<Integer>();
        prev.add(1);
        result.add(new ArrayList<Integer>(prev));
        if (numRows == 1) {
            return result;
        }
        for (int i = 2; i <= numRows; ++i) {
            ArrayList<Integer> curr = new ArrayList<Integer>();
            curr.add(1);
            for (int j = 0; j < prev.size() - 1; ++j) {
                curr.add(prev.get(j) + prev.get(j + 1));
            }
            curr.add(1);
            result.add(new ArrayList<Integer>(curr));
            prev = curr;
        }
        return result;
    }

    // Shorter: https://leetcode.com/discuss/20606/my-concise-solution-in-java
    public List<List<Integer>> generate2(int numRows) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (numRows <= 0) return res;
        List<Integer> row = new ArrayList<Integer>();
        for (int i = 0; i < numRows; ++i) {
            row.add(0, 1);
            for (int j = 1; j < row.size() - 1; ++j) {
                row.set(j, row.get(j) + row.get(j + 1));
            }
            res.add(new ArrayList<Integer>(row));
        }
        return res;
    }
}
