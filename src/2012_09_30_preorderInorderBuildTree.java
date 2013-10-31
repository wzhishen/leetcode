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
    // Given preorder and inorder traversal of a tree, construct the binary tree.

    // Note:
    // You may assume that duplicates do not exist in the tree.
    
    // use an iterator
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || 
            preorder.length == 0 || inorder.length == 0) return null;
        if (preorder.length != inorder.length) return null;
        
        List<Integer> pre = new ArrayList<Integer>();
        List<Integer> in  = new ArrayList<Integer>();
        for (int i : preorder) pre.add(i);
        for (int i :  inorder) in.add(i);
        return buildTreeHelper(pre.iterator(), in);
    }
    
    private TreeNode buildTreeHelper(Iterator<Integer> preiter, List<Integer> in) {
        if (in.isEmpty()) return null;
        int val = preiter.hasNext() ? preiter.next() : 0;
        TreeNode node = new TreeNode(val);
        int index = searchInorderIndex(in, val);
        node.left = buildTreeHelper(preiter, in.subList(0, index));
        node.right = buildTreeHelper(preiter, in.subList(index + 1, in.size()));
        return node;
    }
    
    private int searchInorderIndex(List<Integer> inorder, int n) {
        for (int i = 0; i < inorder.size(); ++i) {
            if (inorder.get(i) == n) return i;
        }
        return -1;
    }

    //------------------------------------------------------------

    // use global var
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || 
            preorder.length == 0 || inorder.length == 0) return null;
        if (preorder.length != inorder.length) return null;
        return buildTreeHelper(preorder, inorder, 0, inorder.length - 1);
    }
    
    static int preIndex = 0;
    
    private static TreeNode buildTreeHelper(int[] preorder, int[] inorder, int inIndexStart, int inIndexEnd) {
        if (preIndex > preorder.length - 1) return null;
        if (inIndexStart > inIndexEnd) return null;
        int val = preorder[preIndex++];
        TreeNode node = new TreeNode(val);
        if (inIndexStart == inIndexEnd) return node;
        int inIndex = searchInorderIndex(inorder, val);
        node.left = buildTreeHelper(preorder, inorder, inIndexStart, inIndex - 1);
        node.right = buildTreeHelper(preorder, inorder, inIndex + 1, inIndexEnd);
        return node;
    }
    
    private static int searchInorderIndex(int[] inorder, int n) {
        for (int i = 0; i < inorder.length; ++i) {
            if (inorder[i] == n) return i;
        }
        return -1;
    }
}