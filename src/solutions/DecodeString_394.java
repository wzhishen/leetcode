package solutions;

/**
 * https://leetcode.com/problems/decode-string/
 *
 * Given an encoded string, return it's decoded string.
 *
 * The encoding rule is: k[encoded_string], where the encoded_string
 * inside the square brackets is being repeated exactly k times. Note
 * that k is guaranteed to be a positive integer.
 *
 * You may assume that the input string is always valid; No extra white
 * spaces, square brackets are well-formed, etc.
 *
 * Furthermore, you may assume that the original data does not contain
 * any digits and that digits are only for those repeat numbers, k. For
 * example, there won't be input like 3a or 2[4].
 *
 * Examples:
 * s = "3[a]2[bc]", return "aaabcbc".
 * s = "3[a2[c]]", return "accaccacc".
 * s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
 */
public class DecodeString_394 {
    public String decodeString(String s) {
        String res = "";
        if (s == null || s.isEmpty()) return res;

        int i = 0, j = 0;
        while (j < s.length()) {
            // parse letters
            while (j < s.length() && Character.isLetter(s.charAt(j))) ++j;
            res += s.substring(i, j);
            i = j;
            if (j == s.length()) break; // base case: all are letters

            // parse numbers
            while (j < s.length() && Character.isDigit(s.charAt(j))) ++j;
            int num = Integer.parseInt(s.substring(i, j));
            i = j;

            // parse brackets
            int cnt = 0;
            while (j < s.length()) {
                if (s.charAt(j) == '[') ++cnt;
                else if (s.charAt(j) == ']') --cnt;
                ++j;
                if (cnt == 0) break;
            }

            String repeat = decodeString(s.substring(i + 1, j - 1));
            for (int k = 0; k < num; ++k) res += repeat;
            i = j;
        }
        return res;
    }
}
