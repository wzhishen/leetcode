package solutions;

import datastructure.ListNode;

/**
 * https://leetcode.com/problems/intersection-of-two-linked-lists/
 *
 * Write a program to find the node at which the intersection of two singly
 * linked lists begins.
 *
 * For example, the following two linked lists:
 * A:          a1 -> a2
 *                     \
                       c1 -> c2 -> c3
 *                     /
 * B:    b1 -> b2 -> b3
 * begin to intersect at node c1.
 *
 * Notes:
 * 1. If the two linked lists have no intersection at all, return null.
 * 2. The linked lists must retain their original structure after the
 * function returns.
 * 3. You may assume there are no cycles anywhere in the entire linked
 * structure.
 * 4. Your code should preferably run in O(n) time and use only O(1)
 * memory.
 */
public class IntersectionOfTwoLinkedLists_160 {
    // Ref: https://leetcode.com/discuss/17278/accepted-shortest-explaining-algorithm-comments-improvements
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode a = headA, b = headB;
        while (a != null && b != null && a != b) {
            a = a.next;
            b = b.next;
            if (a == b) return a;
            if (b == null) b = headA;
            if (a == null) a = headB;
        }
        return a;
    }

    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        ListNode pa = headA, pb = headB;
        int lenA = 0, lenB = 0;
        while (pa != null) {
            ++lenA;
            pa = pa.next;
        }
        while (pb != null) {
            ++lenB;
            pb = pb.next;
        }
        pa = headA; pb = headB;
        int diff = lenA - lenB;
        while (diff != 0) {
            if (diff > 0) {
                --diff;
                pa = pa.next;
            } else {
                ++diff;
                pb = pb.next;
            }
        }
        while (pa != pb) {
            pa = pa.next;
            pb = pb.next;
        }
        return pa;
    }
}
