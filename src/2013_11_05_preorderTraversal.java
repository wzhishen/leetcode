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
    // Given a binary tree, return the preorder traversal of its nodes' values.

    // For example:
    // Given binary tree {1,#,2,3},
    //    1
    //     \
    //      2
    //     /
    //    3
    // return [1,2,3].

    // Note: Recursive solution is trivial, could you do it iteratively?
    
    // iterative: just do DFS
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        ArrayList<Integer> ret = new ArrayList<Integer>();
        if (root == null) return ret;
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode n = stack.pop();
            ret.add(n.val);
            if (n.right != null) stack.push(n.right);
            if (n.left != null) stack.push(n.left);
        }
        return ret;
    }
}