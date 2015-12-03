/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
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
    // Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        int last = 0;
        ListNode n = head;
        while (n.next != null) {
            ++last;
            n = n.next;
        }
        return sortedListToBST(head, 0, last);
    }
    
    private TreeNode sortedListToBST(ListNode head, int low, int high) {
        if (low > high) return null;
        int mid = low + (high - low) / 2;
        TreeNode left = sortedListToBST(head, low, mid - 1);
        TreeNode parent = new TreeNode(head.val);
        parent.left = left;
        if (head.next != null) {
            head.val = head.next.val;
            head.next = head.next.next;
        }
        parent.right = sortedListToBST(head, mid + 1, high);
        return parent;
    }
}