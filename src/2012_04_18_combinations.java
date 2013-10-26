public class Solution {
    // Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

    // For example,
    // If n = 4 and k = 2, a solution is:

    // [
    //   [2,4],
    //   [3,4],
    //   [2,3],
    //   [1,2],
    //   [1,3],
    //   [1,4],
    // ]
    
    // iterative
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        if (n < 1 || k < 1) return null;
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> set = new ArrayList<Integer>();
        for (int i = 1; i <= n; ++i) set.add(i);
        for (int i = 0; i < 1<<n; ++i) {
            ArrayList<Integer> res = intToSubset(set, i, k);
            if (res != null) ret.add(res);
        }
        return ret;
    }
    
    private ArrayList<Integer> intToSubset(ArrayList<Integer> set, int n, int k) {
        ArrayList<Integer> ret = new ArrayList<Integer>();
        for (int i = n, index = 0; i > 0; i >>= 1, ++index) {
            if ((i & 1) > 0) {
                ret.add(set.get(index));
                if (ret.size() > k) return null;
            }
        }
        return ret.size() == k ? ret : null;
    }
    
    // naive recursive
    public ArrayList<ArrayList<Integer>> combineRecursive(int n, int k) {
        if (n < 1 || k < 1) return null;
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        if (k == 1) {
            for (int i = 1; i <= n; ++i) {
                ret.add(new ArrayList<Integer>(i));
            }
            return ret;
        }
        ArrayList<ArrayList<Integer>> last = combineRecursive(n, k - 1);
        for (ArrayList<Integer> subset : last) {
            for (int i = 1; i <= n; ++i) {
                ArrayList<Integer> newset = new ArrayList<Integer>(subset);
                newset.add(i);
                if (!ret.contains(newset)) ret.add(newset);
            }
        }
        return ret;
    }
}