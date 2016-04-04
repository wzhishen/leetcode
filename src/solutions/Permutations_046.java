package solutions;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/permutations/
 *
 * Given a collection of distinct numbers, return all possible permutations.
 *
 * For example,
 * [1,2,3] have the following permutations:
 * [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
 */
public class Permutations_046 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        if (nums == null) return lists;
        permute(nums, new ArrayList<Integer>(), lists);
        return lists;
    }

    private final int VISITED = Integer.MAX_VALUE;
    private void permute(int[] nums, List<Integer> list, List<List<Integer>> lists) {
        if (list.size() == nums.length) {
            lists.add(new ArrayList<Integer>(list));
        } else {
            for (int i = 0; i < nums.length; ++i) {
                int num = nums[i];
                if (num == VISITED) continue;
                nums[i] = VISITED;
                list.add(num);
                permute(nums, list, lists);
                list.remove(list.size() - 1);
                nums[i] = num;
            }
        }
    }
}
