package solutions;

import java.util.HashMap;

import datastructure.TreeNode;

/**
 * https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
 *
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 *
 * Note:
 * You may assume that duplicates do not exist in the tree.
 */
public class ConstructBinaryTreeFromInorderAndPostorderTraversal_106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null || inorder.length != postorder.length) return null;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < inorder.length; ++i) {
            map.put(inorder[i], i);
        }
        return buildTree(inorder, postorder, map, 0, inorder.length - 1, 0, postorder.length - 1);
    }

    private TreeNode buildTree(int[] inorder, int[] postorder, HashMap<Integer, Integer> map, int l1, int h1, int l2, int h2) {
        if (l1 > h1 || l2 > h2) return null;
        int val = postorder[h2];
        int p = map.get(val);
        TreeNode n = new TreeNode(val);
        n.left = buildTree(inorder, postorder, map, l1, p - 1, l2, l2 + p - l1 - 1);
        n.right = buildTree(inorder, postorder, map, p + 1, h1, l2 + p - l1, h2 - 1);
        return n;
    }
}
