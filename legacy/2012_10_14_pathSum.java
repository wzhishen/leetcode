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
    // Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

    // For example:
    // Given the below binary tree and sum = 22,
    //               5
    //              / \
    //             4   8
    //            /   / \
    //           11  13  4
    //          /  \    / \
    //         7    2  5   1
    // return
    // [
    //    [5,4,11,2],
    //    [5,8,4,5]
    // ]
    
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> path = new ArrayList<Integer>();
        pathSumHelper(root, sum, path, res);
        return res;
    }
    
    private void pathSumHelper(TreeNode root, int sum, ArrayList<Integer> path, ArrayList<ArrayList<Integer>> res) {
        if (root == null) return;
        path.add(root.val);
        if (root.left == null && root.right == null) {
            if (sum == root.val) {
                res.add((ArrayList<Integer>)path.clone());
            }
        }
        pathSumHelper(root.left, sum - root.val, path, res);
        pathSumHelper(root.right, sum - root.val, path, res);
        path.remove(path.size() - 1); // "pop" recursion stack top
    }
}