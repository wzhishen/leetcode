package solutions;

import java.util.Stack;

/**
 * https://leetcode.com/problems/verify-preorder-serialization-of-a-binary-tree/
 *
 * One way to serialize a binary tree is to use pre-order traversal. When we
 * encounter a non-null node, we record the node's value. If it is a null node,
 * we record using a sentinel value such as #.
 *
 *      _9_
 *     /   \
 *    3     2
 *   / \   / \
 *  4   1  #  6
 * / \ / \   / \
 * # # # #   # #
 *
 * For example, the above binary tree can be serialized to the string
 * "9,3,4,#,#,1,#,#,2,#,6,#,#", where # represents a null node.
 * Given a string of comma separated values, verify whether it is a correct
 * preorder traversal serialization of a binary tree. Find an algorithm without
 * reconstructing the tree.
 * Each comma separated value in the string must be either an integer or a
 * character '#' representing null pointer.
 * You may assume that the input format is always valid, for example it could
 * never contain two consecutive commas such as "1,,3".
 *
 * Example 1:
 * "9,3,4,#,#,1,#,#,2,#,6,#,#"
 * Return true
 *
 * Example 2:
 * "1,#"
 * Return false
 *
 * Example 3:
 * "9,#,#,1"
 * Return false
 */
public class VerifyPreorderSerializationOfABinaryTree_331 {
    /* Delete leaves: merge X## into #. A valid tree serialization leads to a
     * single # at the end.
     * O(n) time, O(n) space
     */
    public boolean isValidSerialization(String preorder) {
        if (preorder == null) return false;
        Stack<String> s = new Stack<String>();
        String[] tokens = preorder.split(",");
        for (String token : tokens) {
            s.push(token);
            while (s.size() >= 3 &&
                   s.get(s.size() - 1).equals("#") &&
                   s.get(s.size() - 2).equals("#") &&
                   !s.get(s.size() - 3).equals("#")) {
                s.pop(); s.pop(); s.pop();
                s.push("#");
            }
        }
        return s.size() == 1 && s.peek().equals("#");
    }

    /* A valid tree serialization leads to total indegree equal to total outdegree.
     * root: 0 indeg, 2 outdeg
     * node: 1 indeg, 2 outdeg
     * null node: 1 indeg, 0 outdeg
     * At any time, indegree should never exceed outdegree in a valid tree.
     * O(n) time, O(1) space
     *
     * Ref: https://leetcode.com/discuss/83824/7-lines-easy-java-solution
     */
    public boolean isValidSerialization2(String preorder) {
        if (preorder == null) return false;
        int indegree = -1; // make up for root indegree 0
        int outdegree = 0;
        String[] tokens = preorder.split(",");
        for (String token : tokens) {
            ++indegree;
            if (indegree > outdegree) return false;
            if (!token.equals("#")) outdegree += 2;
        }
        return indegree == outdegree;
    }
}
