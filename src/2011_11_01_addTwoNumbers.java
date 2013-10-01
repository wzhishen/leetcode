/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    // You are given two linked lists representing two non-negative numbers.
    // The digits are stored in reverse order and each of their nodes contain 
    // a single digit. Add the two numbers and return it as a linked list.

    // Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
    // Output: 7 -> 0 -> 8

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int s = 0;
        int d = 0;
        int carry = 0;
        ListNode n = new ListNode(d);
        ListNode head = n;
        while (l1 != null || l2 != null || carry != 0) {
            int n1 = l1 == null ? 0 : l1.val;
            int n2 = l2 == null ? 0 : l2.val;
            s = n1 + n2 + carry;
            d = s % 10;
            carry = s /10;
            n.next = new ListNode(d);
            n = n.next;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        return head.next;
    }
}