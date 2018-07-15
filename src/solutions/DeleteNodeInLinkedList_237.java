package solutions;

import datastructure.ListNode;

/**
 * https://leetcode.com/problems/delete-node-in-a-linked-list/
 *
 * Write a function to delete a node (except the tail) in a singly
 * linked list, given only access to that node.
 *
 * Supposed the linked list is 1 -> 2 -> 3 -> 4 and you are given
 * the third node with value 3, the linked list should become
 * 1 -> 2 -> 4 after calling your function.
 */
public class DeleteNodeInLinkedList_237 {
    public void deleteNode(ListNode node) {
        if (node == null || node.next == null) return;
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
