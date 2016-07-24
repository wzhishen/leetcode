package solutions;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/encode-and-decode-strings/
 *
 * Design an algorithm to encode a list of strings to a string. The encoded
 * string is then sent over the network and is decoded back to the original
 * list of strings.
 *
 * Machine 1 (sender) has the function:
 * string encode(vector<string> strs) {
 *   // ... your code
 *   return encoded_string;
 * }
 *
 * Machine 2 (receiver) has the function:
 * vector<string> decode(string s) {
 *   //... your code
 *   return strs;
 * }
 *
 * So Machine 1 does:
 * string encoded_string = encode(strs);
 *
 * and Machine 2 does:
 * vector<string> strs2 = decode(encoded_string);
 * strs2 in Machine 2 should be the same as strs in Machine 1.
 * Implement the encode and decode methods.
 *
 * Note:
 * 1. The string may contain any possible characters out of 256 valid ascii
 * characters. Your algorithm should be generalized enough to work on any
 * possible characters.
 * 2. Do not use class member/global/static variables to store states. Your
 * encode and decode algorithms should be stateless.
 * 3. Do not rely on any library method such as eval or serialize methods.
 * You should implement your own encode/decode algorithm.
 */
public class EncodeAndDecodeStrings_271 {

    /* My format (key is to record string length):
     * <len1>$<str1><len2>$<str2>...<lenN>$<strN>
     * eg.,
     * encode: ["$%^", "", "ab12"] -> "3$$%^0$4$ab12"
     * decode: "3$$%^0$4$ab12" -> ["$%^", "", "ab12"]
     */
    public class Codec {

        // Encodes a list of strings to a single string.
        public String encode(List<String> strs) {
            if (strs == null) return null;
            if (strs.isEmpty()) return "";

            StringBuilder sb = new StringBuilder();
            for (String s : strs) {
                sb.append(s.length()).append("$").append(s);
            }
            return sb.toString();
        }

        // Decodes a single string to a list of strings.
        public List<String> decode(String s) {
            if (s == null) return null;
            List<String> strs = new ArrayList<String>();
            if (s.isEmpty()) return strs;

            int i = 0;
            while (i < s.length()) {
                int j = i + 1;
                while (s.charAt(j) != '$') ++j;
                int len = Integer.parseInt(s.substring(i, j));
                strs.add(s.substring(j + 1, j + 1 + len));
                i = j + 1 + len;
            }
            return strs;
        }
    }

    // Your Codec object will be instantiated and called as such:
    // Codec codec = new Codec();
    // codec.decode(codec.encode(strs));
}
