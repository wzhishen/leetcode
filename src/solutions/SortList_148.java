package solutions;

import datastructure.ListNode;

/**
 * https://leetcode.com/problems/sort-list/
 *
 * Sort a linked list in O(n log n) time using constant space complexity.
 */
public class SortList_148 {
    // merge sort
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode p1 = head, p2 = head;
        while(p2.next != null && p2.next.next != null) {
            p2 = p2.next.next;
            p1 = p1.next;
        }
        p2 = p1.next;
        p1.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(p2);
        return merge(left, right);
    }

    private ListNode merge(ListNode left, ListNode right) {
        ListNode dummy = new ListNode(-1);
        ListNode n = dummy;
        while (left != null && right != null) {
            if (left.val < right.val) {
                n.next = left;
                left = left.next;
            } else {
                n.next = right;
                right = right.next;
            }
            n = n.next;
        }
        n.next = left != null ? left : right;
        return dummy.next;
    }
}
