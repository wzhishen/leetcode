package solutions;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import datastructure.TreeNode;

/**
 * https://leetcode.com/problems/binary-tree-postorder-traversal/
 *
 * Given a binary tree, return the postorder traversal of its nodes' values.
 *
 * For example:
 * Given binary tree {1,#,2,3},
 *    1
 *     \
 *      2
 *     /
 *    3
 * return [3,2,1].
 *
 * Note: Recursive solution is trivial, could you do it iteratively?
 */
public class BinaryTreePostorderTraversal_145 {
    // O(n) time, O(log n) space
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> res = new LinkedList<Integer>();
        if (root == null) return res;
        Stack<TreeNode> s = new Stack<TreeNode>();
        s.add(root);
        while (!s.isEmpty()) {
            TreeNode p = s.pop();
            res.addFirst(p.val);
            if (p.left != null) s.push(p.left);
            if (p.right != null) s.push(p.right);
        }
        return res;
    }
}
