package solutions;

import datastructure.ListNode;

/**
 * https://leetcode.com/problems/reverse-linked-list-ii/
 *
 * Reverse a linked list from position m to n. Do it in-place and in
 * one-pass.
 *
 * For example:
 * Given 1->2->3->4->5->NULL, m = 2 and n = 4,
 * return 1->4->3->2->5->NULL.
 *
 * Note:
 * Given m, n satisfy the following condition:
 * 1 <= m <= n <= length of list.
 */
public class ReverseLinkedListII_092 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || m > n) return null;

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        head = dummy;

        ListNode leftTail = head;
        for (int i = 1; i < m; ++i) {
            leftTail = leftTail.next;
            if (leftTail == null) return null;
        }

        ListNode node = leftTail.next;
        ListNode newHead = null;
        ListNode newTail = node;
        ListNode next = null;
        int cnt = 0;
        while (cnt < n - m + 1) {
            if (node == null) return null;
            next = node.next;
            node.next = newHead;
            newHead = node;
            node = next;
            ++cnt;
        }
        leftTail.next = newHead;
        newTail.next = next;
        return dummy.next;
    }
}
