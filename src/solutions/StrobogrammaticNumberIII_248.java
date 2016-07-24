package solutions;

import java.util.ArrayList;
import java.util.Arrays;
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
        List<String> res = new ArrayList<>();
        for (int i = low.length(); i <= high.length(); ++i) res.addAll(find(i, true));
        int cnt = 0;
        for (String n : res) {
            if (inRange(n, low, high)) ++cnt;
        }
        return cnt;
    }

    private List<String> find(int n, boolean original) {
        if (n == 0) return Arrays.asList("");
        if (n == 1) return Arrays.asList("0", "1", "8");

        List<String> res = new ArrayList<String>();
        List<String> list = find(n - 2, false);
        for (String num : list) {
            if (!original) res.add("0" + num + "0");
            res.add("1" + num + "1");
            res.add("6" + num + "9");
            res.add("8" + num + "8");
            res.add("9" + num + "6");
        }
        return res;
    }

    private boolean inRange(String n, String low, String high) {
        if (n.length() == low.length() && n.compareTo(low) < 0) return false;
        if (n.length() == high.length() && n.compareTo(high) > 0) return false;
        return true;
    }
}
