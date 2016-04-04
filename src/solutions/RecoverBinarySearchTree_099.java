package solutions;

import datastructure.TreeNode;

/**
 * https://leetcode.com/problems/recover-binary-search-tree/
 *
 * Two elements of a binary search tree (BST) are swapped by mistake.
 * Recover the tree without changing its structure.
 *
 * Note:
 * A solution using O(n) space is pretty straight forward. Could you devise
 * a constant space solution?
 */
public class RecoverBinarySearchTree_099 {
    /*
     * Traverse inorder, catch two inconsistent nodes,
     * and swap them.
     * Ref: http://www.cnblogs.com/yuzhangcmu/p/4208319.html
     */
    TreeNode small = null, big = null, prev = null;
    public void recoverTree(TreeNode root) {
        search(root);
        if (small != null && big != null) {
            int tmp = small.val;
            small.val = big.val;
            big.val = tmp;
        }
    }

    private void search(TreeNode n) {
        if (n == null) return;
        search(n.left);
        if (prev != null && prev.val > n.val) {
            if (big == null) {
                big = prev;
            }
            small = n;
        }
        prev = n;
        search(n.right);
    }
}
