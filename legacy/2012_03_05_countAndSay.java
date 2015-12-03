public class Solution {
    // The count-and-say sequence is the sequence of integers 
    // beginning as follows:
    // 1, 11, 21, 1211, 111221, ...

    // 1 is read off as "one 1" or 11.
    // 11 is read off as "two 1s" or 21.
    // 21 is read off as "one 2, then one 1" or 1211.
    // Given an integer n, generate the nth sequence.

    // Note: The sequence of integers will be represented as a 
    // string.

    public String countAndSay(int n) {
        if (n <= 0) return null;
        if (n == 1) return "1";
        String last = countAndSay(n - 1);
        char prev = last.charAt(0);
        int cnt = 1;
        StringBuffer sb = new StringBuffer();
        for (int i = 1; i < last.length(); ++i) {
            if (last.charAt(i) == prev) {
                ++cnt;
            }
            else {
                sb.append(cnt).append(prev);
                cnt = 1;
                prev = last.charAt(i);
            }
        }
        sb.append(cnt).append(prev);
        return sb.toString();
    }
}