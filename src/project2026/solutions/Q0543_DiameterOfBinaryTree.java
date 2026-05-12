package project2026.solutions;

import project2026.datastructure.TreeNode;

/*
https://leetcode.com/problems/diameter-of-binary-tree/

Given the root of a binary tree, return the length of the diameter of the tree.

The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.

The length of a path between two nodes is represented by the number of edges between them.



Example 1:
https://assets.leetcode.com/uploads/2021/03/06/diamtree.jpg

Input: root = [1,2,3,4,5]
Output: 3
Explanation: 3 is the length of the path [4,2,1,3] or [5,2,1,3].

Example 2:

Input: root = [1,2]
Output: 1


Constraints:

The number of nodes in the tree is in the range [1, 104].
-100 <= Node.val <= 100

 */
public class Q0543_DiameterOfBinaryTree {
    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return maxDiameter;
    }

    int maxDiameter = 0;
    private int height(TreeNode root) {
        if (root == null) return 0;
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        int diameter = leftHeight + rightHeight;
        maxDiameter = Math.max(maxDiameter, diameter);
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
