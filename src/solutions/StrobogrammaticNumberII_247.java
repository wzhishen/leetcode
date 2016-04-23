package solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/strobogrammatic-number-ii/
 *
 * A strobogrammatic number is a number that looks the same when
 * rotated 180 degrees (looked at upside down).
 * Find all strobogrammatic numbers that are of length = n.
 *
 * For example,
 * Given n = 2, return ["11","69","88","96"].
 *
 * Hint:
 * Try to use recursion and notice that it should recurse with
 * n - 2 instead of n - 1.
 */
public class StrobogrammaticNumberII_247 {
    public List<String> findStrobogrammatic(int n) {
        List<String> res = new ArrayList<String>();
        if (n <= 0) return res;
        if (n == 1) return Arrays.asList(new String[] {"0", "1", "8"});
        if (n == 2) return Arrays.asList(new String[] {"11", "88", "69", "96"});
        if ((n & 1) == 1) {
            List<String> prev = findStrobogrammatic(n - 1);
            for (String num : prev) {
                res.add(num.substring(0, n / 2) + "0" + num.substring(n / 2));
                res.add(num.substring(0, n / 2) + "1" + num.substring(n / 2));
                res.add(num.substring(0, n / 2) + "8" + num.substring(n / 2));
            }
        } else {
            List<String> prev = findStrobogrammatic(n - 2);
            for (String num : prev) {
                res.add(num.substring(0, (n - 1) / 2) + "00" + num.substring((n - 1) / 2));
                res.add(num.substring(0, (n - 1) / 2) + "11" + num.substring((n - 1) / 2));
                res.add(num.substring(0, (n - 1) / 2) + "88" + num.substring((n - 1) / 2));
                res.add(num.substring(0, (n - 1) / 2) + "69" + num.substring((n - 1) / 2));
                res.add(num.substring(0, (n - 1) / 2) + "96" + num.substring((n - 1) / 2));
            }
        }
        return res;
    }
}
