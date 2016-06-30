package solutions;

/**
 * https://leetcode.com/problems/remove-element/
 *
 * Given an array and a value, remove all instances of that value in place
 * and return the new length.
 * The order of elements can be changed. It doesn't matter what you leave
 * beyond the new length.
 *
 * Example:
 * Given input array nums = [3,2,2,3], val = 3
 * Your function should return length = 2, with the first two elements of
 * nums being 2.
 *
 * Hint:
 * 1. Try two pointers.
 * 2. Did you use the property of "the order of elements can be changed"?
 * 3. What happens when the elements to remove are rare?
 */
public class RemoveElement_027 {
    /*
     * Copy nums[i] (current element) to nums[index] (result array border)
     * only when nums[i] is not target.
     *
     * Write heavy if elements to remove are rare; good when elements to
     * remove are plenty.
     */
    public int removeElement(int[] nums, int val) {
        if (nums == null) return -1;
        int p = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] != val) {
                nums[p++] = nums[i];
            }
        }
        return p;
    }

    /*
     * While (left <= right):
     * if nums[left] is not target, simply ++left;
     * if nums[left] is target, copy nums[right] to nums[left] and --right,
     *    but don't ++left since nums[right] being copied might be target.
     *
     * Write heavy if elements to remove are plenty; good when elements to
     * remove are rare.
     */
    public int removeElement2(int[] nums, int val) {
        if (nums == null) return -1;
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            if (nums[left] != val) {
                ++left;
            } else {
                nums[left] = nums[right];
                --right;
            }
        }
        return left;
    }
}
