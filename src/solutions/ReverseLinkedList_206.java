package solutions;

import datastructure.ListNode;

/**
 * https://leetcode.com/problems/reverse-linked-list/
 *
 * Reverse a singly linked list.
 *
 * Hint:
 * A linked list can be reversed either iteratively or recursively. Could you implement both?
 */
public class ReverseLinkedList_206 {
    public ListNode reverseList(ListNode head) {
        ListNode newHead = null;
        while (head != null) {
            ListNode nextNode = head.next;
            head.next = newHead;
            newHead = head;
            head = nextNode;
        }
        return newHead;
    }

    public ListNode reverseListRecursive(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return head;
        ListNode second = head.next;
        head.next = null;
        ListNode newHead = reverseList(second);
        second.next = head;
        return newHead;
    }
}
