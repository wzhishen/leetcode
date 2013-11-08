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
    // Given a binary tree, return the postorder traversal of its nodes' values.

    // For example:
    // Given binary tree {1,#,2,3},
    //    1
    //     \
    //      2
    //     /
    //    3
    // return [3,2,1].

    // Note: Recursive solution is trivial, could you do it iteratively?
    
    // iterative: just do DFS ...again
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> ret = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        if (root == null) return ret;
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode n = stack.pop();
            ret.add(0, n.val);
            if (n.left != null) stack.push(n.left);
            if (n.right != null) stack.push(n.right);
        }
        return ret;
    }
}