package solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import datastructure.TreeNode;

/**
 * https://leetcode.com/problems/binary-tree-right-side-view/
 *
 * Given a binary tree, imagine yourself standing on the right side of it, return
 * the values of the nodes you can see ordered from top to bottom.
 *
 * For example:
 * Given the following binary tree,
 *    1            <---
 *  /   \
 * 2     3         <---
 *  \     \
 *   5     4       <---
 * You should return [1, 3, 4].
 */
public class BinaryTreeRightSideView_199 {
    // BFS
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if (root == null) return res;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        while (!q.isEmpty()) {
            final int size = q.size();
            for (int i = 0; i < size; ++i) {
                TreeNode n = q.remove();
                if (i == size - 1) res.add(n.val);
                if (n.left != null) q.add(n.left);
                if (n.right != null) q.add(n.right);
            }
        }
        return res;
    }

    // DFS
    public List<Integer> rightSideView2(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if (root == null) return res;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        dfs(root, map, 0);
        int depth = 0;
        while (map.containsKey(depth)) {
            res.add(map.get(depth++));
        }
        return res;
    }

    private void dfs(TreeNode n, HashMap<Integer, Integer> map, int depth) {
        if (n == null) return;
        map.put(depth, n.val);
        dfs(n.left, map, depth + 1);
        dfs(n.right, map, depth + 1);
    }
}
