package project2026.solutions;

import project2026.datastructure.ListNode;

/*
https://leetcode.com/problems/reverse-linked-list/description/

Given the head of a singly linked list, reverse the list, and return the reversed list.



Example 1:
https://assets.leetcode.com/uploads/2021/02/19/rev1ex1.jpg

Input: head = [1,2,3,4,5]
Output: [5,4,3,2,1]

Example 2:
https://assets.leetcode.com/uploads/2021/02/19/rev1ex2.jpg

Input: head = [1,2]
Output: [2,1]

Example 3:

Input: head = []
Output: []


Constraints:

The number of nodes in the list is the range [0, 5000].
-5000 <= Node.val <= 5000


Follow up: A linked list can be reversed either iteratively or recursively. Could you implement both?

 */
public class Q0206_ReverseLinkedList {
     public ListNode reverseList(ListNode head) {
         ListNode prev = null, curr = head;
         while (curr != null) {
             ListNode next = curr.next;
             curr.next = prev;
             prev = curr;
             curr = next;
         }
         return prev;
     }

    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode second = head.next;
        head.next = null;
        ListNode newHead = reverseList2(second);
        second.next = head;
        return newHead;
    }

    // public ListNode reverseList(ListNode head) {
    //     if (head == null) return null;

    //     ListNode p = head;
    //     Stack<ListNode> stack = new Stack<>();
    //     while (p != null) {
    //         stack.push(p);
    //         p = p.next;
    //     }
    //     ListNode dummy = new ListNode(5001); p = dummy;
    //     while (!stack.isEmpty()) {
    //         p.next = stack.pop();
    //         p = p.next;
    //     }
    //     head.next = null;
    //     return dummy.next;
    // }
}
