package solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import datastructure.TreeNode;

/**
 * https://leetcode.com/problems/binary-tree-vertical-order-traversal/
 *
 * Given a binary tree, return the vertical order traversal of its
 * nodes' values. (ie, from top to bottom, column by column).
 * If two nodes are in the same row and column, the order should be
 * from left to right.
 *
 * Examples:
 * 1. Given binary tree [3,9,20,null,null,15,7],
 *   3
 *  /\
 * /  \
 * 9  20
 *    /\
 *   /  \
 *  15   7
 * return its vertical order traversal as:
 * [
 *   [9],
 *   [3,15],
 *   [20],
 *   [7]
 * ]
 * 2. Given binary tree [3,9,8,4,0,1,7],
 *      3
 *     /\
 *    /  \
 *    9   8
 *   /\  /\
 *  /  \/  \
 *  4  01   7
 * return its vertical order traversal as:
 * [
 *   [4],
 *   [9],
 *   [3,0,1],
 *   [8],
 *   [7]
 * ]
 * 3. Given binary tree [3,9,8,4,0,1,7,null,null,null,2,5]
 * (0's right child is 2 and 1's left child is 5),
 *      3
 *     /\
 *    /  \
 *    9   8
 *   /\  /\
 *  /  \/  \
 *  4  01   7
 *     /\
 *    /  \
 *    5   2
 * return its vertical order traversal as:
 * [
 *   [4],
 *   [9,5],
 *   [3,0,1],
 *   [8,2],
 *   [7]
 * ]
 */
public class BinaryTreeVerticalOrderTraversal_314 {
    /* The question doesn't explain the meaning of "column" very clearly:
     * If a node's column is i, then its left child's column is i-1, right
     * child's column is i+1.
     *
     * Key: maintain a hash table that maps column number to a list of node
     * values.
     * Maintain a queue for column number as well, or can wrap column number
     * in TreeNode.
     * Ref: http://www.cnblogs.com/EdwardLiu/p/5093131.html
     */
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (root == null) return res;

        Queue<TreeNode> q = new LinkedList<TreeNode>();
        Queue<Integer> colQ = new LinkedList<Integer>();
        HashMap<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        int min = 0, max = 0; // to fast reconstruct result from map

        q.add(root);
        colQ.add(0);
        while (!q.isEmpty()) { // just do BFS, no need to do level order traversal
            TreeNode node = q.remove();
            int col = colQ.remove();
            if (!map.containsKey(col)) map.put(col, new ArrayList<Integer>());
            map.get(col).add(node.val);
            if (node.left != null) {
                q.add(node.left);
                colQ.add(col - 1);
            }
            if (node.right != null) {
                q.add(node.right);
                colQ.add(col + 1);
            }
            min = Math.min(min, col);
            max = Math.max(max, col);
        }

        for (int i = min; i <= max; ++i) {
            res.add(map.get(i));
        }
        return res;
    }
}
