package solutions;

import datastructure.ListNode;

/**
 * https://leetcode.com/problems/reorder-list/
 *
 * Given a singly linked list L: L0->L1->...->Ln-1->Ln,
 * reorder it to: L0->Ln->L1->Ln-1->L2->Ln-2->...
 * You must do this in-place without altering the nodes' values.
 * For example,
 * Given {1,2,3,4}, reorder it to {1,4,2,3}.
 */
public class ReorderList_143 {
    /* O(n) time, O(1) space
     * divide list by half, reverse right half, then merge two lists 1 by 1
     */
    public void reorderList(ListNode head) {
        if (head == null) return;
        ListNode n1 = head;
        ListNode n2 = head;
        while (n2.next != null && n2.next.next != null) {
            n2 = n2.next.next;
            n1 = n1.next;
        }
        ListNode n = n1.next;
        n1.next = null;

        n1 = head;
        n2 = reverse(n);
        while (n2 != null) {
            ListNode next1 = n1.next;
            ListNode next2 = n2.next;
            n1.next = n2;
            n2.next = next1;
            n1 = next1;
            n2 = next2;
        }
    }

    private ListNode reverse(ListNode head) {
        ListNode newHead = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }
        return newHead;
    }
}
