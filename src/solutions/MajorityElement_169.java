package solutions;

/**
 * https://leetcode.com/problems/majority-element/
 *
 * Given an array of size n, find the majority element. The majority element
 * is the element that appears more than |_n/2_| times.
 * You may assume that the array is non-empty and the majority element always
 * exist in the array.
 */
public class MajorityElement_169 {
    // Moore Voting: O(n) time, O(1) space
    public int majorityElement(int[] nums) {
        int result = 0;
        int cnt = 0;
        for (int n : nums) {
            if (n == result) {
                ++cnt;
            } else if (cnt == 0) {
                result = n;
                cnt = 1;
            } else {
                --cnt;
            }
        }
        return result;
    }

    // O(32*n) time, O(1) space
    public int majorityElement2(int[] nums) {
        int result = 0;
        for (int i = 0; i <= 31; ++i) {
            int cnt = 0;
            for (int n : nums) {
                cnt += (n >> i) & 1;
            }
            if (cnt > nums.length / 2) {
                result |= (1 << i);
            }
        }
        return result;
    }
}
