package solutions;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/two-sum-iii-data-structure-design/
 *
 * Design and implement a TwoSum class. It should support the following
 * operations: add and find.
 * add - Add the number to an internal data structure.
 * find - Find if there exists any pair of numbers which sum is equal to
 * the value.
 *
 * For example,
 * add(1); add(3); add(5);
 * find(4) -> true
 * find(7) -> false
 */
public class TwoSumIII_170 {
    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

    // Add the number to an internal data structure.
    public void add(int number) {
        int cnt = 1;
        if (map.containsKey(number)) cnt += map.get(number);
        map.put(number, cnt);
    }

    // Find if there exists any pair of numbers which sum is equal to the value.
    public boolean find(int target) {
        // iterate over entrySet instead of keySet to lower TLE errors
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();
            int comp = target - key;
            if (map.containsKey(comp)) {
                if (comp != key) return true;
                else if (value >= 2) return true;
            }
        }
        return false;
    }

// Your TwoSum object will be instantiated and called as such:
// TwoSum twoSum = new TwoSum();
// twoSum.add(number);
// twoSum.find(value);
}
