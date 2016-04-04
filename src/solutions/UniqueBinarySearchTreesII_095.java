package solutions;

import java.util.ArrayList;
import java.util.List;

import datastructure.TreeNode;

/**
 * https://leetcode.com/problems/unique-binary-search-trees-ii/
 *
 * For example,
 * Given n = 3, your program should return all 5 unique BST's shown below.
 *  1         3     3      2      1
 *   \       /     /      / \      \
 *    3     2     1      1   3      2
 *   /     /       \                 \
 *  2     1         2                 3
 */
public class UniqueBinarySearchTreesII_095 {
    public List<TreeNode> generateTrees(int n) {
        if (n <= 0) return new ArrayList<TreeNode>();
        return generateTrees(1, n);
    }

    // Divide and Conquer
    private List<TreeNode> generateTrees(int min, int max) {
        List<TreeNode> result = new ArrayList<TreeNode>();
        if (min > max) {
            result.add(null);
        } else {
            for (int i = min; i <= max; ++i) {
                List<TreeNode> leftTrees = generateTrees(min, i - 1);
                List<TreeNode> rightTrees = generateTrees(i + 1, max);
                for (TreeNode leftTree : leftTrees) {
                    for (TreeNode rightTree: rightTrees) {
                        TreeNode n = new TreeNode(i);
                        n.left = leftTree;
                        n.right = rightTree;
                        result.add(n);
                    }
                }
            }
        }
        return result;
    }
}
