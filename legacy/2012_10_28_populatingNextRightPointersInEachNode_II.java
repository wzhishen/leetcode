/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    // Follow up for problem "Populating Next Right Pointers in Each 
    // Node".

    // What if the given tree could be any binary tree? Would your 
    // previous solution still work?

    // Note:

    // You may only use constant extra space.
    // For example,
    // Given the following binary tree,
    //          1
    //        /  \
    //       2    3
    //      / \    \
    //     4   5    7
    // After calling your function, the tree should look like:
    //          1 -> NULL
    //        /  \
    //       2 -> 3 -> NULL
    //      / \    \
    //     4-> 5 -> 7 -> NULL

    // the same as "Populating Next Right Pointers in Each 
    // Node"
    public void connect(TreeLinkNode root) {
        if (root == null) return;
        ArrayList<TreeLinkNode> parents = new ArrayList<TreeLinkNode>();
        ArrayList<TreeLinkNode> current = new ArrayList<TreeLinkNode>();
        parents.add(root);
        while (!parents.isEmpty()) {
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