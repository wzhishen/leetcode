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
    // Given a list, rotate the list to the right by k places, where k is non-negative.

    // For example:
    // Given 1->2->3->4->5->NULL and k = 2,
    // return 4->5->1->2->3->NULL.
    
    public ListNode rotateRight(ListNode head, int n) {
        if (head == null || head.next == null) return head;
        
        // get tail and length
        ListNode tail = head;
        int len = 1;
        while (tail.next != null) {
            tail = tail.next;
            ++len;
        }
        
        // form a circle
        tail.next = head;
        
        // get minimal moves needed
        n %= len;
        
        // rotate
        for (int i = 0; i < len - n; ++i) {
            head = head.next;
            tail = tail.next;
        }
        
        // break the circle
        tail.next = null;
        return head;
    }
}