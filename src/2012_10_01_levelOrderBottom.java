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
    // Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

    // For example:
    // Given binary tree {3,9,20,#,#,15,7},
    //     3
    //    / \
    //   9  20
    //     /  \
    //    15   7
    // return its bottom-up level order traversal as:
    // [
    //   [15,7]
    //   [9,20],
    //   [3],
    // ]

    public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        if (root == null) return ret;
        ArrayList<TreeNode> parents = new ArrayList<TreeNode>();
        ArrayList<TreeNode> current = new ArrayList<TreeNode>();
        ArrayList<Integer> currentNum = new ArrayList<Integer>();
        parents.add(root);
        ret.add(new ArrayList<Integer>());
        ret.get(0).add(root.val);
        while (!parents.isEmpty()) {
            for (TreeNode p : parents) {
                if (p.left != null) {
                    current.add(p.left);
                    currentNum.add(p.left.val);
                }
                if (p.right != null) {
                    current.add(p.right);
                    currentNum.add(p.right.val);
                }
            }
            if (!currentNum.isEmpty()) ret.add(0, currentNum); // add to head
            parents = current;
            current = new ArrayList<TreeNode>();
            currentNum = new ArrayList<Integer>();
        }
        return ret;
    }
}