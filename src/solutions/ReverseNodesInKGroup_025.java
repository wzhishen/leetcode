package solutions;

import datastructure.ListNode;

/**
 * https://leetcode.com/problems/reverse-nodes-in-k-group/
 *
 * Given a linked list, reverse the nodes of a linked list k at a time and
 * return its modified list.
 * If the number of nodes is not a multiple of k then left-out nodes in the
 * end should remain as it is.
 * You may not alter the values in the nodes, only nodes itself may be changed.
 * Only constant memory is allowed.
 *
 * For example,
 * Given this linked list: 1->2->3->4->5
 * For k = 2, you should return: 2->1->4->3->5
 * For k = 3, you should return: 3->2->1->4->5
 */
public class ReverseNodesInKGroup_025 {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) return head;
        ListNode n = head;
        for (int i = 1; i < k; ++i) {
            n = n.next;
            if (n == null) return head;
        }
        ListNode nextHead = n.next;
        n.next = null;
        n = reverse(head);
        head.next = reverseKGroup(nextHead, k);
        return n;
    }

    private ListNode reverse(ListNode n) {
        if (n == null || n.next == null) return n;
        ListNode second = n.next;
        n.next = null;
        ListNode newHead = reverse(second);
        second.next = n;
        return newHead;
    }
}
