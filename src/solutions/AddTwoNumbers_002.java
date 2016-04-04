package solutions;

import datastructure.ListNode;

/**
 * https://leetcode.com/problems/add-two-numbers/
 *
 * You are given two linked lists representing two non-negative numbers. The
 * digits are stored in reverse order and each of their nodes contain a single
 * digit. Add the two numbers and return it as a linked list.
 *
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 */
public class AddTwoNumbers_002 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode n = null, head = null;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            int sum = 0;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            if (carry != 0) {
                sum += carry;
            }
            int digit = sum % 10;
            carry = sum / 10;
            if (head == null) {
                head = new ListNode(digit);
                n = head;
            } else {
                n.next = new ListNode(digit);
                n = n.next;
            }
        }
        return head;
    }
}
