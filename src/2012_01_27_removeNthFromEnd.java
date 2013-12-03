/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    // Given a linked list, remove the nth node from the end of 
    // list and return its head.

    // For example,

    // Given linked list: 1->2->3->4->5, and n = 2.
    // After removing the second node from the end, the linked 
    // list becomes 1->2->3->5.

    // Note:
    // Given n will always be valid.
    // Try to do this in one pass.

    // O(n) time, O(1) space
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return null;
        ListNode p1 = head;
        for (int i = 0; i < n; ++i) p1 = p1.next;
        if (p1 == null) return head.next; // edge case: remove head
        ListNode p2 = head;
        while (p1.next != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        p2.next = p2.next.next; // normal case
        return head;
    }
}