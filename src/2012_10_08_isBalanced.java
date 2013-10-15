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
    // Given a binary tree, determine if it is height-balanced.

    // For this problem, a height-balanced binary tree is defined as a binary tree 
    // in which the depth of the two subtrees of every node never differ by more than 1.

    public boolean isBalanced(TreeNode root) {
        return height(root) != -1;
    }
    
    private int height(TreeNode n) {
        if (n == null) return 0;
        int leftHeight = height(n.left);
        int rightHeight = height(n.right);
        if (leftHeight == -1 || rightHeight == -1) return -1;
        if (Math.abs(leftHeight - rightHeight) > 1) return -1;
        return Math.max(leftHeight, rightHeight) + 1;
    }
}