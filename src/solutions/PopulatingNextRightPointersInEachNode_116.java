package solutions;

import datastructure.TreeLinkNode;

/**
 * https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
 *
 * Given a binary tree
 *    struct TreeLinkNode {
 *      TreeLinkNode *left;
 *      TreeLinkNode *right;
 *      TreeLinkNode *next;
 *    }
 * Populate each next pointer to point to its next right node. If there is no
 * next right node, the next pointer should be set to NULL.
 * Initially, all next pointers are set to NULL.
 *
 * Note:
 * 1. You may only use constant extra space.
 * 2. You may assume that it is a perfect binary tree (ie, all leaves are at
 * the same level, and every parent has two children).
 *
 * For example,
 * Given the following perfect binary tree,
 *        1
 *      /  \
 *     2    3
 *    / \  / \
 *   4  5  6  7
 *
 * After calling your function, the tree should look like:
 *        1 -> NULL
 *      /  \
 *     2 -> 3 -> NULL
 *    / \  / \
 *   4->5->6->7 -> NULL
 */
public class PopulatingNextRightPointersInEachNode_116 {
    /* Key:
     * root.left.next = root.right
     * root.right.next = root.next.left
     */

    // recursive
    public void connect(TreeLinkNode root) {
        if (root == null) return;
        if (root.left == null && root.right == null) return;
        root.left.next = root.right;
        if (root.next != null) root.right.next = root.next.left;
        connect(root.left);
        connect(root.right);
    }

    // iterative
    public void connect2(TreeLinkNode root) {
        while (root != null) {
            TreeLinkNode p = root;
            while (p != null) {
                if (p.left != null && p.right != null) {
                    p.left.next = p.right;
                    p.right.next = p.next == null ? null : p.next.left;
                }
                p = p.next;
            }
            root = root.left;
        }
    }
}
