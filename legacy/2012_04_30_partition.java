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
    // Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

    // You should preserve the original relative order of the nodes in each of the two partitions.

    // For example,
    // Given 1->4->3->2->5->2 and x = 3,
    // return 1->2->2->4->3->5.
    
    public ListNode partition(ListNode head, int x) {
        if (head == null) return null;
        ListNode lst1Head = null;
        ListNode lst1Tail = null;
        ListNode lst2Head = null;
        ListNode lst2Tail = null;
        ListNode n = head;
        while (n != null) {
            if (n.val < x) {
                if (lst1Head == null) {
                    lst1Head = lst1Tail = n;
                    
                }
                else {
                    lst1Tail.next = n;
                    lst1Tail = n;
                }
            }
            else {
                if (lst2Head == null) {
                    lst2Head = lst2Tail = n;
                }
                else {
                    lst2Tail.next = n;
                    lst2Tail = n;
                }
            }
            n = n.next;
        }
        if (lst1Head == null) return lst2Head;
        lst1Tail.next = lst2Head;
        if (lst2Tail != null) lst2Tail.next = null;
        return lst1Head;
    }
}