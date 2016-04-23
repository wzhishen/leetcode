package solutions;

import java.util.Stack;

import datastructure.TreeNode;

/**
 * https://leetcode.com/problems/inorder-successor-in-bst/
 *
 * Given a binary search tree and a node in it, find the in-order
 * successor of that node in the BST.
 * Note: If the given node has no in-order successor in the tree,
 * return null.
 */
public class InorderSuccessorInBST_285 {
    // Optimized solution for BST
    // Ref: https://leetcode.com/discuss/77805/java-5ms-short-code-with-explanations
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null || p == null) return null;
        TreeNode res = null;
        while (root != null) {
            if (p.val < root.val) {
                res = root;
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return res;
    }

    // Generalized solution that works for any binary tree
    public TreeNode inorderSuccessor2(TreeNode root, TreeNode p) {
        if (root == null || p == null) return null;

        Stack<TreeNode> s = new Stack<TreeNode>();
        TreeNode prev = null, n = root;
        while (!s.isEmpty() || n != null) {
            while (n != null) {
                s.push(n);
                n = n.left;
            }
            TreeNode curr = s.pop();
            if (prev == p) return curr;
            prev = curr;
            n = curr.right;
        }
        return null;
    }
}
