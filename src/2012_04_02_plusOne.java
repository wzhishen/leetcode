public class Solution {
    public int[] plusOne(int[] digits) {
        // Given a number represented as an array of digits, plus one to the number.
        
        if (digits == null || digits.length == 0) return null;
        int carry = 0;
        for (int i = digits.length - 1; i >= 0; --i) {
            if (digits[i] == 9) {
                if (i == digits.length - 1 || carry > 0) {
                    digits[i] = 0;
                    carry = 1;
                }
            }
            else {
                if (i == digits.length - 1) {
                    ++digits[i];
                }
                else if (carry > 0) {
                    digits[i] = digits[i] + carry;
                    carry = 0;
                }
            }
        }
        if (carry > 0) {
            int[] ret = new int[digits.length + 1];
            ret[0] = 1;
            // Don't even need the following lines since 
            // this case will always be 1000...000
            // 
            // int n = 1;
            // for (int i : digits) ret[n++] = i;
            return ret;
        }
        return digits;
    }
}