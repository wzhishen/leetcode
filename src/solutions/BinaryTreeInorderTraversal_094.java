package solutions;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import datastructure.TreeNode;

/**
 * https://leetcode.com/problems/binary-tree-inorder-traversal/
 *
 * Given a binary tree, return the inorder traversal of its nodes' values.
 *
 * For example:
 * Given binary tree {1,#,2,3},
 *    1
 *     \
 *      2
 *     /
 *    3
 * return [1,3,2].
 *
 * Note: Recursive solution is trivial, could you do it iteratively?
 */
public class BinaryTreeInorderTraversal_094 {
    /* Reference: https://en.wikipedia.org/wiki/Tree_traversal
     * O(n) time, O(log n) space
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        Stack<TreeNode> s = new Stack<TreeNode>();

        TreeNode p = root;
        while (p != null || !s.isEmpty()) {
            if (p != null) {
                s.push(p);
                p = p.left;
            } else {
                p = s.pop();
                res.add(p.val);
                p = p.right;
            }
        }
        return res;
    }
}
