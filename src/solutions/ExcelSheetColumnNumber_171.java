package solutions;

/**
 * https://leetcode.com/problems/excel-sheet-column-number/
 *
 * Related to question Excel Sheet Column Title
 * Given a column title as appear in an Excel sheet, return its corresponding
 * column number.
 *
 * For example:
 * A -> 1
 * B -> 2
 * C -> 3
 * ...
 * Z -> 26
 * AA -> 27
 * AB -> 28
 */
public class ExcelSheetColumnNumber_171 {
    public int titleToNumber(String s) {
        if (s == null) return -1;
        int sum = 0, base = 1;
        for (int i = s.length() - 1; i >= 0; --i) {
            int num = s.charAt(i) - 'A' + 1;
            sum += num * base;
            base *= 26;
        }
        return sum;
    }
}
