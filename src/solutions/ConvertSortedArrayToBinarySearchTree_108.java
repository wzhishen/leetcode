package solutions;

import datastructure.TreeNode;

/**
 * https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
 *
 * Given an array where elements are sorted in ascending order, convert it to
 * a height balanced BST.
 */
public class ConvertSortedArrayToBinarySearchTree_108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null) return null;
        return sortedArrayToBST(nums, 0, nums.length - 1);
    }

    private TreeNode sortedArrayToBST(int[] nums, int low, int high) {
        if (low > high) return null;
        int mid = low + (high - low) / 2;
        TreeNode n = new TreeNode(nums[mid]);
        n.left = sortedArrayToBST(nums, low, mid - 1);
        n.right = sortedArrayToBST(nums, mid + 1, high);
        return n;
    }
}
