package solutions;

/**
 * https://leetcode.com/problems/jump-game-ii/
 *
 * Given an array of non-negative integers, you are initially positioned at
 * the first index of the array.
 * Each element in the array represents your maximum jump length at that
 * position.
 * Your goal is to reach the last index in the minimum number of jumps.
 *
 * For example:
 * Given array A = [2,3,1,1,4]
 * The minimum number of jumps to reach the last index is 2. (Jump 1 step
 * from index 0 to 1, then 3 steps to the last index.)
 *
 * Note:
 * You can assume that you can always reach the last index.
 */
public class JumpGameII_045 {
    /* Reference:
     * http://www.cnblogs.com/lichen782/p/leetcode_Jump_Game_II.html
     */
    public int jump(int[] nums) {
        if (nums == null) return 0;

        int maxJump = 0, lastMaxJump = 0, cnt = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (i > lastMaxJump) {
                ++cnt;
                lastMaxJump = maxJump;
            }
            maxJump = Math.max(maxJump, i + nums[i]);
        }
        if (maxJump < nums.length - 1) return 0;
        return cnt;
    }
}
