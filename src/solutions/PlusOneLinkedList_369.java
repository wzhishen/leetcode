package solutions;

import datastructure.ListNode;

/**
 * https://leetcode.com/problems/plus-one-linked-list/
 *
 * Given a non-negative number represented as a singly linked list of
 * digits, plus one to the number.
 * The digits are stored such that the most significant digit is at the
 * head of the list.
 *
 * Example:
 * Input:
 * 1->2->3
 *
 * Output:
 * 1->2->4
 */
public class PlusOneLinkedList_369 {
    public ListNode plusOne(ListNode n) {
        if (n == null) return null;
        if (helper(n) == 0) return n;
        ListNode r = new ListNode(1);
        r.next = n;
        return r;
    }

    private int helper(ListNode n) {
        if (n == null) return 1;
        int carry = helper(n.next);
        if (carry == 0) return 0;
        int sum = n.val + carry;
        n.val = sum % 10;
        return sum / 10;
    }
}
