package solutions;

import java.util.HashSet;

/**
 * https://leetcode.com/problems/contains-duplicate/
 *
 * Given an array of integers, find if the array contains any duplicates.
 * Your function should return true if any value appears at least twice
 * in the array, and it should return false if every element is distinct.
 */
public class ContainsDuplicate_217 {
    public boolean containsDuplicate(int[] nums) {
        if (nums == null) return false;
        HashSet<Integer> set = new HashSet<Integer>();
        for (int num : nums) {
            if (set.contains(num)) return true;
            else set.add(num);
        }
        return false;
    }
}
