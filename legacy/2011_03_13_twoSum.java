public class Solution {
    // Given an array of integers, find two numbers such that 
    // they add up to a specific target number.

    // The function twoSum should return indices of the two numbers 
    // such that they add up to the target, where index1 must be 
    // less than index2. Please note that your returned answers 
    // (both index1 and index2) are not zero-based.

    // You may assume that each input would have exactly one solution.

    // Input: numbers={2, 7, 11, 15}, target=9
    // Output: index1=1, index2=2
    
    //O(n) time, O(n) space
    public int[] twoSum(int[] numbers, int target) {
            if (numbers == null || numbers.length == 1) return null;
            HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
            for (int i = 0; i < numbers.length; ++i) {
                if (map.containsKey(numbers[i])) {
                    return new int[] {map.get(numbers[i]) + 1, i + 1};
                }
                else {
                    map.put(target - numbers[i], i);
                }
            }
            return null;
        }

    //brute force
    public int[] twoSumNaive(int[] numbers, int target) {
        if (numbers == null || numbers.length == 1) return null;
        for (int i = 0; i < numbers.length; ++i) {
            for (int j = i + 1; j < numbers.length; ++j) {
                if (numbers[i] + numbers[j] == target) {
                    return new int[] {i + 1, j + 1};
                }
            }
        }
        return null;
    }
}