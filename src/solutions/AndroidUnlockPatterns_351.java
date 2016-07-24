package solutions;

/**
 * https://leetcode.com/problems/android-unlock-patterns/
 *
 * Given an Android 3x3 key lock screen and two integers m and n, where
 * 1 ≤ m ≤ n ≤ 9, count the total number of unlock patterns of the Android
 * lock screen, which consist of minimum of m keys and maximum n keys.
 *
 * Rules for a valid pattern:
 * 1. Each pattern must connect at least m keys and at most n keys.
 * 2. All the keys must be distinct.
 * 3. If the line connecting two consecutive keys in the pattern passes
 *    through any other keys, the other keys must have previously selected
 *    in the pattern. No jumps through non selected key is allowed.
 * 4. The order of keys used matters.
 *
 * https://discuss.leetcode.com/uploads/files/1461680355228-cptqh.png
 *
 * Explanation:
 * | 1 | 2 | 3 |
 * | 4 | 5 | 6 |
 * | 7 | 8 | 9 |
 * Invalid move: 4 - 1 - 3 - 6 
 * Line 1 - 3 passes through key 2 which had not been selected in the pattern.
 *
 * Invalid move: 4 - 1 - 9 - 2
 * Line 1 - 9 passes through key 5 which had not been selected in the pattern.
 *
 * Valid move: 2 - 4 - 1 - 3 - 6
 * Line 1 - 3 is valid because it passes through key 2, which had been selected
 * in the pattern
 *
 * Valid move: 6 - 5 - 4 - 1 - 9 - 2
 * Line 1 - 9 is valid because it passes through key 5, which had been selected
 * in the pattern.
 *
 * Example:
 * Given m = 1, n = 1, return 9.
 */
public class AndroidUnlockPatterns_351 {
    public int numberOfPatterns(int m, int n) {
        int[][] list = new int[10][10];
        list[1][3] = list[3][1] = 2;
        list[4][6] = list[6][4] = 5;
        list[7][9] = list[9][7] = 8;
        list[1][7] = list[7][1] = 4;
        list[2][8] = list[8][2] = 5;
        list[3][9] = list[9][3] = 6;
        list[1][9] = list[9][1] = 5;
        list[3][7] = list[7][3] = 5;
        boolean[] visited = new boolean[10];
        int cnt = 0;
        for (int i = m; i <= n; ++i) {
            cnt += dfs(list, visited, 1, i - 1) * 4;
            cnt += dfs(list, visited, 2, i - 1) * 4;
            cnt += dfs(list, visited, 5, i - 1);
        }
        return cnt;
    }

    private int dfs(int[][] list, boolean[] visited, int cur, int remain) {
        if (remain == 0) return 1;
        int cnt = 0;
        visited[cur] = true;
        for (int i = 1; i <= 9; ++i) {
            int jump = list[cur][i];
            if (!visited[i] && (jump == 0 || visited[jump])) {
                cnt += dfs(list, visited, i, remain - 1);
            }
        }
        visited[cur] = false;
        return cnt;
    }
}
