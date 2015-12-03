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
    // Given a sorted linked list, delete all duplicates such that 
    // each element appear only once.

    // For example,
    // Given 1->1->2, return 1->2.
    // Given 1->1->2->3->3, return 1->2->3.

    // O(n) time, O(1) space
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode n = head;
        while (n != null) {
            while (n.next != null && n.val == n.next.val) {
                n.next = n.next.next;
            }
            n = n.next;
        }
        return head;
    }
}