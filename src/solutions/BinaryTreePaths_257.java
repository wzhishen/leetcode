package solutions;

import java.util.ArrayList;
import java.util.List;

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
}
