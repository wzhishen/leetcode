package solutions;

/**
 * https://leetcode.com/problems/strobogrammatic-number/
 *
 * A strobogrammatic number is a number that looks the same when
 * rotated 180 degrees (looked at upside down).
 * Write a function to determine if a number is strobogrammatic.
 * The number is represented as a string.
 *
 * For example, the numbers "69", "88", and "818" are all
 * strobogrammatic.
 */
public class StrobogrammaticNumber_246 {
    public boolean isStrobogrammatic(String num) {
        if (num == null) return false;

        int i = 0, j = num.length() - 1;
        while (i <= j) {
            if (!isMatch(num.charAt(i++), num.charAt(j--))) return false;
        }
        return true;
    }

    private boolean isMatch(char a, char b) {
        return " 01869".charAt("01896".indexOf(a) + 1) == b;
    }

    // Shorter, elegant version: https://leetcode.com/discuss/50594/4-lines-in-java
}
