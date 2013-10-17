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
    // Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
    // O(n log k), where n is the total number of nodes in all lists.

    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        if (lists == null || lists.isEmpty()) return null;
        
        PriorityQueue<ListNode> heap = new PriorityQueue<ListNode>(lists.size(),
            new Comparator<ListNode>() {
                @Override
                public int compare(ListNode n1, ListNode n2) {
                    return ((Integer)n1.val).compareTo(n2.val);
                }
            });
        
        for (ListNode n : lists) {
            if (n != null) heap.offer(n);
        }
        
        ListNode head = null;
        ListNode tail = null;
        while (!heap.isEmpty()) {
            ListNode first = heap.poll();
            if (head == null) {
                head = tail = first;
            }
            else {
                tail.next = first;
                tail = first;
            }
            if (first.next != null) {
                heap.offer(first.next);
            }
        }
        return head;
    }
}