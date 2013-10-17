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
    // Given a linked list, swap every two adjacent nodes and return its head.

    // For example,
    // Given 1->2->3->4, you should return the list as 2->1->4->3.

    // Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
    
    // recursive solution: more elegant
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode partner = head.next;
        head.next = swapPairs(partner.next);
        partner.next = head;
        return partner;
    }
    
    // iterative solution
    public ListNode swapPairs2(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode curr = head.next;
        ListNode next = curr.next;
        ListNode ret = curr;
        while (true) {
            curr.next = head;
            if (next == null || next.next == null) {
                head.next = next;
                break;
            }
            head.next = next.next;
            head = next;
            curr = head.next;
            next = curr.next;
        }
        return ret;
    }
}