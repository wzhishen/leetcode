package solutions;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/pascals-triangle-ii/
 *
 * Given an index k, return the kth row of the Pascal's triangle.
 * For example, given k = 3,
 * Return [1,3,3,1].
 *
 * Note:
 * Could you optimize your algorithm to use only O(k) extra space?
 */
public class PascalsTriangleII_119 {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<Integer>();
        if (rowIndex < 0) return result;
        result.add(1);
        for (int i = 1; i <= rowIndex; ++i) {
            for (int j = result.size() - 2; j >= 0; --j) {
                result.set(j + 1, result.get(j) + result.get(j + 1));
            }
            result.add(1);
        }
        return result;
    }

    public List<Integer> getRow2(int rowIndex) {
        List<Integer> row = new ArrayList<Integer>();
        if (rowIndex < 0) return row;
        for (int i = 0; i <= rowIndex; ++i) {
            row.add(0, 1);
            for (int j = 1; j < row.size() - 1; ++j) {
                row.set(j, row.get(j) + row.get(j + 1));
            }
        }
        return row;
    }
}
