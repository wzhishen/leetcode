package solutions;

import java.util.ArrayList;
import java.util.List;

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
