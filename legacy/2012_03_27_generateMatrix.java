public class Solution {
    // Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

    // For example,
    // Given n = 3,

    // You should return the following matrix:
    // [
    //  [ 1, 2, 3 ],
    //  [ 8, 9, 4 ],
    //  [ 7, 6, 5 ]
    // ]
    
    public int[][] generateMatrix(int n) {
        if (n < 0) return null;
        int [][] ret = new int [n][n]; //note that n can be 0 here
        int cnt = 0;
        for (int layer = 0; layer < n / 2; ++layer) {
            for (int i = layer; i < n - layer - 1; ++i) {
                ret[layer][i] = ++cnt;
            }
            for (int i = layer; i < n - layer - 1; ++i) {
                ret[i][n - layer - 1] = ++cnt;
            }
            for (int i = layer; i < n - layer - 1; ++i) {
                ret[n - layer - 1][n - i - 1] = ++cnt;
            }
            for (int i = layer; i < n - layer - 1; ++i) {
                ret[n - i - 1][layer] = ++cnt;
            }
        }
        if (n % 2 == 1) ret[n/2][n/2] = ++cnt;
        return ret;
    }
}