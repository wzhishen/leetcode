package solutions;

import datastructure.TreeNode;

/**
 * https://leetcode.com/problems/closest-binary-search-tree-value/
 *
 * Given a non-empty binary search tree and a target value, find the
 * value in the BST that is closest to the target.
 *
 * Note:
 * 1. Given target value is a floating point.
 * 2. You are guaranteed to have only one unique value in the BST that
 * is closest to the target.
 */
public class ClosestBinarySearchTreeValue_270 {
    // closest value must exist along the root-to-leaf path
    public int closestValue(TreeNode n, double target) {
        int closest = n.val;
        while (n != null) {
            if (Math.abs(target - n.val) < Math.abs(target - closest)) closest = n.val;

            if (target > n.val) n = n.right;
            else n = n.left;
        }
        return closest;
    }
}
