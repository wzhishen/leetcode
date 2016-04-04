package solutions;

/**
 * https://leetcode.com/problems/candy/
 *
 * There are N children standing in a line. Each child is assigned a rating
 * value.
 * You are giving candies to these children subjected to the following
 * requirements:
 * 1. Each child must have at least one candy.
 * 2. Children with a higher rating get more candies than their neighbors.
 * What is the minimum candies you must give?
 */
public class Candy_135 {
    public int candy(int[] ratings) {
        if (ratings == null) return 0;
        int[] result = new int[ratings.length];
        result[0] = 1;
        for (int i = 1; i < ratings.length; ++i) {
            if (ratings[i] > ratings[i - 1]) {
                result[i] = result[i - 1] + 1;
            } else {
                result[i] = 1;
            }
        }
        for (int i = ratings.length - 2; i >= 0; --i) {
            if (ratings[i] > ratings[i + 1]) {
                result[i] = Math.max(result[i], result[i + 1] + 1);
            }
        }
        int sum = 0;
        for (int n : result) sum += n;
        return sum;
    }
}
