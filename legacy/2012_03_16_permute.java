public class Solution {
    // Given a collection of numbers, return all possible permutations.

    // For example,
    // [1,2,3] have the following permutations:
    // [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
    
    public ArrayList<ArrayList<Integer>> permute(int[] num) {
        if (num == null) return null;
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        if (num.length == 0) {
            ret.add(new ArrayList<Integer>());
            return ret;
        }
        ArrayList<ArrayList<Integer>> last = permute(Arrays.copyOfRange(num, 1, num.length));
        for (ArrayList<Integer> subset : last) {
            for (int i = 0; i <= subset.size(); ++i) {
                ArrayList<Integer> newset = new ArrayList<Integer>(subset);
                newset.add(i, num[0]);
                ret.add(newset);
            }
        }
        return ret;
    }
}