package solutions;

import java.util.Arrays;
import java.util.LinkedList;

import datastructure.TreeNode;

/**
 * https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
 *
 * Serialization is the process of converting a data structure or object into
 * a sequence of bits so that it can be stored in a file or memory buffer, or
 * transmitted across a network connection link to be reconstructed later in
 * the same or another computer environment.
 *
 * Design an algorithm to serialize and deserialize a binary tree. There is no
 * restriction on how your serialization/deserialization algorithm should work.
 * You just need to ensure that a binary tree can be serialized to a string and
 * this string can be deserialized to the original tree structure.
 *
 * For example, you may serialize the following tree
 *     1
 *    / \
 *   2   3
 *      / \
 *     4   5
 * as "[1,2,3,null,null,4,5]", just the same as how LeetCode OJ serializes a binary
 * tree. You do not necessarily need to follow this format, so please be creative
 * and come up with different approaches yourself.
 *
 * Note: Do not use class member/global/static variables to store states. Your
 * serialize and deserialize algorithms should be stateless.
 */
public class SerializeAndDeserializeBinaryTree_297 {
    /* Use pre-order traversal to (de)serialize */

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        return sb.toString();
    }

    private void serialize(TreeNode n, StringBuilder sb) {
        if (n == null) {
            sb.append("#,");
        } else {
            sb.append(n.val).append(",");
            serialize(n.left, sb);
            serialize(n.right, sb);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        return deserialize(new LinkedList<>(Arrays.asList(data.split(","))));
    }

    private TreeNode deserialize(LinkedList<String> list) {
        String token = list.remove();
        if (token.equals("#")) return null;
        TreeNode n = new TreeNode(Integer.parseInt(token));
        n.left = deserialize(list);
        n.right = deserialize(list);
        return n;
    }
}
