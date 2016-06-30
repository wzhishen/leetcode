package solutions;

import java.util.LinkedList;
import java.util.Queue;

import datastructure.TreeNode;

/**
 * https://leetcode.com/problems/invert-binary-tree/
 *
 * Invert a binary tree.
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * to
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 */
public class InvertBinaryTree_226 {
    // DFS
    public TreeNode invertTree(TreeNode root) {
        invert(root);
        return root;
    }

    private void invert(TreeNode root) {
        if (root == null) return;
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        invert(root.left);
        invert(root.right);
    }

    // Shorter DFS
    public TreeNode invertTree2(TreeNode root) {
        if (root == null) return null;
        TreeNode left = root.left, right = root.right;
        root.left = invertTree(right);
        root.right = invertTree(left);
        return root;
    }

    //BFS
    public TreeNode invertTree3(TreeNode root) {
        if (root == null) return null;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode n = q.remove();
            TreeNode tmp = n.left;
            n.left = n.right;
            n.right = tmp;
            if (n.left != null) q.add(n.left);
            if (n.right != null) q.add(n.right);
        }
        return root;
    }
}
