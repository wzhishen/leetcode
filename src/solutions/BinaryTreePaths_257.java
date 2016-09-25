package solutions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import datastructure.TreeNode;

/**
 * https://leetcode.com/problems/binary-tree-paths/
 *
 * Given a binary tree, return all root-to-leaf paths.
 *
 * For example, given the following binary tree:
 *      1
 *    /   \
 *   2     3
 *    \
 *     5
 * All root-to-leaf paths are:
 * ["1->2->5", "1->3"]
 */
public class BinaryTreePaths_257 {
    // DFS
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<String>();
        binaryTreePaths(root, "", result);
        return result;
    }

    private void binaryTreePaths(TreeNode root, String path, List<String> result) {
        if (root == null) return;
        String newPath = path + (path.isEmpty() ? "" : "->") + root.val;
        if (root.left == null && root.right == null) {
            result.add(newPath);
        } else {
            binaryTreePaths(root.left, newPath, result);
            binaryTreePaths(root.right, newPath, result);
        }
    }

    // BFS
    public List<String> binaryTreePaths2(TreeNode root) {
        List<String> res = new LinkedList<>();
        if (root == null) return res;
        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<String> q2 = new LinkedList<>() ;
        q1.add(root); q2.add(root.val + "");
        while (!q1.isEmpty() && !q2.isEmpty()) {
            TreeNode n = q1.remove();
            String path = q2.remove();
            if (n.left != null) {
                q1.add(n.left);
                q2.add(path + "->" + n.left.val);
            }
            if (n.right != null) {
                q1.add(n.right);
                q2.add(path + "->" + n.right.val);
            }
            if (n.left == null && n.right == null) res.add(path);
        }
        return res;
    }
}
