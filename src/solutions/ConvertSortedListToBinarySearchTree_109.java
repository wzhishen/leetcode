package solutions;

import datastructure.ListNode;
import datastructure.TreeNode;

/**
 * https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/
 *
 * Given a singly linked list where elements are sorted in ascending order,
 * convert it to a height balanced BST.
 */
public class ConvertSortedListToBinarySearchTree_109 {
    /* Reference:
     * http://www.geeksforgeeks.org/sorted-linked-list-to-balanced-bst/
     */
    public TreeNode sortedListToBST(ListNode head) {
         if (head == null) return null;
         curr = head;
         int size = size(head);
         return sortedListToBST(0, size - 1);
    }

    private ListNode curr = null;

    private TreeNode sortedListToBST(int low, int high) {
        if (low > high) return null;
        int mid = low + (high - low) / 2;
        TreeNode left = sortedListToBST(low, mid - 1);
        TreeNode root = new TreeNode(curr.val);
        root.left = left;
        curr = curr.next;
        root.right = sortedListToBST(mid + 1, high);
        return root;
    }

    private int size(ListNode n) {
        int len = 0;
        while (n != null) {
            ++len;
            n = n.next;
        }
        return len;
    }
}
