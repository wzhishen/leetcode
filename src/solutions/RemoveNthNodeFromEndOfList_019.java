package solutions;

import datastructure.ListNode;

/**
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 *
 * Given a linked list, remove the nth node from the end of list and return
 * its head.
 *
 * For example,
 * Given linked list: 1->2->3->4->5, and n = 2.
 * After removing the second node from the end, the linked list becomes
 * 1->2->3->5.
 *
 * Note:
 * Given n will always be valid.
 * Try to do this in one pass.
 */
public class RemoveNthNodeFromEndOfList_019 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (n <= 0) return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        head = dummy;
        for (int i = 0; i < n; ++i) {
            head = head.next;
            if (head == null) return dummy.next;
        }
        ListNode prev = dummy;
        while (head.next != null) {
            head = head.next;
            prev = prev.next;
        }
        prev.next = prev.next.next;
        return dummy.next;
    }
}
