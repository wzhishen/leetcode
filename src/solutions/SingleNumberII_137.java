package solutions;

public class SingleNumberII_137 {
    // O(32*n) time, O(1) space
    public int singleNumber(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        int result = 0;
        for (int i = 0; i <= 31; ++i) {
            int cnt = 0;
            for (int n : nums) {
                if ((n >> i & 1) == 1) ++cnt;
            }
            result |= (cnt % 3) << i;
        }
        return result;
    }
}
