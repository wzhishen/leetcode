package solutions;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import datastructure.TreeNode;

/**
 * https://leetcode.com/problems/binary-tree-preorder-traversal/
 *
 * Given a binary tree, return the preorder traversal of its nodes' values.
 *
 * For example:
 * Given binary tree {1,#,2,3},
 *    1
 *     \
 *      2
 *     /
 *    3
 * return [1,2,3].
 *
 * Note: Recursive solution is trivial, could you do it iteratively?
 */
public class BinaryTreePreorderTraversal_144 {
    // O(n) time, O(log n) space
    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if (root == null) return res;
        Stack<TreeNode> s = new Stack<TreeNode>();
        s.add(root);
        while (!s.isEmpty()) {
            TreeNode p = s.pop();
            res.add(p.val);
            if (p.right != null) s.push(p.right);
            if (p.left != null) s.push(p.left);
        }
        return res;
    }
}
