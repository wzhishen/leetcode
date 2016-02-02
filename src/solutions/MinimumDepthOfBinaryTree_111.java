package solutions;

import datastructure.TreeNode;

/**
 * https://leetcode.com/problems/minimum-depth-of-binary-tree/
 *
 * Given a binary tree, find its minimum depth.
 * The minimum depth is the number of nodes along the shortest path from the
 * root node down to the nearest leaf node.
 */
public class MinimumDepthOfBinaryTree_111 {
    public int minDepth(TreeNode root) {
        return root == null ? 0 : minDepthHelper(root);
    }

    private int minDepthHelper(TreeNode root) {
        if (root == null) return Integer.MAX_VALUE;
        if (root.left == null && root.right == null) return 1;
        return 1 + Math.min(minDepthHelper(root.left), minDepthHelper(root.right));
    }
}
