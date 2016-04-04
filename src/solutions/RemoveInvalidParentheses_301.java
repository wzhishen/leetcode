package solutions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode.com/problems/remove-invalid-parentheses/
 *
 * Remove the minimum number of invalid parentheses in order to make
 * the input string valid. Return all possible results.
 * Note: The input string may contain letters other than the parentheses
 * ( and ).
 *
 * Examples:
 * "()())()" -> ["()()()", "(())()"]
 * "(a)())()" -> ["(a)()()", "(a())()"]
 * ")(" -> [""]
 */
public class RemoveInvalidParentheses_301 {
    /* BFS: O(n * 2^n) time, O(2^n) space
     *
     * T(n) = n * C(n, n) + (n-1) * C(n, n-1) + ... + 1 * C(n, 1)
     *      = n * 2^(n-1)
     * Ref: http://tinyurl.com/hlytuhq
     */
    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<String>();
        if (s == null) return res;
        Queue<String> q = new LinkedList<String>();
        HashSet<String> visited = new HashSet<String>();
        q.add(s);
        visited.add(s);
        while (!q.isEmpty()) {
            final int size = q.size();
            for (int i = 0; i < size; ++i) {
                String node = q.remove();
                if (isValid(node)) res.add(node);
                if (!res.isEmpty()) continue; // prune
                for (int k = 0; k < node.length(); ++k) {
                    if (node.charAt(k) == '(' || node.charAt(k) == ')') {
                        String adj = node.substring(0, k) + node.substring(k + 1);
                        if (!visited.contains(adj)) {
                            visited.add(adj);
                            q.add(adj);
                        }
                    }
                }
            }
            if (!res.isEmpty()) break;
        }
        return res;
    }

    private boolean isValid(String s) {
        int cnt = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '(') ++cnt;
            else if (s.charAt(i) == ')') --cnt;
            if (cnt < 0) return false;
        }
        return cnt == 0;
    }
}
