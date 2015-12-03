/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    // Given inorder and postorder traversal of a tree, construct the binary tree.

    // Note:
    // You may assume that duplicates do not exist in the tree.
    
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null || inorder.length == 0 || postorder.length == 0) return null;
        if (inorder.length != postorder.length) return null;
        ArrayList<Integer> in = new ArrayList<Integer>();
        ArrayList<Integer> post = new ArrayList<Integer>();
        for (int i : inorder) in.add(i);
        for (int i = postorder.length - 1; i >= 0; --i) post.add(postorder[i]);
        Iterator<Integer> postiter = post.iterator();
        return buildTree(in, postiter);
    }
    
    private TreeNode buildTree(List<Integer> inorder, Iterator<Integer> postiter) {
        if (inorder.isEmpty()) return null;
        int num = postiter.hasNext() ? postiter.next() : 0;
        int index = getInorderIndex(inorder, num);
        TreeNode n = new TreeNode(num);
        n.right = buildTree(inorder.subList(index + 1, inorder.size()), postiter);
        n.left = buildTree(inorder.subList(0, index), postiter);
        return n;
    }
    
    private int getInorderIndex(List<Integer> inorder, int x) {
        for (int i = 0; i < inorder.size(); ++i) {
            if (inorder.get(i) == x) return i;
        }
        return -1;
    }
}