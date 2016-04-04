package solutions;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/summary-ranges/
 *
 * Given a sorted integer array without duplicates, return the summary of
 * its ranges.
 * For example, given [0,1,2,4,5,7], return ["0->2","4->5","7"].
 */
public class SummaryRanges_228 {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<String>();
        if (nums == null || nums.length == 0) return result;
        for (int i = 0; i < nums.length; ++i) {
            int prev = nums[i];
            while (i < nums.length - 1 && nums[i] + 1 == nums[i + 1]) {
                ++i;
            }
            if (prev == nums[i]) {
                result.add("" + prev);
            } else {
                result.add("" + prev + "->" + nums[i]);
            }
        }
        return result;
    }
}
