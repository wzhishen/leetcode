package solutions;

/**
 * https://leetcode.com/problems/excel-sheet-column-title/
 *
 * Given a positive integer, return its corresponding column title as appear
 * in an Excel sheet.
 *
 * For example:
 * 1 -> A
 * 2 -> B
 * 3 -> C
 * ...
 * 26 -> Z
 * 27 -> AA
 * 28 -> AB
 */
public class ExcelSheetColumnTitle_168 {
    public String convertToTitle(int n) {
        return n <= 0 ? "" : convertToTitle((n - 1) / 26) + (char)('A' + (n - 1) % 26);
    }

    public String convertToTitle2(int n) {
        StringBuilder sb = new StringBuilder();
        if (n <= 0) return sb.toString();
        while (n > 0) {
            sb.insert(0, (char)('A' + (n - 1) % 26));
            n = (n - 1) / 26;
        }
        return sb.toString();
    }
}
