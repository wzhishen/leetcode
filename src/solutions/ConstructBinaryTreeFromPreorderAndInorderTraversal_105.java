package solutions;

import java.util.HashMap;

import datastructure.TreeNode;

/**
 * https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 *
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 *
 * Note:
 * You may assume that duplicates do not exist in the tree.
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal_105 {
    /*
     * Build an inverted index for inorder list to reduce access time, total time complexity is:
     * T(n) = 2(n/2) + C => T(n) = O(n)
     * Otherwise it will be
     * T(n) = 2(n/2) + O(n) => T(n) = O(n log n)
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length != inorder.length) return null;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < inorder.length; ++i) {
            map.put(inorder[i], i);
        }
        return buildTree(preorder, inorder, map, 0, inorder.length - 1, 0, preorder.length - 1);
    }

    private TreeNode buildTree(int[] preorder, int[] inorder, HashMap<Integer, Integer> map, int l1, int h1, int l2, int h2) {
        if (l1 > h1 || l2 > h2) return null;
        int val = preorder[l1];
        int p = map.get(val); // O(1) access time
        TreeNode n = new TreeNode(val);
        n.left = buildTree(preorder, inorder, map, l1 + 1, l1 + p - l2, l2, p - 1);
        n.right = buildTree(preorder, inorder, map, l1 + p - l2 + 1, h1, p + 1, h2);
        return n;
    }
}
