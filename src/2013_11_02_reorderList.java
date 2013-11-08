/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    // Given a singly linked list L: L0→L1→…→Ln-1→Ln,
    // reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

    // You must do this in-place without altering the nodes' values.

    // For example,
    // Given {1,2,3,4}, reorder it to {1,4,2,3}.
    
    // O(n) time, O(n) space
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        HashMap<ListNode, ListNode> map = new HashMap<ListNode, ListNode>();
        ListNode tail = head;
        while (tail.next != null) {
            map.put(tail.next, tail);
            tail = tail.next;
        }
        ListNode next = head.next;
        while (true) {
            head.next = tail;
            tail.next = next;
            head = next;
            if (head.next == tail) {
                head.next = null;
                break;
            }
            next = head.next;
            tail = map.get(tail);
        }
    }
}