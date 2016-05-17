package solutions;

/**
 * https://leetcode.com/problems/zigzag-conversion/
 *
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given
 * number of rows like this: (you may want to display this pattern in a
 * fixed font for better legibility)
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 *
 * Write the code that will take a string and make this conversion given
 * a number of rows:
 * string convert(string text, int nRows);
 * convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
 */
public class ZigZagConversion_006 {
    /* O(n) time, O(n) space
     * Ref: https://leetcode.com/discuss/10493/easy-to-understand-java-solution
     */
    public String convert(String s, int numRows) {
        if (s == null || numRows <= 0) return "";

        StringBuilder[] sb = new StringBuilder[numRows];
        for (int i = 0; i < numRows; ++i) sb[i] = new StringBuilder();

        int i = 0;
        while (i < s.length()) {
            int row = 0;
            while (row < numRows && i < s.length()) {
                sb[row++].append(s.charAt(i++));
            }
            row = numRows - 2;
            while (row >= 1 && i < s.length()) {
                sb[row--].append(s.charAt(i++));
            }
        }

        for (i = 1; i < numRows; ++i) sb[0].append(sb[i]);
        return sb[0].toString();
    }
}
