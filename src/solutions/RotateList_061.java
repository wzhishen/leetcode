package solutions;

import datastructure.ListNode;

/**
 * https://leetcode.com/problems/rotate-list/
 *
 * Given a list, rotate the list to the right by k places, where k is
 * non-negative.
 *
 * For example:
 * Given 1->2->3->4->5->NULL and k = 2,
 * return 4->5->1->2->3->NULL.
 */
public class RotateList_061 {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k <= 0) return head;
        ListNode n = head;
        int len = 1;
        while (n.next != null) {
            n = n.next;
            ++len;
        }
        n.next = head;
        k %= len;
        for (int i = 0; i < len - k; ++i) n = n.next;
        head = n.next;
        n.next = null;
        return head;
    }
}
