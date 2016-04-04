package solutions;

/**
 * https://leetcode.com/problems/integer-to-roman/
 *
 * Given an integer, convert it to a roman numeral.
 *
 * Input is guaranteed to be within the range from 1 to 3999.
 */
public class IntegerToRoman_012 {
    public String intToRoman(int num) {
        String[] roman = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] integer = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String res = "";
        for (int i = 0; i < integer.length; ++i) {
            int n = num / integer[i];
            while (n-- > 0) res += roman[i];
            num %= integer[i];
        }
        return res;
    }
}
