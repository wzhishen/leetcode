package solutions;

/**
 * https://leetcode.com/problems/reverse-string/
 *
 * Write a function that takes a string as input and returns the
 * string reversed.
 *
 * Example:
 * Given s = "hello", return "olleh".
 */
public class ReverseString_344 {
    public String reverseString(String s) {
        if (s == null) return null;

        char[] str = s.toCharArray();
        int i = 0, j = str.length - 1;
        while (i < j) {
            char tmp = str[i];
            str[i] = str[j];
            str[j] = tmp;
            ++i; --j;
        }
        return new String(str);
    }

    public String reverseString2(String s) {
        return s == null || s.length() <= 1 ? s :
        reverseString2(s.substring(s.length() / 2)) + reverseString2(s.substring(0, s.length() / 2));
    }
}
