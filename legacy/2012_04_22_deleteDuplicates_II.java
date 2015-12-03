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
    // Given a sorted linked list, delete all nodes that have 
    // duplicate numbers, leaving only distinct numbers from the 
    // original list.

    // For example,
    // Given 1->2->3->3->4->4->5, return 1->2->5.
    // Given 1->1->1->2->3, return 2->3.

    // O(n) time, O(1) space
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode helper = new ListNode(Integer.MAX_VALUE);
        helper.next = head;
        ListNode n = helper;
        while (n != null) {
            ListNode runner = n;
            while (runner.next != null && runner.next.next != null && 
                runner.next.val == runner.next.next.val) {
                runner = runner.next;
            }
            if (runner != n) n.next = runner.next.next;
            else n = n.next;
        }
        return helper.next;
    }
}