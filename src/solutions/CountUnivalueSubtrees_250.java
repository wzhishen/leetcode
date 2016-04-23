package solutions;

import datastructure.TreeNode;

/**
 * https://leetcode.com/problems/count-univalue-subtrees/
 *
 * Given a binary tree, count the number of uni-value subtrees.
 * A Uni-value subtree means all nodes of the subtree have the same value.
 *
 * For example:
 * Given binary tree,
 *         5
 *        / \
         1   5
 *      / \   \
 *     5   5   5
 * return 4.
 */
public class CountUnivalueSubtrees_250 {
    // count while checking
    public int countUnivalSubtrees(TreeNode root) {
        int[] cnt = new int[1];
        isUnivalue(root, cnt);
        return cnt[0];
    }

    private boolean isUnivalue(TreeNode n, int[] cnt) {
        if (n == null) return true;
        if (isUnivalue(n.left, cnt) & // do not short circuit
            isUnivalue(n.right, cnt) &&
            (n.left == null || n.left.val == n.val) &&
            (n.right == null || n.right.val == n.val)) {
               ++cnt[0];
               return true;
           }
        return false;
    }

    // naive recursion
    public int countUnivalSubtrees2(TreeNode root) {
        if (root == null) return 0;
        return (isUnivalue(root, root.val) ? 1 : 0) + countUnivalSubtrees(root.left) + countUnivalSubtrees(root.right);
    }

    private boolean isUnivalue(TreeNode n, int v) {
        if (n == null) return true;
        if (n.val != v) return false;
        return isUnivalue(n.left, v) && isUnivalue(n.right, v);
    }
}
