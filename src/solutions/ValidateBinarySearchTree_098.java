package solutions;

import datastructure.TreeNode;

/**
 * https://leetcode.com/problems/validate-binary-search-tree/
 *
 * Given a binary tree, determine if it is a valid binary search tree
 * (BST).
 * Assume a BST is defined as follows:
 * 1. The left subtree of a node contains only nodes with keys less than
 * the node's key.
 * 2. The right subtree of a node contains only nodes with keys greater
 * than the node's key.
 * 3. Both the left and right subtrees must also be binary search trees.
 */
public class ValidateBinarySearchTree_098 {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Integer.MIN_VALUE - 1l, Integer.MAX_VALUE + 1l);
    }

    private boolean isValidBST(TreeNode n, long min, long max) {
        if (n == null) return true;
        return n.val > min && n.val < max &&
               isValidBST(n.left, min, n.val) && isValidBST(n.right, n.val, max);
    }

    // Or can use null as sentinel instead of MAX_VALUE, MIN_VALUE
    public boolean isValidBST2(TreeNode root) {
        return isValidBST2(root, null, null);
    }

    private boolean isValidBST2(TreeNode n, Integer min, Integer max) {
        if (n == null) return true;
        return (min == null || n.val > min) && (max == null || n.val < max) &&
               isValidBST2(n.left, min, n.val) && isValidBST2(n.right, n.val, max);
    }
}
