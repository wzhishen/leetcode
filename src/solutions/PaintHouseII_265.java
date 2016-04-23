package solutions;

/**
 * https://leetcode.com/problems/paint-house-ii/
 *
 * There are a row of n houses, each house can be painted with one of
 * the k colors. The cost of painting each house with a certain color
 * is different. You have to paint all the houses such that no two
 * adjacent houses have the same color.
 *
 * The cost of painting each house with a certain color is represented
 * by a n x k cost matrix. For example, costs[0][0] is the cost of
 * painting house 0 with color 0; costs[1][2] is the cost of painting
 * house 1 with color 2, and so on... Find the minimum cost to paint
 * all houses.
 *
 * Note:
 * All costs are positive integers.
 *
 * Follow up:
 * Could you solve it in O(nk) runtime?
 */
public class PaintHouseII_265 {
    public int minCostII(int[][] costs) {
        if (costs == null || costs.length == 0) return 0;

        for (int i = 1; i < costs.length; ++i) {
            int min1 = Integer.MAX_VALUE, c1 = -1;
            int min2 = Integer.MAX_VALUE;
            for (int j = 0; j < costs[0].length; ++j) {
                if (costs[i - 1][j] < min1) {
                    min2 = min1;
                    min1 = costs[i - 1][j]; c1 = j;
                } else if (costs[i - 1][j] < min2) {
                    min2 = costs[i - 1][j];
                }
            }
            for (int j = 0; j < costs[0].length; ++j) {
                costs[i][j] = costs[i][j] + (c1 != j ? min1 : min2);
            }
        }

        int minCost = Integer.MAX_VALUE;
        for (int c = 0; c < costs[0].length; ++c) {
            minCost = Math.min(minCost, costs[costs.length - 1][c]);
        }
        return minCost;
    }
}
