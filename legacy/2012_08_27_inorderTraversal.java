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
    // Given a binary tree, return the inorder traversal of its nodes' values.

    // For example:
    // Given binary tree {1,#,2,3},
    //    1
    //     \
    //      2
    //     /
    //    3
    // return [1,3,2].

    // Note: Recursive solution is trivial, could you do it iteratively?
    
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> ret = new ArrayList<Integer>();
        inorderTraversal(root, ret);
        return ret;
    }
    
    private void inorderTraversal(TreeNode n, ArrayList<Integer> res) {
        if (n == null) return;
        inorderTraversal(n.left, res);
        res.add(n.val);
        inorderTraversal(n.right, res);
    }
}