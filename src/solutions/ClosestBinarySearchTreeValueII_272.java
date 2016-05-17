package solutions;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import datastructure.TreeNode;

/**
 * https://leetcode.com/problems/closest-binary-search-tree-value-ii/
 *
 * Given a non-empty binary search tree and a target value, find k values
 * in the BST that are closest to the target.
 *
 * Note:
 * 1. Given target value is a floating point.
 * 2. You may assume k is always valid, that is: k ≤ total nodes.
 * 3. You are guaranteed to have only one unique set of k values in the
 * BST that are closest to the target.
 *
 * Follow up:
 * Assume that the BST is balanced, could you solve it in less than O(n)
 * runtime (where n = total nodes)?
 *
 * Hint:
 * 1. Consider implement these two helper functions:
 *   i. getPredecessor(N), which returns the next smaller node to N.
 *   ii. getSuccessor(N), which returns the next larger node to N.
 * 2. Try to assume that each node has a parent pointer, it makes the problem
 * much easier.
 * 3. Without parent pointer we just need to keep track of the path from the
 * root to the current node using a stack.
 * 4. You would need two stacks to track the path in finding predecessor and
 * successor node separately.
 */
public class ClosestBinarySearchTreeValueII_272 {
    /* O(k log n) time, O(log n) space (assume k is small such that k < log n)
     * Use two stacks to track predecessors and successors, traverse minimal
     * number of tree nodes.
     * Ref: https://leetcode.com/discuss/71820/java-5ms-iterative-following-hint-o-klogn-time-and-space
     */
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        LinkedList<Integer> res = new LinkedList<Integer>();
        if (root == null || k <= 0) return res;

        Stack<TreeNode> suc = new Stack<TreeNode>();
        Stack<TreeNode> pre = new Stack<TreeNode>();
        while (root != null) {
            if (root.val > target) {
                suc.push(root);
                root = root.left;
            } else {
                pre.push(root);
                root = root.right;
            }
        }

        while (k-- > 0) {
            if (suc.isEmpty()) {
                res.add(nextPre(pre));
            } else if (pre.isEmpty()) {
                res.add(nextSuc(suc));
            } else if (Math.abs(pre.peek().val - target) < Math.abs(suc.peek().val - target)) {
                res.add(nextPre(pre));
            } else {
                res.add(nextSuc(suc));
            }
        }
        return res;
    }

    // inorder successor
    private int nextSuc(Stack<TreeNode> suc) {
        TreeNode n = suc.pop();
        int v = n.val;
        n = n.right;
        while (n != null) {
            suc.push(n);
            n = n.left;
        }
        return v;
    }

    // reverse-inorder successor
    private int nextPre(Stack<TreeNode> pre) {
        TreeNode n = pre.pop();
        int v = n.val;
        n = n.left;
        while (n != null) {
            pre.push(n);
            n = n.right;
        }
        return v;
    }

    /* O(n) time, O(log n) space (assume k is small such that k < log n)
     * Inorder traversal with a queue
     */
    public List<Integer> closestKValues2(TreeNode root, double target, int k) {
        LinkedList<Integer> res = new LinkedList<Integer>();
        if (root == null || k <= 0) return res;

        Stack<TreeNode> s = new Stack<TreeNode>();
        while (!s.isEmpty() || root != null) {
            while (root != null) {
                s.add(root);
                root = root.left;
            }
            root = s.pop();
            int v = root.val;
            root = root.right;

            if (res.size() < k) {
                res.add(v);
            } else {
                if (Math.abs(v - target) < Math.abs(res.peek() - target)) {
                    res.remove();
                    res.add(v);
                } else {
                    break;
                }
            }
        }
        return res;
    }
}
