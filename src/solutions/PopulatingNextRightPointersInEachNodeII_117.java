package solutions;

import datastructure.TreeLinkNode;

/**
 * https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/
 *
 * Follow up for problem "Populating Next Right Pointers in Each Node".
 * What if the given tree could be any binary tree? Would your previous solution
 * still work?
 *
 * Note:
 * You may only use constant extra space.
 *
 * For example,
 * Given the following binary tree,
 *        1
 *      /  \
 *     2    3
 *    / \    \
 *   4  5     7
 *
 * After calling your function, the tree should look like:
 *        1 -> NULL
 *      /  \
 *     2 -> 3 -> NULL
 *    / \    \
 *   4-> 5 -> 7 -> NULL
 */
public class PopulatingNextRightPointersInEachNodeII_117 {
    public void connect(TreeLinkNode root) {
        while (root != null) {
            TreeLinkNode p = root;
            while (p != null) {
                if (p.left != null && p.right != null) {
                    p.left.next = p.right;
                    p.right.next = getNextLevelFirst(p.next);
                } else if (p.left != null || p.right != null) {
                    getNextLevelFirst(p).next = getNextLevelFirst(p.next);
                }
                p = p.next;
            }
            root = getNextLevelFirst(root);
        }
    }

    private TreeLinkNode getNextLevelFirst(TreeLinkNode n) {
        while (n != null) {
            if (n.left != null) return n.left;
            else if (n.right != null) return n.right;
            n = n.next;
        }
        return null;
    }

    public void connect2(TreeLinkNode root) {
        TreeLinkNode dummy = new TreeLinkNode(-1);
        TreeLinkNode n = dummy;
        while (root != null) {
            if (root.left != null) {
                n.next = root.left;
                n = n.next;
            }
            if (root.right != null) {
                n.next = root.right;
                n = n.next;
            }
            root = root.next;
            if (root == null) {
                n = dummy;
                root = dummy.next;
                dummy.next = null; // to avoid infinite loop
            }
        }
    }
}
