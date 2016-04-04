package solutions;

/**
 * https://leetcode.com/problems/count-and-say/
 *
 * The count-and-say sequence is the sequence of integers beginning as
 * follows:
 * 1, 11, 21, 1211, 111221, ...
 * 1 is read off as "one 1" or 11.
 * 11 is read off as "two 1s" or 21.
 * 21 is read off as "one 2, then one 1" or 1211.
 * Given an integer n, generate the nth sequence.
 *
 * Note: The sequence of integers will be represented as a string.
 */
public class CountAndSay_038 {
    public String countAndSay(int n) {
        if (n <= 0) return null;
        if (n == 1) return "1";
        String s = countAndSay(n - 1);
        char prev = s.charAt(0);
        int cnt = 1;
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < s.length(); ++i) {
            char curr = s.charAt(i);
            if (curr == prev) {
                ++cnt;
            } else {
                sb.append(cnt).append(prev);
                cnt = 1;
                prev = curr;
            }
        }
        sb.append(cnt).append(prev);
        return sb.toString();
    }
}
