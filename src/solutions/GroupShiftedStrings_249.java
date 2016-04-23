package solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * https://leetcode.com/problems/group-shifted-strings/
 *
 * Given a string, we can "shift" each of its letter to its successive
 * letter, for example: "abc" -> "bcd". We can keep "shifting" which forms
 * the sequence:
 * "abc" -> "bcd" -> ... -> "xyz"
 * Given a list of strings which contains only lowercase alphabets, group
 * all strings that belong to the same shifting sequence.
 *
 * For example, given: ["abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"],
 * Return:
 * [
 *   ["abc","bcd","xyz"],
 *   ["az","ba"],
 *   ["acef"],
 *   ["a","z"]
 * ]
 *
 * Note:
 * For the return value, each inner list's elements must follow the
 * lexicographic order.
 */
public class GroupShiftedStrings_249 {
    public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> res = new ArrayList<List<String>>();
        if (strings == null) return res;

        Arrays.sort(strings);
        HashMap<String, List<String>> map = new HashMap<String, List<String>>();
        for (String s : strings) {
            String key = getKey(s);
            if (!map.containsKey(key)) map.put(key, new ArrayList<String>());
            map.get(key).add(s);
        }

        for (String k : map.keySet()) res.add(map.get(k));
        return res;
    }

    private String getKey(String s) {
        StringBuilder sb = new StringBuilder();
        int diff = s.charAt(0) - 'a';
        sb.append('a');
        for (int i = 1; i < s.length(); ++i) {
            int ch = s.charAt(i) - diff;
            if (ch < 'a') ch += 26;
            sb.append((char) ch);
        }
        return sb.toString();
    }
}
