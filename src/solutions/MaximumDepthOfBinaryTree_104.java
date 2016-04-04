package solutions;

import datastructure.TreeNode;

/**
 * https://leetcode.com/problems/maximum-depth-of-binary-tree/
 *
 * Given a binary tree, find its maximum depth.
 *
 * The maximum depth is the number of nodes along the longest path from
 * the root node down to the farthest leaf node.
 */
public class MaximumDepthOfBinaryTree_104 {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}
