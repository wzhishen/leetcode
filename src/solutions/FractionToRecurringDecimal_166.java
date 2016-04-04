package solutions;

import java.util.HashMap;

/**
 * https://leetcode.com/problems/fraction-to-recurring-decimal/
 *
 * Given two integers representing the numerator and denominator of
 * a fraction, return the fraction in string format.
 * If the fractional part is repeating, enclose the repeating part
 * in parentheses.
 *
 * For example,
 * Given numerator = 1, denominator = 2, return "0.5".
 * Given numerator = 2, denominator = 1, return "2".
 * Given numerator = 2, denominator = 3, return "0.(6)".
 *
 * Hint:
 * 1. No scary math, just apply elementary math knowledge. Still
 * remember how to perform a long division?
 * 2. Try a long division on 4/9, the repeating part is obvious.
 * Now try 4/333. Do you see a pattern?
 * 3. Be wary of edge cases! List out as many test cases as you
 * can think of and test your code thoroughly.
 */
public class FractionToRecurringDecimal_166 {
    // Ref: http://tinyurl.com/jxha8h6
    public String fractionToDecimal(int numerator, int denominator) {
        if (denominator == 0) return "";
        if (numerator == 0) return "0";

        String res = "";
        if (numerator < 0 != denominator < 0) res += "-";

        long n = Math.abs((long) numerator), d = Math.abs((long) denominator);
        res += n / d;
        long remainder = n % d * 10;
        if (remainder == 0) return res;

        res += ".";
        HashMap<Long, Integer> map = new HashMap<Long, Integer>();
        while (remainder > 0) {
            if (map.containsKey(remainder)) {
                int pos = map.get(remainder);
                return res.substring(0, pos) + "(" + res.substring(pos) + ")";
            }
            map.put(remainder, res.length());
            res += remainder / d;
            remainder = remainder % d * 10;
        }
        return res;
    }
}
