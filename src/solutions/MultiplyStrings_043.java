package solutions;

/**
 * https://leetcode.com/problems/multiply-strings/
 *
 * Given two numbers represented as strings, return multiplication of
 * the numbers as a string.
 * Note: The numbers can be arbitrarily large and are non-negative.
 */
public class MultiplyStrings_043 {
    public String multiply(String n1, String n2) {
        if (n1 == null || n2 == null) return null;

        int len1 = n1.length(), len2 = n2.length();
        int[] res = new int[len1 + len2];

        for (int i = len2 - 1; i >= 0; --i) {
            int d2 = n2.charAt(i) - '0';
            int carry = 0;
            for (int j = len1 - 1; j >= 0; --j) {
                int d1 = n1.charAt(j) - '0';
                // key: current digit maps to res[i + j + 1]
                int num = d1 * d2 + carry + res[i + j + 1];
                int d = num % 10;
                carry = num / 10;
                res[i + j + 1] = d;
            }
            if (carry > 0) res[i] = carry;
        }

        String n = "";
        int i = 0;
        while (i < res.length - 1 && res[i] == 0) ++i;
        while (i < res.length) n += res[i++];
        return n;
    }
}
