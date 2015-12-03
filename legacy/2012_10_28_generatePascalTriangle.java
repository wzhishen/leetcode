public class Solution {
    // Given numRows, generate the first numRows of Pascal's triangle.

    // For example, given numRows = 5,
    // Return

    // [
    //      [1],
    //     [1,1],
    //    [1,2,1],
    //   [1,3,3,1],
    //  [1,4,6,4,1]
    // ]
    
    public ArrayList<ArrayList<Integer>> generate(int numRows) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if (numRows <= 0) return res;
        ArrayList<Integer> level = new ArrayList<Integer>();
        if (numRows >= 1) {
            level.add(1);
            res.add((ArrayList<Integer>)level.clone());
        }
        if (numRows >= 2) {
            level.add(1);
            res.add((ArrayList<Integer>)level.clone());
        }
        ArrayList<Integer> prev = new ArrayList<Integer>(level);
        for (int i = 3; i <= numRows; ++i) {
            level.clear();
            level.add(1);
            for (int j = 0; j < prev.size() - 1; ++j) {
                level.add(prev.get(j) + prev.get(j + 1));
            }
            level.add(1);
            res.add((ArrayList<Integer>)level.clone());
            prev = (ArrayList<Integer>)level.clone();
        }
        return res;
    }
}