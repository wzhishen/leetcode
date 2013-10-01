public class Solution {
    // Given an array S of n integers, are there elements a, b, c in S such
    // that a + b + c = 0? Find all unique triplets in the array which gives
    // the sum of zero.

    // Note:
    // Elements in a triplet (a,b,c) must be in non-descending order. 
    // (ie, a ≤ b ≤ c)
    // The solution set must not contain duplicate triplets.
    // 
    //     For example, given array S = {-1 0 1 2 -1 -4},

    //     A solution set is:
    //     (-1, 0, 1)
    //     (-1, -1, 2)

    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        if (num == null || num.length < 3) return null;
        Arrays.sort(num);
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < num.length - 2; ++i) {
            int head = i + 1;
            int tail = num.length - 1;
            while (head < tail) {
                int sum = num[i] + num[head] + num[tail];
                if (sum == 0) {
                    ArrayList<Integer> triple = new ArrayList<Integer>();
                    triple.add(num[i]); triple.add(num[head]); triple.add(num[tail]);
                    if (!ret.contains(triple))
                        ret.add(triple);
                    ++head;
                    --tail;
                }
                else if (sum < 0) {
                    ++head;
                }
                else {
                    --tail;
                }
            }
        }
        return ret;
    }
}