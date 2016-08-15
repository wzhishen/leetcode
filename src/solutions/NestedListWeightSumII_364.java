package solutions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import datastructure.NestedInteger;

/**
 * https://leetcode.com/problems/nested-list-weight-sum-ii/
 *
 * Given a nested list of integers, return the sum of all integers
 * in the list weighted by their depth.
 * Each element is either an integer, or a list -- whose elements
 * may also be integers or other lists.
 * Different from the previous question where weight is increasing
 * from root to leaf, now the weight is defined from bottom up. i.e.,
 * the leaf level integers have weight 1, and the root level integers
 * have the largest weight.
 *
 * Example 1:
 * Given the list [[1,1],2,[1,1]], return 8. (four 1's at depth 1,
 * one 2 at depth 2)
 *
 * Example 2:
 * Given the list [1,[4,[6]]], return 17. (one 1 at depth 3, one 4
 * at depth 2, and one 6 at depth 1; 1*3 + 4*2 + 6*1 = 17)
 */
public class NestedListWeightSumII_364 {
    // My second version
    public int depthSumInverse(List<NestedInteger> nestedList) {
        int sum = 0, cur = 0;
        Queue<NestedInteger> q = new LinkedList<>();
        for (NestedInteger i : nestedList) q.add(i);
        while (!q.isEmpty()) {
            int size = q.size(); 
            for (int i = 0; i < size; ++i) {
                NestedInteger n = q.remove();
                if (n.isInteger()) cur +=  n.getInteger();
                else q.addAll(n.getList());
            }
            sum += cur;
        }
        return sum;
    }

    public int depthSumInverse2(List<NestedInteger> nestedList) {
        int res = 0; // weighted sum
        int sum = 0; // unweighted sum
        while (!nestedList.isEmpty()) {
            List<NestedInteger> level = new ArrayList<>();
            for (NestedInteger ni : nestedList) {
                if (ni.isInteger()) {
                    sum += ni.getInteger();
                } else {
                    level.addAll(ni.getList());
                }
            }
            res += sum;
            nestedList = level;
        }
        return res;
    }

    // Naive
    public int depthSumInverse3(List<NestedInteger> nestedList) {
        getDepth(nestedList, 1);
        return traverse(nestedList, depth);
    }

    private int traverse(List<NestedInteger> nestedList, int d) {
        int sum = 0;
        for (NestedInteger ni : nestedList) {
            if (ni.isInteger()) {
                sum += ni.getInteger() * d;
            } else {
                sum += traverse(ni.getList(), d - 1);
            }
        }
        return sum;
    }

    private int depth = 0;
    private void getDepth(List<NestedInteger> nestedList, int d) {
        for (NestedInteger ni : nestedList) {
            if (ni.isInteger()) {
                depth = Math.max(depth, d);
            } else {
                getDepth(ni.getList(), d + 1);
            }
        }
    }
}
