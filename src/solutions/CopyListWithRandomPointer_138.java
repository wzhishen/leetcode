package solutions;

import datastructure.RandomListNode;

/**
 * https://leetcode.com/problems/copy-list-with-random-pointer/
 *
 * A linked list is given such that each node contains an additional random
 * pointer which could point to any node in the list or null.
 * Return a deep copy of the list.
 */
public class CopyListWithRandomPointer_138 {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) return null;

        // replicate next nodes
        RandomListNode p = head;
        while (p != null) {
            RandomListNode copy = new RandomListNode(p.label);
            copy.next = p.next;
            p.next = copy;
            p = copy.next;
        }

        // replicate random nodes
        p = head;
        while (p != null) {
            RandomListNode copy = p.next;
            if (p.random != null) copy.random = p.random.next;
            p = copy.next;
        }

        // decouple two lists
        p = head;
        RandomListNode newHead = head.next;
        while (p != null) {
            RandomListNode copy = p.next;
            p.next = copy.next;
            if (copy.next != null) copy.next = copy.next.next;
            p = p.next;
        }
        return newHead;
    }
}
