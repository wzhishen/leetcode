/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    // Given preorder and inorder traversal of a tree, construct the binary tree.

    // Note:
    // You may assume that duplicates do not exist in the tree.
    
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTreeHelper(preorder, inorder, 0, inorder.length - 1);
    }
    
    static int preIndex = 0;
    
    private static TreeNode buildTreeHelper(int[] preorder, int[] inorder, int inIndexStart, int inIndexEnd) {
        if (preIndex > preorder.length - 1) return null;
        if (inIndexStart > inIndexEnd) return null;
        int val = preorder[preIndex++];
        TreeNode node = new TreeNode(val);
        if (inIndexStart == inIndexEnd) return node;
        int inIndex = searchInorderIndex(inorder, val);
        node.left = buildTreeHelper(preorder, inorder, inIndexStart, inIndex - 1);
        node.right = buildTreeHelper(preorder, inorder, inIndex + 1, inIndexEnd);
        return node;
    }
    
    private static int searchInorderIndex(int[] inorder, int n) {
        for (int i = 0; i < inorder.length; ++i) {
            if (inorder[i] == n) return i;
        }
        return -1;
    }
}