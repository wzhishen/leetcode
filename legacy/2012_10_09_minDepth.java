/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    // Given a binary tree, find its minimum depth.

    // The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
    
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        int leftDepth = minDepth(root.left);
        int rightDepth = minDepth(root.right);
        if (leftDepth == 0) return rightDepth + 1;
        else if (rightDepth == 0) return leftDepth + 1;
        else return Math.min(leftDepth, rightDepth) + 1;
    }
}