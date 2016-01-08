package solutions;

import java.util.LinkedList;

import datastructure.TreeNode;

/**
 * https://leetcode.com/problems/symmetric-tree/
 *
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric
 * around its center).
 *
 * For example, this binary tree is symmetric:
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 * But the following is not:
 *   1
 *  / \
 * 2   2
 *  \   \
 *   3    3
 *
 * Note:
 * Bonus points if you could solve it both recursively and iteratively.
 */
public class SymmetricTree_101 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isSubtreeSymmetric(root.left, root.right);
    }

    private boolean isSubtreeSymmetric(TreeNode n1, TreeNode n2) {
        if (n1 == null && n2 == null) return true;
        if (n1 == null || n2 == null) return false;
        if (n1.val != n2.val) return false;
        return isSubtreeSymmetric(n1.left, n2.right) &&
               isSubtreeSymmetric(n1.right, n2.left);
    }

    public boolean isSymmetricIterative(TreeNode root) {
        if (root == null) return true;
        LinkedList<TreeNode> leftNodes = new LinkedList<TreeNode>();
        LinkedList<TreeNode> rightNodes = new LinkedList<TreeNode>();
        leftNodes.add(root.left);
        rightNodes.add(root.right);
        while (!leftNodes.isEmpty() && !rightNodes.isEmpty()) {
            TreeNode leftNode = leftNodes.remove();
            TreeNode rightNode = rightNodes.remove();
            if (leftNode == null && rightNode == null) continue;
            if (leftNode == null || rightNode == null) return false;
            if (leftNode.val != rightNode.val) return false;
            leftNodes.add(leftNode.left);
            leftNodes.add(leftNode.right);
            rightNodes.add(rightNode.right);
            rightNodes.add(rightNode.left);
        }
        return true;
    }
}
