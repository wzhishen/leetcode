package solutions;

import datastructure.TreeNode;

/**
 * https://leetcode.com/problems/sum-root-to-leaf-numbers/
 *
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path
 * could represent a number.
 * An example is the root-to-leaf path 1->2->3 which represents the number 123.
 * Find the total sum of all root-to-leaf numbers.
 * For example,
 *   1
 *  / \
 * 2   3
 * The root-to-leaf path 1->2 represents the number 12.
 * The root-to-leaf path 1->3 represents the number 13.
 * Return the sum = 12 + 13 = 25.
 */
public class SumRootToLeafNumbers_129 {
    public int sumNumbers(TreeNode root) {
        return sumNumbers(root, 0);
    }

    private int sumNumbers(TreeNode n, int sum) {
        if (n == null) return 0;
        sum = sum * 10 + n.val;
        if (n.left == null && n.right == null) return sum;
        return sumNumbers(n.left, sum) + sumNumbers(n.right, sum);
    }
}
