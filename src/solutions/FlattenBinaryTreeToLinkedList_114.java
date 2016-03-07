package solutions;

import datastructure.TreeNode;

/**
 * https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
 *
 * Given a binary tree, flatten it to a linked list in-place.
 *
 * For example,
 * Given
 *        1
 *       / \
 *      2   5
 *     / \   \
 *    3   4   6
 * The flattened tree should look like:
 *  1
 *   \
 *    2
 *     \
 *      3
 *       \
 *        4
 *         \
 *          5
 *           \
 *            6
 * Hints:
 * If you notice carefully in the flattened tree, each node's right
 * child points to the next node of a pre-order traversal.
 */
public class FlattenBinaryTreeToLinkedList_114 {
    /* Reference:
     * http://bangbingsyb.blogspot.com/2014/11/leetcode-flatten-binary-tree-to-linked.html
     */
    public void flatten(TreeNode root) {
        flattenHelper(root);
    }

    private TreeNode flattenHelper(TreeNode root) {
        if (root == null) return null;
        TreeNode leftTail = flattenHelper(root.left);
        TreeNode rightTail = flattenHelper(root.right);
        if (leftTail != null) {
            leftTail.right = root.right;
            root.right = root.left;
            root.left = null;
        }

        if (rightTail != null) return rightTail;
        else if (leftTail != null) return leftTail;
        else return root;
    }
}
