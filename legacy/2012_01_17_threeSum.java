public class Solution {
    // Given an array S of n integers, are there elements a, b, c 
    // in S such that a + b + c = 0? Find all unique triplets in 
    // the array which gives the sum of zero.

    // Note:
    // Elements in a triplet (a,b,c) must be in non-descending order.
    // (ie, a ≤ b ≤ c)
    // The solution set must not contain duplicate triplets.
    //     For example, given array S = {-1 0 1 2 -1 -4},

    //     A solution set is:
    //     (-1, 0, 1)
    //     (-1, -1, 2)

    // use a hashtable, O(n^2) time, O(n) space
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        if (num == null || num.length < 3) return new ArrayList<ArrayList<Integer>>();
        HashSet<ArrayList<Integer>> ret = new HashSet<ArrayList<Integer>>();
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < num.length - 1; ++i) {
            for (int j = i + 1; j < num.length; ++j) {
                if (map.containsKey(num[j])) {
                    ArrayList<Integer> triple = new ArrayList<Integer>();
                    triple.add(num[i]);
                    triple.add(num[map.get(num[j])]);
                    triple.add(num[j]);
                    Collections.sort(triple);
                    ret.add(triple);
                }
                else {
                    int target = 0 - num[i];
                    map.put(target - num[j], j);
                }
            }
            map.clear();
        }
        return new ArrayList<ArrayList<Integer>>(ret);
    }
    
    // two-pointers, O(n^2) time, O(1) space
    public ArrayList<ArrayList<Integer>> threeSum2(int[] num) {
        if (num == null || num.length < 3) return new ArrayList<ArrayList<Integer>>();
        HashSet<ArrayList<Integer>> ret = new HashSet<ArrayList<Integer>>();
        Arrays.sort(num);
        for (int i = 0; i < num.length - 2; ++i) {
            int head = i + 1;
            int tail = num.length - 1;
            while (head < tail) {
                int sum = num[i] + num[head] + num[tail];
                if (sum == 0) {
                    ArrayList<Integer> triple = new ArrayList<Integer>();
                    triple.add(num[i]); triple.add(num[head]); triple.add(num[tail]);
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
        return new ArrayList<ArrayList<Integer>>(ret);
    }
}