package solutions;

import datastructure.TreeNode;

/**
 * https://leetcode.com/problems/largest-bst-subtree/
 *
 * Given a binary tree, find the largest subtree which is a Binary
 * Search Tree (BST), where largest means subtree with largest
 * number of nodes in it.
 *
 * Note:
 * A subtree must include all of its descendants.
 * Here's an example:
 *     10
 *    / \
 *   5  15
 *  / \   \
 * 1   8   7
 * The Largest BST Subtree in this case is the highlighted one.
 * The return value is the subtree's size, which is 3.
 *
 * Hint:
 * You can recursively use algorithm similar to 98. Validate Binary
 * Search Tree at each node of the tree, which will result in O(nlogn)
 * time complexity.
 *
 * Follow up:
 * Can you figure out ways to solve it with O(n) time complexity?
 */
public class LargestBSTSubtree_333 {
    public int largestBSTSubtree(TreeNode root) {
        return helper(root)[3];
    }

    /*
     * Emit [min, max, isBST, size]
     *
     * min: min value in current BST
     * max: max value in current BST
     * isBST: 1 -> current subtree is a BST
     *        0 -> current subtree is not a BST
     * size: largest BST size
     */
    private int[] helper(TreeNode n) {
        int[] res = {Integer.MAX_VALUE, Integer.MIN_VALUE, 1, 0};
        if (n == null) return res;

        int[] left = helper(n.left);
        int[] right = helper(n.right);

        if (n.val > left[1] && n.val < right[0] && left[2] == 1 && right[2] == 1) {
            res[0] = Math.min(left[0], n.val);
            res[1] = Math.max(right[1], n.val);
            res[3] = 1 + left[3] + right[3];
        } else {
            res[2] = 0;
            res[3] = Math.max(left[3], right[3]);
        }
        return res;
    }
}
