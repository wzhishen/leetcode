package project2026.solutions;

/*
https://leetcode.com/problems/add-binary/description/

Given two binary strings a and b, return their sum as a binary string.



Example 1:

Input: a = "11", b = "1"
Output: "100"

Example 2:

Input: a = "1010", b = "1011"
Output: "10101"


Constraints:

1 <= a.length, b.length <= 104
a and b consist only of '0' or '1' characters.
Each string does not contain leading zeros except for the zero itself.

 */
public class Q0067_AddBinary {
    public String addBinary(String a, String b) {
        int carry = 0;
        int i = a.length() - 1;
        int j = b.length() - 1;
        StringBuilder sb = new StringBuilder();
        while (carry > 0 || i >= 0 || j >= 0) {
            int d1 = i >= 0 ? a.charAt(i) - '0' : 0;
            int d2 = j >= 0 ? b.charAt(j) - '0' : 0;
            int sum = d1 + d2 + carry;
            int d = sum % 2;
            carry = sum / 2;
            sb.append(d);
            --i;
            --j;
        }
        return sb.reverse().toString();
    }

    public String addBinary2(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1, j = b.length() - 1;
        int carry = 0;
        while (i >= 0 || j >= 0 || carry != 0) {
            int sum = 0;
            if (i >= 0) sum += a.charAt(i--) - '0';
            if (j >= 0) sum += b.charAt(j--) - '0';
            if (carry > 0) sum += carry;
            int digit = sum % 2;
            carry = sum / 2;
            sb.append(digit);
        }
        return sb.reverse().toString();
    }
}
