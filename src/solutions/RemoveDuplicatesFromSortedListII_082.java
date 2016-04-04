package solutions;

import datastructure.ListNode;

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/
 *
 * Given a sorted linked list, delete all nodes that have duplicate numbers,
 * leaving only distinct numbers from the original list.
 *
 * For example,
 * Given 1->2->3->3->4->4->5, return 1->2->5.
 * Given 1->1->1->2->3, return 2->3.
 */
public class RemoveDuplicatesFromSortedListII_082 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        head = dummy;
        while (head.next != null) {
            ListNode p = head.next;
            while (p != null && p.val == head.next.val) {
                p = p.next;
            }
            if (p == head.next.next) {
                head = head.next;
            } else {
                head.next = p;
            }
        }
        return dummy.next;
    }
}
