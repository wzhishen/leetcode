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
    /* Hard part is figuring out when to add 0s to both ends:
     * we don't want 0s appear on the outermost ends (like 000,
     * 010, 080, etc).
     */
    public List<String> findStrobogrammatic(int n) {
        return findStrobogrammatic(n, true);
    }

    private List<String> findStrobogrammatic(int n, boolean original) {
        if (n <= 0) return Arrays.asList("");
        if (n == 1) return Arrays.asList("0", "1", "8");

        List<String> prev = findStrobogrammatic(n - 2, false);
        List<String> res = new ArrayList<>();
        for (String p : prev) {
            if (!original) res.add("0" + p + "0");
            res.add("1" + p + "1");
            res.add("6" + p + "9");
            res.add("8" + p + "8");
            res.add("9" + p + "6");
        }
        return res;
    }
}
