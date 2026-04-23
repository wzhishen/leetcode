package project2026.solutions;

import project2026.datastructure.TreeNode;

/*
https://leetcode.com/problems/balanced-binary-tree/description/

Given a binary tree, determine if it is height-balanced.



Example 1:
https://assets.leetcode.com/uploads/2020/10/06/balance_1.jpg

Input: root = [3,9,20,null,null,15,7]
Output: true

Example 2:
https://assets.leetcode.com/uploads/2020/10/06/balance_2.jpg

Input: root = [1,2,2,3,3,null,null,4,4]
Output: false
Example 3:

Input: root = []
Output: true


Constraints:

The number of nodes in the tree is in the range [0, 5000].
-104 <= Node.val <= 104

 */
public class Q0110_BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        return height(root) != -1;
    }
    private int height(TreeNode root) {
        if (root == null) return 0;
        int leftHeight = height(root.left);
        if (leftHeight == -1) return -1;
        int rightHeight = height(root.right);
        if (rightHeight == -1) return -1;
        if (Math.abs(leftHeight - rightHeight) > 1) return -1;
        return Math.max(leftHeight, rightHeight) + 1;
    }

    // public boolean isBalanced(TreeNode root) {
    //     height(root);
    //     return isBalanced;
    // }
    // boolean isBalanced = true;
    // private int height(TreeNode root) {
    //     if (root == null) return 0;
    //     int leftHeight = height(root.left);
    //     int rightHeight = height(root.right);
    //     if (Math.abs(leftHeight - rightHeight) > 1) isBalanced = false;
    //     return Math.max(leftHeight, rightHeight) + 1;
    // }
}
