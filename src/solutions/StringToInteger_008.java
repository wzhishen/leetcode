package solutions;

/**
 * https://leetcode.com/problems/string-to-integer-atoi/
 *
 * Implement atoi to convert a string to an integer.
 *
 * Hint: Carefully consider all possible input cases. If you want a challenge,
 * please do not see below and ask yourself what are the possible input cases.
 *
 * Notes: It is intended for this problem to be specified vaguely (ie, no given
 * input specs). You are responsible to gather all the input requirements up front.
 *
 * Spoilers:
 * Requirements for atoi:
 * 1. The function first discards as many whitespace characters as necessary until
 * the first non-whitespace character is found. Then, starting from this character,
 * takes an optional initial plus or minus sign followed by as many numerical
 * digits as possible, and interprets them as a numerical value.
 
 * 2. The string can contain additional characters after those that form the
 * integral number, which are ignored and have no effect on the behavior of this
 * function.
 *
 * 3. If the first sequence of non-whitespace characters in str is not a valid
 * integral number, or if no such sequence exists because either str is empty or
 * it contains only whitespace characters, no conversion is performed.
 *
 * 4. If no valid conversion could be performed, a zero value is returned. If the
 * correct value is out of the range of representable values, INT_MAX (2147483647)
 * or INT_MIN (-2147483648) is returned.
 */
public class StringToInteger_008 {
    public int myAtoi(String str) {
        if (str == null || str.isEmpty()) return 0;
        int s = 0;
        while (s < str.length() && str.charAt(s) == ' ') ++s;
        if (s == str.length()) return 0;

        boolean isNeg = false;
        if (str.charAt(s) == '-' || str.charAt(s) == '+') {
            isNeg = str.charAt(s) == '-';
            ++s;
        }

        int sum = 0;
        for (int i = s; i < str.length(); ++i) {
            if (!isNum(str.charAt(i))) break;
            int digit = str.charAt(i) - '0';
            if (isOverflow(sum, digit)) return isNeg ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            sum = sum * 10 + digit;
        }
        return isNeg ? -sum : sum;
    }

    private boolean isNum(char ch) {
        return ch >= '0' && ch <= '9';
    }

    private boolean isOverflow(int n, int d) {
        return (n > Integer.MAX_VALUE / 10) ||
               (n == Integer.MAX_VALUE / 10 && d > Integer.MAX_VALUE % 10);
    }
}
