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
    // Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
    
    public TreeNode sortedArrayToBST(int[] num) {
        if (num == null) return null;
        return sortedArrayToBST(num, 0, num.length - 1);
    }
    
    private TreeNode sortedArrayToBST(int[] num, int low, int high) {
        if (low > high) return null;
        int mid = low + (high - low) / 2;
        TreeNode n = new TreeNode(num[mid]);
        n.left = sortedArrayToBST(num, low, mid - 1);
        n.right = sortedArrayToBST(num, mid + 1, high);
        return n;
    }
}