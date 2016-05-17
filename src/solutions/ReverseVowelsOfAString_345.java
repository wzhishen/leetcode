package solutions;

/**
 * https://leetcode.com/problems/reverse-vowels-of-a-string/
 *
 * Write a function that takes a string as input and reverse only
 * the vowels of a string.
 *
 * Example 1:
 * Given s = "hello", return "holle".
 *
 * Example 2:
 * Given s = "leetcode", return "leotcede".
 */
public class ReverseVowelsOfAString_345 {
    public String reverseVowels(String s) {
        if (s == null) return null;

        char[] str = s.toCharArray();
        int i = 0, j = str.length - 1;
        while (i < j) {
            while (i < j && !isVowel(str[i])) ++i;
            while (i < j && !isVowel(str[j])) --j;
            swap(str, i++, j--);
        }
        return new String(str);
    }

    private boolean isVowel(char c) {
        return "aeiouAEIOU".indexOf(c) != -1;
    }

    private void swap(char[] str, int i, int j) {
        char tmp = str[i];
        str[i] = str[j];
        str[j] = tmp;
    }
}
