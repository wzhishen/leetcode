package solutions;

import java.util.Stack;

public class VerifyPreorderSerializationOfABinaryTree_331 {
    /* Merge X## into #. A valid tree serialization leads to a single # at the end.
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
