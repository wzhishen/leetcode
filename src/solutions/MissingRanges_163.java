package solutions;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/missing-ranges/
 *
 * Given a sorted integer array where the range of elements are
 * [lower, upper] inclusive, return its missing ranges.
 *
 * For example, given [0, 1, 3, 50, 75], lower = 0 and upper = 99,
 * return ["2", "4->49", "51->74", "76->99"].
 */
public class MissingRanges_163 {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res = new ArrayList<String>();
        if (nums == null) return res;

        if (nums.length == 0) {
            res.add(makeRange(lower, upper));
            return res;
        }

        int n = nums.length - 1;
        if (lower < nums[0]) res.add(makeRange(lower, nums[0] - 1));
        for (int i = 1; i <= n; ++i) {
            if (nums[i] != nums[i - 1] + 1) {
                res.add(makeRange(nums[i - 1] + 1, nums[i] - 1));
            }
        }
        if (upper > nums[n]) res.add(makeRange(nums[n] + 1, upper));
        return res;
    }

    private String makeRange(int low, int high) {
        return low == high ? "" + low : low + "->" + high;
    }

    // Shorter: https://leetcode.com/discuss/86020/simple-java-code
}
