package solutions;

import datastructure.TreeNode;

/**
 * https://leetcode.com/problems/count-complete-tree-nodes/
 *
 * Given a complete binary tree, count the number of nodes.
 * Definition of a complete binary tree from Wikipedia:
 * In a complete binary tree every level, except possibly the last, is completely
 * filled, and all nodes in the last level are as far left as possible. It can
 * have between 1 and 2^h nodes inclusive at the last level h.
 */
public class CountCompleteTreeNodes_222 {
    /* Ref: http://bookshadow.com/weblog/2015/06/06/leetcode-count-complete-tree-nodes/
     * O(h^2) time, O(h) space for call stack, h is the height of tree
     */
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        TreeNode l = root, r = root;
        int h = 0;
        while (l != null && r != null) {
            l = l.left; r = r.right;
            ++h;
        }
        if (l == null && r == null) return (1 << h) - 1; // # of nodes of a full binary tree is 2^h-1
        else return 1 + countNodes(root.left) + countNodes(root.right);
    }
}
