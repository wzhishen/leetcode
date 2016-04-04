package solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/permutations-ii/
 *
 * Given a collection of numbers that might contain duplicates, return all
 * possible unique permutations.
 *
 * For example,
 * [1,1,2] have the following unique permutations:
 * [1,1,2], [1,2,1], and [2,1,1].
 */
public class PermutationsII_047 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        if (nums == null) return lists;
        Arrays.sort(nums);
        permuteUnique(nums, new ArrayList<Integer>(), lists);
        return lists;
    }

    private final int VISITED = Integer.MAX_VALUE;
    private void permuteUnique(int[] nums, List<Integer> list, List<List<Integer>> lists) {
        if (list.size() == nums.length) {
            lists.add(new ArrayList<Integer>(list));
        } else {
            for (int i = 0; i < nums.length; ++i) {
                int num = nums[i];
                if (num == VISITED) continue;
                nums[i] = VISITED;
                list.add(num);
                permuteUnique(nums, list, lists);
                list.remove(list.size() - 1);
                nums[i] = num;
                while (i < nums.length - 1 && nums[i] == nums[i + 1]) ++i;
            }
        }
    }
}
