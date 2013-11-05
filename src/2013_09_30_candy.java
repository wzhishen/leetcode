public class Solution {
    // O(n) time, O(n) space
    public int candy(int[] ratings) {
        // There are N children standing in a line. Each child is 
        // assigned a rating value.

        // You are giving candies to these children subjected to 
        // the following requirements:

        // Each child must have at least one candy.
        // Children with a higher rating get more candies than 
        // their neighbors.
        // What is the minimum candies you must give?

        if (ratings == null || ratings.length == 0) return 0;
        int[] candy = new int[ratings.length];
        candy[0] = 1;
        for (int i = 1; i < ratings.length; ++i) {
            if (ratings[i] > ratings[i - 1]) {
                candy[i] = candy[i - 1] + 1;
            }
            else {
                candy[i] = 1;
            }
        }
        int sum = candy[candy.length - 1];
        for (int i = ratings.length - 2; i >= 0; --i) {
            if (ratings[i] > ratings[i + 1]) {
                candy[i] = Math.max(candy[i], candy[i + 1] + 1);
            }
            else {
                // Do Nothing!
            }
            sum += candy[i];
        }
        return sum;
    }
}