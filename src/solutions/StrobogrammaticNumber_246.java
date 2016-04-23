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
        switch(a) {
            case '0': return b == '0';
            case '1': return b == '1';
            case '6': return b == '9';
            case '8': return b == '8';
            case '9': return b == '6';
        }
        return false;
    }
}
