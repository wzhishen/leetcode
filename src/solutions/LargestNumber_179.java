package solutions;

import java.util.Arrays;
import java.util.Comparator;

/**
 * https://leetcode.com/problems/largest-number/
 *
 * Given a list of non negative integers, arrange them such that they form
 * the largest number.
 *
 * For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.
 * Note: The result may be very large, so you need to return a string instead
 * of an integer.
 */
public class LargestNumber_179 {
    public String largestNumber(int[] nums) {
        if (nums == null) return null;
        Integer[] list = new Integer[nums.length];
        for (int i = 0; i < nums.length; ++i) {
            list[i] = nums[i];
        }
        Arrays.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer n1, Integer n2) {
                String s1 = String.valueOf(n1);
                String s2 = String.valueOf(n2);
                return (s2 + s1).compareTo(s1 + s2);
                /* Same as:
                 * if ((s1 + s2).compareTo(s2 + s1) > 0) return -1;
                 * else if ((s1 + s2).compareTo(s2 + s1) == 0) return 0;
                 * else return 1;
                 */
            }
        });
        if (list[0] == 0) return "0";
        StringBuilder sb = new StringBuilder();
        for (Integer n : list) sb.append(n);
        return sb.toString();
    }
}
