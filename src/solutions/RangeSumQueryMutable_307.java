package solutions;

/**
 * https://leetcode.com/problems/range-sum-query-mutable/
 *
 * Given an integer array nums, find the sum of the elements between indices i
 * and j (i <= j), inclusive.
 * The update(i, val) function modifies nums by updating the element at index i
 * to val.
 *
 * Example:
 * Given nums = [1, 3, 5]
 * sumRange(0, 2) -> 9
 * update(1, 2)
 * sumRange(0, 2) -> 8
 *
 * Note:
 * 1. The array is only modifiable by the update function.
 * 2. You may assume the number of calls to update and sumRange function is
 * distributed evenly.
 */
public class RangeSumQueryMutable_307 {

    public class NumArray {
        /*
         * Use a segment tree
         *
         * build: T(n) = 2T(n/2) + C => T(n) = O(n^log2) = O(n) time
         * update: O(log n) time
         * sumRange: O(log n) time
         *
         * Reference:
         * https://leetcode.com/discuss/71450/java-segmeng-tree-solution-with-explaination
         * http://www.cnblogs.com/Liok3187/p/4978027.html
         */
        private class TreeNode {
            int low = 0, high = 0, sum = 0;
            TreeNode left = null, right = null;
            public TreeNode(int l, int h) {
                low = l; high = h;
            }
        }
        private TreeNode root = null;

        private TreeNode build(int[] nums, int low, int high) {
            TreeNode n = new TreeNode(low, high);
            if (low == high) {
                n.sum = nums[low];
                return n;
            }
            int mid = low + (high - low) / 2;
            n.left = build(nums, low, mid);
            n.right = build(nums, mid + 1, high);
            n.sum = n.left.sum + n.right.sum;
            return n;
        }

        private void update(TreeNode n, int i, int val) {
            if (n == null) return;
            int low = n.low, high = n.high;
            if (low == high) {
                n.sum = val;
                return;
            }
            int mid = low + (high - low) / 2;
            if (i <= mid) {
                update(n.left, i, val);
            } else {
                update(n.right, i, val);
            }
            n.sum = n.left.sum + n.right.sum;
        }

        private int sumRange(TreeNode n, int i, int j) {
            if (n == null) return 0;
            int low = n.low, high = n.high;
            if (i < low || j > high) return 0;
            if (i == low && j == high) return n.sum;

            int mid = low + (high - low) / 2;
            if (j <= mid) {
                return sumRange(n.left, i, j);
            } else if (i >= mid + 1) {
                return sumRange(n.right, i, j);
            } else {
                return sumRange(n.left, i, mid) + sumRange(n.right, mid + 1, j);
            }
        }

        public NumArray(int[] nums) {
            if (nums == null || nums.length == 0) return;
            root = build(nums, 0, nums.length - 1);
        }

        void update(int i, int val) {
            update(root, i, val);
        }

        public int sumRange(int i, int j) {
            return sumRange(root, i, j);
        }
    }


    // Your NumArray object will be instantiated and called as such:
    // NumArray numArray = new NumArray(nums);
    // numArray.sumRange(0, 1);
    // numArray.update(1, 10);
    // numArray.sumRange(1, 2);
}
