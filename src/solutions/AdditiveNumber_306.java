package solutions;

import java.math.BigInteger;

/**
 * https://leetcode.com/problems/additive-number/
 *
 * Additive number is a string whose digits can form additive sequence.
 * A valid additive sequence should contain at least three numbers. Except
 * for the first two numbers, each subsequent number in the sequence must
 * be the sum of the preceding two.
 * For example:
 * "112358" is an additive number because the digits can form an additive
 * sequence: 1, 1, 2, 3, 5, 8.
 * 1 + 1 = 2, 1 + 2 = 3, 2 + 3 = 5, 3 + 5 = 8
 *
 * "199100199" is also an additive number, the additive sequence is: 1, 99,
 * 100, 199.
 * 1 + 99 = 100, 99 + 100 = 199
 *
 * Note: Numbers in the additive sequence cannot have leading zeros, so sequence
 * 1, 2, 03 or 1, 02, 3 is invalid.
 *
 * Given a string containing only digits '0'-'9', write a function to determine
 * if it's an additive number.
 *
 * Follow up:
 * How would you handle overflow for very large input integers?
 */
public class AdditiveNumber_306 {
    public boolean isAdditiveNumber(String num) {
        if (num == null) return false;

        for (int i = 1; i <= num.length() / 2; ++i) { // optimize for i < num.length()
            for (int j = i + 1; Math.max(i, j - i) <= num.length() - j; ++j) { // optimize for j < num.length()
                if (isValid(0, i, j, num)) return true;
            }
        }
        return false;
    }

    private boolean isValid(int s, int i, int j, String num) {
        if (j == num.length()) return true;
        if (num.charAt(s) == '0' && i - s > 1) return false;
        if (num.charAt(i) == '0' && j - i > 1) return false;
        BigInteger a = new BigInteger(num.substring(s, i));
        BigInteger b = new BigInteger(num.substring(i, j));
        String sum = a.add(b).toString();
        return num.startsWith(sum, j) && isValid(i, j, j + sum.length(), num);
    }
}
