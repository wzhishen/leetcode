package solutions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode.com/problems/count-of-smaller-numbers-after-self/
 *
 * You are given an integer array nums and you have to return a new counts
 * array. The counts array has the property where counts[i] is the number
 * of smaller elements to the right of nums[i].
 *
 * Example:
 * Given nums = [5, 2, 6, 1]
 * To the right of 5 there are 2 smaller elements (2 and 1).
 * To the right of 2 there is only 1 smaller element (1).
 * To the right of 6 there is 1 smaller element (1).
 * To the right of 1 there is 0 smaller element.
 * Return the array [2, 1, 1, 0].
 */
public class CountOfSmallerNumbersAfterSelf_315 {
    /* BST: O(n log n) avg time, O(n^2) worst time, O(n) space
     * Ref: some other approaches:
     * http://tinyurl.com/hzjb88c
     */
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> res = new ArrayList<Integer>();
        if (nums == null || nums.length == 0) return res;

        res.add(0);
        TreeNode root = new TreeNode(nums[nums.length - 1]);
        for (int i = nums.length - 2; i >= 0; --i) res.add(addNode(root, nums[i]));
        Collections.reverse(res);
        return res;
    }

    private int addNode(TreeNode n, int v) {
        int cnt = 0;
        while (n != null) {
            if (v < n.val) {
                ++n.leftCnt;
                if (n.left == null) {
                    n.left = new TreeNode(v);
                    break;
                }
                n = n.left;
            } else if (v > n.val) {
                cnt += n.leftCnt + n.selfCnt;
                if (n.right == null) {
                    n.right = new TreeNode(v);
                    break;
                }
                n = n.right;
            } else {
                ++n.selfCnt;
                cnt += n.leftCnt;
                break;
            }
        }
        return cnt;
    }

    private class TreeNode {
        TreeNode left = null, right = null;
        int val, leftCnt = 0, selfCnt = 1;
        public TreeNode(int v) {
            val = v;
        }
    }
}
