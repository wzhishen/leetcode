package solutions;

/**
 * https://leetcode.com/problems/plus-one/
 *
 * Given a non-negative number represented as an array of digits, plus
 * one to the number.
 * The digits are stored such that the most significant digit is at the
 * head of the list.
 */
public class PlusOne_066 {
    public int[] plusOne(int[] digits) {
        int i = digits.length - 1;
        int sum = digits[i] + 1;
        int carry = sum / 10;
        digits[i] = sum % 10;
        while (carry > 0) {
            --i;
            if (i < 0) {
                int[] ret = new int[digits.length + 1];
                ret[0] = 1;
                return ret;
            }
            sum = digits[i] + carry;
            carry = sum / 10;
            digits[i] = sum % 10;
        }
        return digits;
    }
}
