package solutions;

import java.util.Stack;

import datastructure.TreeNode;

/**
 * https://leetcode.com/problems/binary-search-tree-iterator/
 *
 * Implement an iterator over a binary search tree (BST). Your iterator will
 * be initialized with the root node of a BST.
 * Calling next() will return the next smallest number in the BST.
 *
 * Note:
 * next() and hasNext() should run in average O(1) time and uses O(h) memory,
 * where h is the height of the tree.
 */
public class BinarySearchTreeIterator_173 {

    public class BSTIterator {
        private Stack<TreeNode> s;
        private TreeNode p;

        public BSTIterator(TreeNode root) {
            s = new Stack<TreeNode>();
            p = root;
        }

        /** @return whether we have a next smallest number */
        public boolean hasNext() {
            return !s.isEmpty() || p != null;
        }

        /** @return the next smallest number */
        public int next() {
            if (!hasNext()) return -1;

            while (p != null) {
                s.push(p);
                p = p.left;
            }
            p = s.pop();
            int val = p.val;
            p = p.right;
            return val;
        }
    }

    /**
     * Your BSTIterator will be called like this:
     * BSTIterator i = new BSTIterator(root);
     * while (i.hasNext()) v[f()] = i.next();
     */
}
