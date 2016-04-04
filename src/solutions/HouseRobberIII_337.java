package solutions;

import datastructure.TreeNode;


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
     * Ref: http://www.programcreek.com/2015/03/leetcode-house-robber-iii-java/
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
