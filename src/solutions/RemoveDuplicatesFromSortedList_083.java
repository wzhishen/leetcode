package solutions;

import datastructure.ListNode;

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list/
 *
 * Given a sorted linked list, delete all duplicates such that each element
 * appear only once.
 *
 * For example,
 * Given 1->1->2, return 1->2.
 * Given 1->1->2->3->3, return 1->2->3.
 */
public class RemoveDuplicatesFromSortedList_083 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode p1 = head, p2 = head;
        while (p1 != null) {
            while (p2 != null && p1.val == p2.val) {
                p2 = p2.next;
            }
            p1.next = p2;
            p1 = p1.next;
        }
        return head;
    }
}
