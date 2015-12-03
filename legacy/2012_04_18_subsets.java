public class Solution {
    // Given a set of distinct integers, S, return all possible subsets.

    // Note:
    // Elements in a subset must be in non-descending order.
    // The solution set must not contain duplicate subsets.
    // For example,
    // If S = [1,2,3], a solution is:

    // [
    //   [3],
    //   [1],
    //   [2],
    //   [1,2,3],
    //   [1,3],
    //   [2,3],
    //   [1,2],
    //   []
    // ]
    
    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
        if (S == null) return null;
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < 1<<S.length; ++i) {
            ret.add(getIthSubset(i, S));
        }
        return ret;
    }
    
    private ArrayList<Integer> getIthSubset(int i, int[] S) {
        ArrayList<Integer> ret = new ArrayList<Integer>();
        for (int k = i, index = 0; k > 0; k >>= 1, ++index) {
            if ((k & 1) > 0) {
                ret.add(S[index]);
            }
        }
        Collections.sort(ret);
        return ret;
    }
}