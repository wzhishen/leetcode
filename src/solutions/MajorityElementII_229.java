package solutions;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/majority-element-ii/
 *
 * Given an integer array of size n, find all elements that appear more than
 * ⌊ n/3⌋ times. The algorithm should run in linear time and in O(1) space.
 *
 * Hint:
 * How many majority elements could it possibly have?
 */
public class MajorityElementII_229 {
    // O(2*n) time, O(1) space
    public List<Integer> majorityElement(int[] nums) {
        int res1 = 0, res2 = 0;
        int cnt1 = 0, cnt2 = 0;
        for (int n : nums) {
            if (cnt1 == 0) {
                res1 = n;
                cnt1 = 1;
            } else if (n == res1) {
                ++cnt1;
            } else if (cnt2 == 0) {
                res2 = n;
                cnt2 = 1;
            } else if (n == res2) {
                ++cnt2;
            } else {
                --cnt1;
                --cnt2;
            }
        }
        cnt1 = cnt2 = 0;
        for (int n : nums) {
            if (n == res1) ++cnt1;
            else if (n == res2) ++cnt2;
        }
        List<Integer> result = new ArrayList<Integer>();
        if (cnt1 > nums.length / 3) result.add(res1);
        if (cnt2 > nums.length / 3) result.add(res2);
        return result;
    }
}
