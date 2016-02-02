package solutions;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/combinations/
 *
 * Given two integers n and k, return all possible combinations of k numbers
 * out of 1 ... n.
 *
 * For example,
 * If n = 4 and k = 2, a solution is:
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 */
public class Combinations_077 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        if (n <= 0 || k <= 0) return lists;
        combine(n, k, 1, new ArrayList<Integer>(), lists);
        return lists;
    }

    private void combine(int n, int k, int index, List<Integer> list, List<List<Integer>> lists) {
        if (k == 0) {
            lists.add(new ArrayList<Integer>(list));
        } else {
            for (int i = index; i <= n; ++i) {
                list.add(i);
                combine(n, k - 1, i + 1, list, lists);
                list.remove(list.size() - 1);
            }
        }
    }
}
