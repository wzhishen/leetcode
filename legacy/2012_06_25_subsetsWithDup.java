public class Solution {
    // Given a collection of integers that might contain duplicates, S, return all possible subsets.

    // Note:
    // Elements in a subset must be in non-descending order.
    // The solution set must not contain duplicate subsets.
    // For example,
    // If S = [1,2,2], a solution is:

    // [
    //   [2],
    //   [1],
    //   [1,2,2],
    //   [2,2],
    //   [1,2],
    //   []
    // ]
    
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
        if (num == null) return null;
        Arrays.sort(num);
        return subsetsWithDupHelper(num);
    }
    
    private ArrayList<ArrayList<Integer>> subsetsWithDupHelper(int[] num) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        if (num.length == 0) {
            ret.add(new ArrayList<Integer>());
            return ret;
        }
        ArrayList<ArrayList<Integer>> last = subsetsWithDupHelper(Arrays.copyOfRange(num, 1, num.length));
        ret.addAll(last);
        for (ArrayList<Integer> subset : last) {
            ArrayList<Integer> newset = new ArrayList<Integer>(subset);
            newset.add(0, num[0]);
            if (!ret.contains(newset)) ret.add(newset);
        }
        return ret;
    }
}