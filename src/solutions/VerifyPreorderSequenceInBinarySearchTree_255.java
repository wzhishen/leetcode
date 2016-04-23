package solutions;

import java.util.Stack;

/**
 * https://leetcode.com/problems/verify-preorder-sequence-in-binary-search-tree/
 *
 * Given an array of numbers, verify whether it is the correct preorder
 * traversal sequence of a binary search tree.
 * You may assume each number in the sequence is unique.
 *
 * Follow up:
 * Could you do it using only constant space complexity?
 */
public class VerifyPreorderSequenceInBinarySearchTree_255 {
    /* Simulate inorder traversal: O(n) time, O(n) space
     * Ref:
     * https://leetcode.com/discuss/51543/java-o-n-and-o-1-extra-space
     * https://segmentfault.com/a/1190000003874375
     */
    public boolean verifyPreorder(int[] preorder) {
        if (preorder == null) return false;

        Stack<Integer> s = new Stack<Integer>();
        int lastInorder = Integer.MIN_VALUE;
        for (int n : preorder) {
            if (n < lastInorder) return false;
            while (!s.isEmpty() && s.peek() < n) lastInorder = s.pop();
            s.push(n);
        }
        return true;
    }

    /*
     * BF: O(n^2) time, O(n) call stack space
     */
    public boolean verifyPreorder2(int[] preorder) {
        if (preorder == null) return false;
        return verifyPreorder(preorder, 0, preorder.length - 1);
    }

    private boolean verifyPreorder(int[] preorder, int low, int high) {
        if (low >= high) return true;
        int pivot = high + 1;
        for (int i = low + 1; i <= high; ++i) {
            if (preorder[i] > preorder[low]) {
                pivot = i;
                break;
            }
        }
        for (int i = low + 1; i < pivot; ++i) {
            if (preorder[i] > preorder[low]) return false;
        }
        for (int i = pivot; i <= high; ++i) {
            if (preorder[i] < preorder[low]) return false;
        }
        return verifyPreorder(preorder, low + 1, pivot - 1) && verifyPreorder(preorder, pivot, high);
    }
}
