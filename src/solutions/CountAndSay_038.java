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
        if (n <= 1) return "1";
        String s = countAndSay(n - 1);
        StringBuilder sb = new StringBuilder();
        int cnt = 1;
        for (int i = 1; i < s.length(); ++i) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                ++cnt;
            } else {
                sb.append(cnt).append(s.charAt(i - 1));
                cnt = 1;
            }
        }
        return sb.append(cnt).append(s.charAt(s.length() - 1)).toString();
    }
}
