package project2026.solutions;

import project2026.datastructure.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/*
https://leetcode.com/problems/serialize-and-deserialize-binary-tree/

Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.

Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.

Clarification: The input/output format is the same as how LeetCode serializes a binary tree. You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.



Example 1:
https://assets.leetcode.com/uploads/2020/09/15/serdeser.jpg

Input: root = [1,2,3,null,null,4,5]
Output: [1,2,3,null,null,4,5]

Example 2:

Input: root = []
Output: []


Constraints:

The number of nodes in the tree is in the range [0, 104].
-1000 <= Node.val <= 1000

 */
public class Q0297_SerializeAndDeserializeBinaryTree {
        // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        return sb.toString();
    }
    private void serialize(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("#,");
            return;
        }
        sb.append(root.val).append(",");
        serialize(root.left, sb);
        serialize(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        LinkedList<String> nodes = new LinkedList<>(Arrays.asList(data.split(",")));
        return deserialize(nodes);
    }
    private TreeNode deserialize(LinkedList<String> nodes) {
        // if (nodes.isEmpty()) return null;
        String node = nodes.removeFirst();
        if ("#".equals(node)) return null;
        TreeNode root = new TreeNode(Integer.parseInt(node));
        root.left = deserialize(nodes);
        root.right = deserialize(nodes);
        return root;
    }

    /*
     * Level order serialize/deserialize
     */

     public String serialize2(TreeNode root) {
         if (root == null) return "#";
         StringBuilder sb = new StringBuilder();
         Queue<TreeNode> q = new LinkedList<>();
         q.offer(root);
         while (!q.isEmpty()) {
             int size = q.size();
             for (int i = 0; i < size; ++i) {
                 TreeNode n = q.poll();
                 if (n == null) {
                     sb.append("#,");
                     continue;
                 }
                 sb.append(n.val).append(",");
                 q.offer(n.left);
                 q.offer(n.right);
             }
         }
         return sb.toString();
     }

     public TreeNode deserialize2(String data) {
         String[] nodes = data.split(",");
         if ("#".equals(nodes[0])) return null;

         Queue<TreeNode> q = new LinkedList<>();
         TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
         q.offer(root);
         int p = 1;
         while (!q.isEmpty()) {
             int size = q.size();
             // for (int i = 0; i < size; ++i) {
                 TreeNode n = q.poll();
                 String left = nodes[p];
                 if (!"#".equals(left)) {
                     n.left = new TreeNode(Integer.parseInt(left));
                     q.offer(n.left);
                 }
                 ++p;
                 String right = nodes[p];
                 if (!"#".equals(right)) {
                     n.right = new TreeNode(Integer.parseInt(right));
                     q.offer(n.right);
                 }
                 ++p;
             // }
         }
         return root;
     }
}
