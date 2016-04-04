package solutions;

/**
 * https://leetcode.com/problems/integer-to-english-words/
 *
 * Convert a non-negative integer to its english words representation. Given
 * input is guaranteed to be less than 2^31 - 1.
 *
 * For example,
 * 123 -> "One Hundred Twenty Three"
 * 12345 -> "Twelve Thousand Three Hundred Forty Five"
 * 1234567 -> "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
 *
 * Hint:
 * 1. Did you see a pattern in dividing the number into chunk of words? For example,
 *    123 and 123000.
 * 2. Group the number by thousands (3 digits). You can write a helper function that
 *    takes a number less than 1000 and convert just that chunk to words.
 * 3. There are many edge cases. What are some good test cases? Does your code work
 *    with input such as 0? Or 1000010? (middle chunk is zero and should not be printed
 *    out)
 */
public class IntegerToEnglishWords_273 {
    public String numberToWords(int num) {
        if (num < 0) return "Negative " + numberToWords(-num);
        if (num == 0) return "Zero";
        String result = "";
        int i = 0;
        while (num > 0) {
            String words = HundredToWords(num % 1000);
            if (!words.isEmpty()) {
                result = words + bigs[i] + " " + result;
            }
            ++i;
            num /= 1000;
        }
        return result.trim();
    }

    private String HundredToWords(int n) {
        String result = "";
        if (n >= 100) {
            result += digits[n / 100 - 1] + " Hundred ";
            n %= 100;
        }
        if (n >= 20) {
            result += tens[n / 10 - 2] + " ";
            n %= 10;
        }
        if (n >= 10) {
            result += teens[n % 10] + " ";
            n = 0;
        }
        if (n > 0) {
            result += digits[n - 1] + " ";
        }
        return result;
    }

    private final String[] digits = {"One", "Two", "Three","Four", "Five", "Six", "Seven", "Eight", "Nine"};
    private final String[] teens = {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private final String[] tens = {"Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    private final String[] bigs = {"", "Thousand", "Million", "Billion"};
}
