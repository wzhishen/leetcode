package solutions;

import datastructure.TreeNode;

/**
 * https://leetcode.com/problems/house-robber-iii/
 *
 * The thief has found himself a new place for his thievery again. There is only
 * one entrance to this area, called the "root." Besides the root, each house has
 * one and only one parent house. After a tour, the smart thief realized that "all
 * houses in this place forms a binary tree". It will automatically contact the
 * police if two directly-linked houses were broken into on the same night.
 * Determine the maximum amount of money the thief can rob tonight without alerting
 * the police.
 *
 * Example 1:
 *     (3)
 *     / \
 *    2   3
 *     \   \ 
 *     (3) (1)
 * Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.
 * 
 * Example 2:
 *      3
 *     / \
 *   (4) (5)
 *   / \   \ 
 *  1   3   1
 * Maximum amount of money the thief can rob = 4 + 5 = 9.
 */
public class HouseRobberIII_337 {
    /* DP recurrence:
     *   robRoot(root) = root.val + noRobRoot(root.left) + noRobRoot(root.right)
     * noRobRoot(root) = max(robRoot(root.left)   + robRoot(root.right),
     *                       robRoot(root.left)   + noRobRoot(root.left),
     *                       noRobRoot(root.left) + robRoot(root.left))
     *                 = max(robRoot(root.left), noRobRoot(root.left)) +
     *                   max(robRoot(root.right), noRobRoot(root.right))
     * result = max(robRoot(root), noRobRoot(root))
     *
     * Ref:
     * http://www.programcreek.com/2015/03/leetcode-house-robber-iii-java/
     * https://leetcode.com/discuss/91899/step-by-step-tackling-of-the-problem
     */
    public int rob(TreeNode root) {
        int[] result = robHelper(root);
        return Math.max(result[0], result[1]);
    }

    // returns [robRoot(root), noRobRoot(root)]
    private int[] robHelper(TreeNode n) {
        int[] result = {0, 0};
        if (n == null) return result;
        int[] left = robHelper(n.left);
        int[] right = robHelper(n.right);
        result[0] = n.val + left[1] + right[1];
        result[1] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        return result;
    }
}
