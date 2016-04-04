package solutions;

public class MinimumWindowSubstring_076 {
    // O(n) time, O(n) space
    public String minWindow(String s, String t) {
        if (s == null || t == null) return null;
        char[] S = s.toCharArray();
        char[] T = t.toCharArray();

        int[] tmap = new int[256];
        int[] smap = new int[256];
        for (char ch : T) ++tmap[ch];

        int minLen = Integer.MAX_VALUE, minI = 0, len = 0;
        int i = 0, j = 0;
        while (j < S.length) {
            ++smap[S[j]];
            if (smap[S[j]] <= tmap[S[j]]) ++len;
            if (len == T.length) {
                while (smap[S[i]] > tmap[S[i]]) {
                    --smap[S[i]];
                    ++i;
                }
                if (j - i + 1 < minLen) {
                    minLen = j - i + 1;
                    minI = i;
                }
                // trigger next search
                --smap[S[i]];
                ++i;
                --len;
            }
            ++j;
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(minI, minI + minLen);
    }
}
