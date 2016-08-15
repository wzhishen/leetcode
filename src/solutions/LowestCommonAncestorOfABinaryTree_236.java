package solutions;

import datastructure.TreeNode;

/**
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
 *
 * Given a binary tree, find the lowest common ancestor (LCA) of two given
 * nodes in the tree. According to the definition of LCA on Wikipedia: "The
 * lowest common ancestor is defined between two nodes v and w as the lowest
 * node in T that has both v and w as descendants (where we allow a node to
 * be a descendant of itself)."
 *
 *       _______3______
 *      /              \
 *   ___5__          ___1__
 *  /      \        /      \
 *  6      _2       0       8
 *        /  \
 *        7   4
 * For example, the lowest common ancestor (LCA) of nodes 5 and 1 is 3.Another
 * example is LCA of nodes 5 and 4 is 5, since a node can be a descendant of
 * itself according to the LCA definition.
 */
public class LowestCommonAncestorOfABinaryTree_236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (root == p || root == q) return root;
        TreeNode l = lowestCommonAncestor(root.left, p, q);
        TreeNode r = lowestCommonAncestor(root.right, p, q);
        if (l != null && r != null) {
            return root;
        } else if (l != null) {
            return l;
        } else {
            return r;
        }
    }

    // Follow up: what if p, q may not be in the same tree?
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        count(root, p, q);
        return cnt != 2 ? null : helper(root, p, q);
    }

    int cnt = 0;
    private void count(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return;
        if (root == p) ++cnt;
        if (root == q) ++cnt;
        count(root.left, p, q);
        count(root.right, p, q);
    }

    private TreeNode helper(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        TreeNode left = helper(root.left, p, q);
        TreeNode right = helper(root.right, p, q);
        if (left != null && right != null) return root;
        else if (left != null) return left;
        else return right;
    }
}
