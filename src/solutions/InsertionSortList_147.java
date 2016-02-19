package solutions;

import datastructure.ListNode;

/**
 * https://leetcode.com/problems/insertion-sort-list/
 *
 * Sort a linked list using insertion sort.
 */
public class InsertionSortList_147 {
    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(-1);
        while (head != null) {
            ListNode next = head.next;
            insert(dummy, head);
            head = next;
        }
        return dummy.next;
    }

    private void insert(ListNode n, ListNode newNode) {
        // find a place to insert, such that n.val <= newNode.val <= n.next.val
        while (n.next != null && newNode.val > n.next.val) {
            n = n.next;
        }
        newNode.next = n.next;
        n.next = newNode;
    }
}
