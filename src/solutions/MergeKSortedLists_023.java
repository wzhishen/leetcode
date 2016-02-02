package solutions;

import java.util.Comparator;
import java.util.PriorityQueue;

import datastructure.ListNode;

/**
 * https://leetcode.com/problems/merge-k-sorted-lists/
 *
 * Merge k sorted linked lists and return it as one sorted list.
 * Analyze and describe its complexity.
 */
public class MergeKSortedLists_023 {
    /*
     * Optimal: divide and conquer.
     * Time:
     * T = 2m * n/2 + 4m * n/4 + 8m * n/8 + ... + (2^i)m * n/(2^i)
     *   = O(imn)
     * since n/(2^i) = 1 -> i = log n
     * thus T = O(imn) = O(mn log n)
     * Space: O(1)
     *
     * n - total number of lists
     * m - average length of each list
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        int left = 0, right = lists.length - 1;
        while (left < right) {
            while (left < right) {
                lists[left] = mergeTwoLists(lists[left], lists[right]);
                ++left;
                --right;
            }
            left = 0;
        }
        return lists[0];
    }

    /*
     * Use a heap.
     * Time: O(mn log n)
     * Space: O(m)
     *
     * n - total number of lists
     * m - average length of each list
     */
    public ListNode mergeKLists2(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        PriorityQueue<ListNode> heap = new PriorityQueue<ListNode>(lists.length, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode n1, ListNode n2) {
                return ((Integer)n1.val).compareTo(n2.val);
            }
        });
        for (ListNode list : lists) {
            if (list != null) heap.offer(list);
        }
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;
        while (!heap.isEmpty()) {
            ListNode n = heap.poll();
            tail.next = n;
            tail = n;
            if (n.next != null) heap.offer(n.next);
        }
        return dummy.next;
    }

    /*
     * Merge lists one by one.
     * Time:
     * T = 2m + 3m + 4m + .. nm
     *   = m(n + 2)(n - 2 + 1)
     *   = O(mn^2)
     * Space: O(1)
     *
     * n - total number of lists
     * m - average length of each list
     */
    public ListNode mergeKLists3(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        for (int i = 1; i < lists.length; ++i) {
            lists[0] = mergeTwoLists(lists[0], lists[i]);
        }
        return lists[0];
    }

    private ListNode mergeTwoLists(ListNode n1, ListNode n2) {
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;
        while (n1 != null && n2 != null) {
            if (n1.val < n2.val) {
                tail.next = n1;
                tail = n1;
                n1 = n1.next;
            } else {
                tail.next = n2;
                tail = n2;
                n2 = n2.next;
            }
        }
        if (n1 == null) tail.next = n2;
        else if (n2 == null) tail.next = n1;
        return dummy.next;
    }
}
