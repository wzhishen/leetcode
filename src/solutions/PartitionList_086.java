package solutions;

import datastructure.ListNode;

/**
 * https://leetcode.com/problems/partition-list/
 *
 * Given a linked list and a value x, partition it such that all nodes less
 * than x come before nodes greater than or equal to x.
 * You should preserve the original relative order of the nodes in each of
 * the two partitions.
 *
 * For example,
 * Given 1->4->3->2->5->2 and x = 3,
 * return 1->2->2->4->3->5.
 */
public class PartitionList_086 {
    public ListNode partition(ListNode head, int x) {
        if (head == null) return null;
        ListNode dummy1 = new ListNode(-1);
        ListNode dummy2 = new ListNode(-1);
        ListNode n1 = dummy1, n2 = dummy2;
        while (head != null) {
            if (head.val < x) {
                n1.next = head;
                n1 = n1.next;
            } else {
                n2.next = head;
                n2 = n2.next;
            }
            head = head.next;
        }
        n2.next = null;
        n1.next = dummy2.next;
        return dummy1.next;
    }
}
