package solutions;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import datastructure.TreeNode;

/**
 * https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
 *
 * Given a binary tree, return the zigzag level order traversal of its nodes'
 * values. (ie, from left to right, then right to left for the next level and
 * alternate between).
 *
 * For example:
 * Given binary tree {3,9,20,#,#,15,7},
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its zigzag level order traversal as:
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 */
public class BinaryTreeZigzagLevelOrderTraversal_103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null) return result;
        Stack<TreeNode> prev = new Stack<TreeNode>();
        Stack<TreeNode> curr = new Stack<TreeNode>();
        prev.add(root);
        boolean reversed = true;
        while (!prev.isEmpty()) {
            List<Integer> level = new ArrayList<Integer>();
            while (!prev.isEmpty()) {
                TreeNode p = prev.pop();
                level.add(p.val);
                if (reversed) {
                    if (p.left != null) curr.push(p.left);
                    if (p.right != null) curr.push(p.right);
                } else {
                    if (p.right != null) curr.push(p.right);
                    if (p.left != null) curr.push(p.left);
                }
            }
            // No need to null check level since level should always be non empty.
            result.add(level);
            // No need to create new stack for curr since prev is already empty, so just reuse prev.
            Stack<TreeNode> tmp = prev;
            prev = curr;
            curr = tmp;
            reversed = !reversed;
        }
        return result;
    }
}
