package solutions;

/**
 * https://leetcode.com/problems/one-edit-distance/
 *
 * Given two strings S and T, determine if they are both one edit
 * distance apart.
 */
public class OneEditDistance_161 {
    public boolean isOneEditDistance(String s, String t) {
        if (s == null || t == null) return false;

        // let's assume s.length() <= t.length()
        if (s.length() > t.length()) return isOneEditDistance(t, s);

        if (t.length() - s.length() >= 2) return false;
        else if (t.length() - s.length() == 1) return isOneRemoved(s, t);
        else return isOneReplaced(s, t);
    }

    private boolean isOneRemoved(String s, String t) {
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) != t.charAt(i)) {
                return s.substring(i).equals(t.substring(i + 1));
            }
        }
        return true;
    }

    private boolean isOneReplaced(String s, String t) {
        int cnt = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) != t.charAt(i)) {
                if (++cnt >= 2) return false;
            }
        }
        return cnt == 1;
    }
}
