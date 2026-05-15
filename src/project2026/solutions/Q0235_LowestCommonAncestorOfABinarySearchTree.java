package project2026.solutions;

import project2026.datastructure.TreeNode;

/*
https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/description/

Given a binary search tree (BST), find the lowest common ancestor (LCA) node of two given nodes in the BST.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”



Example 1:
https://assets.leetcode.com/uploads/2018/12/14/binarysearchtree_improved.png

Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
Output: 6
Explanation: The LCA of nodes 2 and 8 is 6.

Example 2:
https://assets.leetcode.com/uploads/2018/12/14/binarysearchtree_improved.png

Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4

Output: 2
Explanation: The LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself according to the LCA definition.

Example 3:

Input: root = [2,1], p = 2, q = 1
Output: 2


Constraints:

The number of nodes in the tree is in the range [2, 105].
-109 <= Node.val <= 109
All Node.val are unique.
p != q
p and q will exist in the BST.

 */
public class Q0235_LowestCommonAncestorOfABinarySearchTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (p.val <= root.val && root.val <= q.val || q.val <= root.val && root.val <= p.val) return root;
        if (root.val < p.val && root.val < q.val) return lowestCommonAncestor(root.right, p, q);
        if (root.val > p.val && root.val > q.val) return lowestCommonAncestor(root.left, p, q);
        return null; // Unreachable
    }

     public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
         if (root == null) return null;
         if (root.val < p.val && root.val < q.val) return lowestCommonAncestor2(root.right, p, q);
         if (root.val > p.val && root.val > q.val) return lowestCommonAncestor2(root.left, p, q);
         return root;
     }

     public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (root == p || root == q) return root;
        if (p.val > q.val) return lowestCommonAncestor3(root, q, p);
        if (p.val < root.val && root.val < q.val) return root;
        if (p.val < root.val && q.val < root.val) return lowestCommonAncestor3(root.left, p, q);
        if (p.val > root.val && q.val > root.val) return lowestCommonAncestor3(root.right, p, q);
        return null;
    }
}
