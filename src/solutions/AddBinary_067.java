package solutions;

/**
 * Given two binary strings, return their sum (also a binary string).
 *
 * For example,
 * a = "11"
 * b = "1"
 * Return "100".
 */
public class AddBinary_067 {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1, j = b.length() - 1;
        int carry = 0;
        while (i >= 0 || j >= 0 || carry != 0) {
            int sum = 0;
            if (i >= 0) {
                sum += a.charAt(i) - 48;
                --i;
            }
            if (j >= 0) {
                sum += b.charAt(j) - 48;
                --j;
            }
            if (carry > 0) {
                sum += carry;
            }
            int digit = sum % 2;
            carry = sum / 2;
            sb.insert(0, digit);
        }
        return sb.toString();
    }
}
