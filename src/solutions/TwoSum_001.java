package solutions;
import java.util.HashMap;

/**
 * https://leetcode.com/problems/two-sum/
 *
 * Given an array of integers, find two numbers such that they add up to
 * a specific target number. The function twoSum should return indices of
 * the two numbers such that they add up to the target, where index1 must
 * be less than index2. Please note that your returned answers (both index1
 * and index2) are not zero-based. You may assume that each input would have
 * exactly one solution.
 *
 * Input: numbers={2, 7, 11, 15}, target=9
 * Output: index1=1, index2=2
 */
public class TwoSum_001 {
    public int[] twoSum(int[] nums, int target) {
        if (nums == null) return null;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; ++i) {
            int comp = target - nums[i];
            if (map.containsKey(comp)) {
                return new int[] {map.get(comp) + 1, i + 1};
            }
            map.put(nums[i], i);
        }
        return null;
    }
}
