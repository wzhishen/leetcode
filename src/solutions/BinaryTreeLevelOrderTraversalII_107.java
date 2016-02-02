package solutions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import datastructure.TreeNode;

/**
 * https://leetcode.com/problems/binary-tree-level-order-traversal-ii/
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values.
 * (ie, from left to right, level by level from leaf to root).
 *
 * For example:
 * Given binary tree {3,9,20,#,#,15,7},
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its bottom-up level order traversal as:
 * [
 *   [15,7]
 *   [9,20],
 *   [3],
 * ]
 */
public class BinaryTreeLevelOrderTraversalII_107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
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
            result.add(0, level);
        }
        return result;
    }

    public List<List<Integer>> levelOrderBottom2(TreeNode root) {
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
            if (!level.isEmpty()) result.add(0, level);
            prev = curr;
            curr = new ArrayList<TreeNode>();
        }
        return result;
    }
}
