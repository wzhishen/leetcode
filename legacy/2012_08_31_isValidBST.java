/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    // Given a binary tree, determine if it is a valid binary search tree (BST).

    // Assume a BST is defined as follows:

    // The left subtree of a node contains only nodes with keys less than the node's key.
    // The right subtree of a node contains only nodes with keys greater than the node's key.
    // Both the left and right subtrees must also be binary search trees.
    
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    private boolean isValidBST(TreeNode n, int min, int max) {
        if (n == null) return true;
        return n.val > min && n.val < max &&
            isValidBST(n.left, min, n.val) &&
            isValidBST(n.right, n.val, max);
    }
}