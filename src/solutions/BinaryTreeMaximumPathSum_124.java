package solutions;

import datastructure.TreeNode;

/**
 * https://leetcode.com/problems/binary-tree-maximum-path-sum/
 *
 * Given a binary tree, find the maximum path sum.
 * For this problem, a path is defined as any sequence of nodes from some
 * starting node to any node in the tree along the parent-child connections.
 * The path does not need to go through the root.
 *
 * For example:
 * Given the below binary tree,
 *      1
 *     / \
 *    2   3
 * Return 6.
 */
public class BinaryTreeMaximumPathSum_124 {
    /* Need to consider two types of paths:
     * 1. pathSingle: path goes from a subtree thru current node to its parents
     * 2. pathAcross: path goes from one subtree thru current node to another subtree
     *
     * Use a global to update max path at each recursion level.
     */
    private int maxPathSumHelper(TreeNode root, int[] res) {
        if (root == null) return 0;
        int pathSingleLeft = maxPathSumHelper(root.left, res);
        int pathSingleRight = maxPathSumHelper(root.right, res);

        int pathSingle = Math.max(root.val, root.val + Math.max(pathSingleLeft, pathSingleRight));
        int pathAcross = root.val + pathSingleLeft + pathSingleRight;

        res[0] = Math.max(res[0], Math.max(pathSingle, pathAcross));
        return pathSingle;
    }

    public int maxPathSum(TreeNode root) {
        int[] res = {Integer.MIN_VALUE};
        maxPathSumHelper(root, res);
        return res[0];
    }
}
