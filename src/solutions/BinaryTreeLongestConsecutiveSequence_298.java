package solutions;

import datastructure.TreeNode;

/**
 * https://leetcode.com/problems/binary-tree-longest-consecutive-sequence/
 *
 * Given a binary tree, find the length of the longest consecutive
 * sequence path.
 * The path refers to any sequence of nodes from some starting node
 * to any node in the tree along the parent-child connections. The
 * longest consecutive path need to be from parent to child (cannot
 * be the reverse).
 *
 * For example,
 *   1
 *    \
 *     3
 *    / \
 *   2   4
 *        \
 *         5
 * Longest consecutive sequence path is 3-4-5, so return 3.
 *
 *   2
 *    \
 *     3
 *    /
 *   2
  * /
 * 1
 * Longest consecutive sequence path is 2-3,not3-2-1, so return 2.
 */
public class BinaryTreeLongestConsecutiveSequence_298 {
    // Ref: http://www.chenguanghe.com/binary-tree-longest-consecutive-sequence/
    public int longestConsecutive(TreeNode root) {
        longestConsecutive(root, root, 0);
        return maxLen;
    }

    private int maxLen = 0;
    private void longestConsecutive(TreeNode n, TreeNode prev, int len) {
        if (n == null) return;
        if (n.val == prev.val + 1) {
            ++len;
        } else {
            len = 1;
        }
        maxLen = Math.max(maxLen, len);
        longestConsecutive(n.left, n, len);
        longestConsecutive(n.right, n, len);
    }
}
