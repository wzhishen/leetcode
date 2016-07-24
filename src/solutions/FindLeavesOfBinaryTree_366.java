package solutions;

import java.util.ArrayList;
import java.util.List;

import datastructure.TreeNode;

/**
 * https://leetcode.com/problems/find-leaves-of-binary-tree/
 *
 * Given a binary tree, collect a tree's nodes as if you were doing this:
 * Collect and remove all leaves, repeat until the tree is empty.
 *
 * Example:
 * Given binary tree 
 *          1
 *         / \
 *        2   3
 *       / \
 *      4   5
 * Returns [4, 5, 3], [2], [1].
 *
 * Explanation:
 * 1. Removing the leaves [4, 5, 3] would result in this tree:
 *          1
 *         /
 *        2
 * 2. Now removing the leaf [2] would result in this tree:
 *          1
 * 3. Now removing the leaf [1] would result in the empty tree:
 *          []
 *
 * Returns [4, 5, 3], [2], [1].
 */
public class FindLeavesOfBinaryTree_366 {
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        while (root != null) {
            List<Integer> list = new ArrayList<>();
            if (isLeaf(root, list)) root = null;
            res.add(list);
        }
        return res;
    }

    private boolean isLeaf(TreeNode n, List<Integer> list) {
        if (n == null) return false;
        if (n.left == null && n.right == null) {
            list.add(n.val);
            return true;
        }
        if (isLeaf(n.left, list)) n.left = null;
        if (isLeaf(n.right, list)) n.right = null;
        return false;
    }
}
