public class Solution {
    // Given a collection of numbers that might contain duplicates, return all possible unique permutations.

    // For example,
    // [1,1,2] have the following unique permutations:
    // [1,1,2], [1,2,1], and [2,1,1].
    
    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        if (num == null) return null;
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        if (num.length == 0) {
            ret.add(new ArrayList<Integer>());
            return ret;
        }
        ArrayList<ArrayList<Integer>> last = permuteUnique(Arrays.copyOfRange(num, 1, num.length));
        for (ArrayList<Integer> subset : last) {
            for (int i = 0; i <= subset.size(); ++i) {
                ArrayList<Integer> newset = new ArrayList<Integer>(subset);
                newset.add(i, num[0]);
                if (!ret.contains(newset)) ret.add(newset); //check duplicates
            }
        }
        return ret;
    }
}