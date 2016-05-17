package solutions;

/**
 * https://leetcode.com/problems/count-of-range-sum/
 *
 * Given an integer array nums, return the number of range sums that
 * lie in [lower, upper] inclusive.
 * Range sum S(i, j) is defined as the sum of the elements in nums
 * between indices i and j (i ≤ j), inclusive.
 *
 * Note:
 * A naive algorithm of O(n^2) is trivial. You MUST do better than
 * that.
 *
 * Example:
 * Given nums = [-2, 5, -1], lower = -2, upper = 2,
 * Return 3.
 * The three ranges are : [0, 0], [2, 2], [0, 2] and their respective
 * sums are: -2, -1, 2.
 */
public class CountOfRangeSum_327 {
    /* BST
     * Ref: https://leetcode.com/discuss/79903/java-bst-solution-averagely-o-nlogn
     */
    public int countRangeSum(int[] nums, int lower, int upper) {
        if (nums == null || nums.length == 0) return 0;

        long[] sums = new long[nums.length + 1];
        for (int i = 0; i < nums.length; ++i) sums[i + 1] = sums[i] + nums[i];

        TreeNode root = new TreeNode(sums[sums.length - 1]);
        int cnt = 0;
        for (int i = sums.length - 2; i >= 0; --i) {
            cnt += countRange(root, sums[i] + lower, sums[i] + upper);
            addNode(root, sums[i]);
        }
        return cnt;
    }

    private void addNode(TreeNode n, long v) {
        while (n != null) {
            if (v < n.val) {
                ++n.leftCnt;
                if (n.left == null) {
                    n.left = new TreeNode(v);
                    return;
                }
                n = n.left;
            } else if (v > n.val) {
                if (n.right == null) {
                    n.right = new TreeNode(v);
                    return;
                }
                n = n.right;
            } else {
                ++n.selfCnt;
                return;
            }
        }
    }

    private int countSmaller(TreeNode n, long v) {
        int cnt = 0;
        while (n != null) {
            if (v < n.val) {
                n = n.left;
            } else if (v > n.val) {
                cnt += n.leftCnt + n.selfCnt;
                n = n.right;
            } else {
                cnt += n.leftCnt;
                break;
            }
        }
        return cnt;
    }

    private int countRange(TreeNode n, long low, long high) {
        return countSmaller(n, high + 1) - countSmaller(n, low);
    }

    private class TreeNode {
        TreeNode left = null, right = null;
        long val; int leftCnt = 0, selfCnt = 1;
        public TreeNode(long v) {
            val = v;
        }
    }
}
