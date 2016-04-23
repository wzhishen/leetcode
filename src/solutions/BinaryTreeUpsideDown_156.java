package solutions;

import datastructure.TreeNode;

/**
 * https://leetcode.com/problems/binary-tree-upside-down/
 *
 * Given a binary tree where all the right nodes are either leaf nodes
 * with a sibling (a left node that shares the same parent node) or
 * empty, flip it upside down and turn it into a tree where the original
 * right nodes turned into left leaf nodes. Return the new root.
 * @version Apr 6, 2016
 */
public class BinaryTreeUpsideDown_156 {
    /* Key:
     * curr.left = parent.right
     * curr.right = parent
     *
     * Ref:
     * http://www.danielbit.com/blog/puzzle/leetcode/leetcode-binary-tree-upside-down
     */
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        TreeNode n = root, parent = null, parentRight = null;
        while (n != null) {
            TreeNode next = n.left;
            n.left = parentRight;
            parentRight = n.right;
            n.right = parent;
            parent = n;
            n = next;
        }
        return parent;
    }

    public TreeNode upsideDownBinaryTreeRecursive(TreeNode root) {
        if (root == null) return null;
        TreeNode n = root.left;
        TreeNode newRoot = upsideDownBinaryTreeRecursive(n);
        if (n == null) {
            return root;
        } else {
            n.left = root.right;
            n.right = root;
            root.left = null;
            root.right = null;
            return newRoot;
        }
    }
}
