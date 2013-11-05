/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    // Given a binary tree

    //     struct TreeLinkNode {
    //       TreeLinkNode *left;
    //       TreeLinkNode *right;
    //       TreeLinkNode *next;
    //     }
    // Populate each next pointer to point to its next right node. 
    // If there is no next right node, the next pointer should be 
    // set to NULL.

    // Initially, all next pointers are set to NULL.

    // Note:

    // You may only use constant extra space.
    // You may assume that it is a perfect binary tree (ie, all 
    // leaves are at the same level, and every parent has two children).
    // For example,
    // Given the following perfect binary tree,
    //          1
    //        /  \
    //       2    3
    //      / \  / \
    //     4  5  6  7
    // After calling your function, the tree should look like:
    //          1 -> NULL
    //        /  \
    //       2 -> 3 -> NULL
    //      / \  / \
    //     4->5->6->7 -> NULL

    public void connect(TreeLinkNode root) {
        if (root == null) return;
        ArrayList<TreeLinkNode> parents = new ArrayList<TreeLinkNode>();
        ArrayList<TreeLinkNode> current = new ArrayList<TreeLinkNode>();
        parents.add(root);
        while (!parents.isEmpty()) {
            // connect to next node
            for (int i = 0; i < parents.size() - 1; ++i) {
                parents.get(i).next = parents.get(i + 1);
            }
            for (TreeLinkNode p : parents) {
                if (p.left != null) current.add(p.left);
                if (p.right != null) current.add(p.right);
            }
            parents = current;
            current = new ArrayList<TreeLinkNode>();
        }
    }
}