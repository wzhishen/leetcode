package solutions;

/**
 * https://leetcode.com/problems/roman-to-integer/
 *
 * Given a roman numeral, convert it to an integer.
 *
 * Input is guaranteed to be within the range from 1 to 3999.
 */
public class RomanToInteger_013 {
    public int romanToInt(String s) {
        String[] roman = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] integer = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        int res = 0;
        int i = 0;
        while (i < roman.length) {
            if (s.startsWith(roman[i])) {
                res += integer[i];
                s = s.substring(roman[i].length());
            } else {
                ++i;
            }
        }
        return res;
    }
}
