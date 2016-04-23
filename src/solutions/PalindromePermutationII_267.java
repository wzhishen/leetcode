package solutions;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/palindrome-permutation-ii/
 *
 * Given a string s, return all the palindromic permutations (without
 * duplicates) of it. Return an empty list if no palindromic permutation
 * could be form.
 *
 * For example:
 * Given s = "aabb", return ["abba", "baab"].
 * Given s = "abc", return [].
 *
 * Hint:
 * 1. If a palindromic permutation exists, we just need to generate the 
 * first half of the string.
 * 2. To generate all distinct permutations of a (half of) string, use a
 * similar approach from: Permutations II or Next Permutation.
 */
public class PalindromePermutationII_267 {
    public List<String> generatePalindromes(String s) {
        List<String> res = new ArrayList<String>();
        if (s == null) return res;

        int[] map = new int[256];
        for (int i = 0; i < s.length(); ++i) ++map[s.charAt(i)];
        List<Character> list = new ArrayList<Character>();
        String center = "";
        for (int i = 0; i < map.length; ++i) {
            if ((map[i] & 1) == 1) {
                if (!center.isEmpty()) return res;
                else center += (char) i;
            }
            for (int j = 0; j < map[i] / 2; ++j) list.add((char) i);
        }

        permute(res, "", list, center);

        return res;
    }

    private void permute(List<String> res, String cur, List<Character> list, String center) {
        if (cur.length() == list.size()) {
            StringBuilder sb = new StringBuilder(cur);
            res.add(cur + center + sb.reverse().toString());
        } else {
            for (int i = 0; i < list.size(); ++i) {
                Character ch = list.get(i);
                if (ch == null) continue;
                list.set(i, null);
                permute(res, cur + ch, list, center);
                list.set(i, ch);
                while (i < list.size() - 1 && list.get(i) == list.get(i + 1)) ++i;
            }
        }
    }
}
