package solutions;

import java.util.LinkedList;

/**
 * https://leetcode.com/problems/remove-duplicate-letters/
 *
 * Given a string which contains only lowercase letters, remove duplicate
 * letters so that every letter appear once and only once. You must make
 * sure your result is the smallest in lexicographical order among all
 * possible results.
 *
 * Example:
 * Given "bcabc"
 * Return "abc"
 *
 * Given "cbacdcbc"
 * Return "acdb"
 */
public class RemoveDuplicateLetters_316 {
    /* O(n) time, O(n) space
     * Use a stack to build result, loop over the input string, if current char
     * is smaller than stack top char which occurs later in the input string again,
     * that means stack top char can be removed and added later.
     * Use a char count map to check if a char could occur later again, and a visited
     * set to check if a char is in the stack.
     * Ref: https://www.hrwhisper.me/leetcode-remove-duplicate-letters/
     */
    public String removeDuplicateLetters(String s) {
        int[] cnt = new int[256];
        for (int i = 0; i < s.length(); ++i) ++cnt[s.charAt(i)];

        LinkedList<Character> stack = new LinkedList<Character>();
        boolean[] visited = new boolean[256];
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            --cnt[ch];
            if (visited[ch]) continue;
            while (!stack.isEmpty() && ch < stack.getLast() && cnt[stack.getLast()] > 0) {
                visited[stack.removeLast()] = false;
            }
            stack.addLast(ch);
            visited[ch] = true;
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) sb.append(stack.removeFirst());
        return sb.toString();
    }
}
