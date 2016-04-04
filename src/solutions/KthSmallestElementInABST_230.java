package solutions;

import java.util.Stack;

import datastructure.TreeNode;

/**
 * https://leetcode.com/problems/kth-smallest-element-in-a-bst/
 *
 * Given a binary search tree, write a function kthSmallest to find the kth
 * smallest element in it.
 *
 * Note:
 * You may assume k is always valid, 1 <= k <= BST's total elements.
 *
 * Follow up:
 * What if the BST is modified (insert/delete operations) often and you need
 * to find the kth smallest frequently? How would you optimize the kthSmallest
 * routine?
 *
 * Hint:
 * 1. Try to utilize the property of a BST.
 * 2. What if you could modify the BST node's structure?
 * 3. The optimal runtime complexity is O(height of BST).
 */
public class KthSmallestElementInABST_230 {
    // O(n) time, O(log n) space
    public int kthSmallest(TreeNode root, int k) {
        if (root == null || k <= 0) return -1;
        Stack<TreeNode> s = new Stack<TreeNode>();
        TreeNode p = root;
        while(p != null || !s.isEmpty()) {
            if (p != null) {
                s.push(p);
                p = p.left;
            } else {
                p = s.pop();
                if (--k == 0) return p.val;
                p = p.right;
            }
        }
        return -1;
    }

    /*
     * Follow up
     *
     * Add a field in the node to track the size of its left subtree
     */
    class Node {
        int val; int leftCount;
        Node left; Node right;
        public Node(int x) { val = x; }
    }

    public int kthSmallest(Node root, int k) {
        if (root == null || k <= 0) return -1;
        return kthSmallestHelper(root, k);
    }

    private int kthSmallestHelper(Node root, int k) {
        if (root == null) return -1;
        if (root.leftCount + 1 == k) {
            return root.val;
        } else if (root.leftCount + 1 < k) {
            return kthSmallestHelper(root.right, k - root.leftCount - 1);
        } else {
            return kthSmallestHelper(root.left, k);
        }
    }
}
