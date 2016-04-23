package solutions;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/strobogrammatic-number-iii/
 *
 * A strobogrammatic number is a number that looks the same when
 * rotated 180 degrees (looked at upside down).
 * Write a function to count the total strobogrammatic numbers that
 * exist in the range of low <= num <= high.
 *
 * For example,
 * Given low = "50", high = "100", return 3. Because 69, 88, and 96
 * are three strobogrammatic numbers.
 *
 * Note:
 * Because the range might be a large number, the low and high numbers
 * are represented as string.
 */
public class StrobogrammaticNumberIII_248 {
    public int strobogrammaticInRange(String low, String high) {
        if (low == null || high == null) return -1;

        int cnt = 0;
        for (int i = low.length(); i <= high.length(); ++i) {
            cnt += findStrobogrammatic(i, low, high).size();
        }
        return cnt;
    }

    final String[] first = {"0", "1", "8"};
    final String[] second = {"11", "69", "88", "96"};

    private List<String> findStrobogrammatic(int n, String low, String high) {
        List<String> res = new ArrayList<String>();
        if (n <= 0) {
            return res;
        } else if (n == 1) {
            for (String s : first) {
                if (greaterThan(s, high)) return res; // prune to speed up
                if (inRange(s, low, high)) res.add(s);
            }
        } else if (n == 2) {
            for (String s : second) {
                if (greaterThan(s, high)) return res; // prune to speed up
                if (inRange(s, low, high)) res.add(s);
            }
        } else if ((n & 1) == 1) {
            List<String> prev = findStrobogrammatic(n - 1, low, high);
            for (String num : prev) {
                String left = num.substring(0, n / 2), right = num.substring(n / 2);
                for (String center : first) {
                    String s = left + center + right;
                    if (greaterThan(s, high)) return res; // prune to speed up
                    if (inRange(s, low, high)) res.add(s);
                }
            }
        } else {
            List<String> prev = findStrobogrammatic(n - 2, low, high);
            for (String num : prev) {
                String left = num.substring(0, (n - 1) / 2), right = num.substring((n - 1) / 2);
                String s = left + "00" + right;
                if (inRange(s, low, high)) res.add(s);
                for (String center : second) {
                    s = left + center + right;
                    if (greaterThan(s, high)) return res; // prune to speed up
                    if (inRange(s, low, high)) res.add(s);
                }
            }
        }
        return res;
    }

    private boolean inRange(String s, String low, String high) {
        if (s.length() == low.length() && s.compareTo(low) < 0) return false;
        if (greaterThan(s, high)) return false;
        return true;
    }

    private boolean greaterThan(String s, String high) {
        return s.length() == high.length() && s.compareTo(high) > 0;
    }
}
