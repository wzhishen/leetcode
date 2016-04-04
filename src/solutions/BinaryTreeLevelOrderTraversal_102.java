package solutions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import datastructure.TreeNode;

/**
 * https://leetcode.com/problems/binary-tree-level-order-traversal/
 *
 * Given a binary tree, return the level order traversal of its nodes' values.
 * (ie, from left to right, level by level).
 *
 * For example:
 * Given binary tree {3,9,20,#,#,15,7},
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its level order traversal as:
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 */
public class BinaryTreeLevelOrderTraversal_102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null) return result;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        while (!q.isEmpty()) {
            List<Integer> level = new ArrayList<Integer>();
            final int SIZE = q.size();
            for (int i = 0; i < SIZE; ++i) {
                TreeNode n = q.remove();
                level.add(n.val);
                if (n.left != null) q.add(n.left);
                if (n.right != null) q.add(n.right);
            }
            result.add(level);
        }
        return result;
    }

    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null) return result;
        List<TreeNode> prev = new ArrayList<TreeNode>();
        List<TreeNode> curr = new ArrayList<TreeNode>();
        List<Integer> level = new ArrayList<Integer>();
        prev.add(root);
        level.add(root.val);
        result.add(level);
        while (!prev.isEmpty()) {
            level = new ArrayList<Integer>();
            for (TreeNode p : prev) {
                if (p.left != null) {
                    curr.add(p.left);
                    level.add(p.left.val);
                }
                if (p.right != null) {
                    curr.add(p.right);
                    level.add(p.right.val);
                }
            }
            if (!level.isEmpty()) result.add(level);
            prev = curr;
            curr = new ArrayList<TreeNode>();
        }
        return result;
    }
}
