package solutions;

import java.util.List;

import datastructure.NestedInteger;

/**
 * https://leetcode.com/problems/nested-list-weight-sum/
 *
 * Given a nested list of integers, return the sum of all integers
 * in the list weighted by their depth.
 * Each element is either an integer, or a list -- whose elements
 * may also be integers or other lists.
 *
 * Example 1:
 * Given the list [[1,1],2,[1,1]], return 10. (four 1's at depth 2,
 * one 2 at depth 1)
 *
 * Example 2:
 * Given the list [1,[4,[6]]], return 27. (one 1 at depth 1, one 4
 * at depth 2, and one 6 at depth 3; 1 + 4*2 + 6*3 = 27)
 */
public class NestedListWeightSum_339 {
    public int depthSum(List<NestedInteger> nestedList) {
        if (nestedList == null) return 0;
        return depthSum(nestedList, 1);
    }

    private int depthSum(List<NestedInteger> nestedList, int depth) {
        int sum = 0;
        for (NestedInteger ni : nestedList) {
            if (ni.isInteger()) {
                sum += ni.getInteger() * depth;
            } else {
                sum += depthSum(ni.getList(), depth + 1);
            }
        }
        return sum;
    }
}
