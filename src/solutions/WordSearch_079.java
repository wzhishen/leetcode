package solutions;

/**
 * https://leetcode.com/problems/word-search/
 *
 * Given a 2D board and a word, find if the word exists in the grid.
 * The word can be constructed from letters of sequentially adjacent cell,
 * where "adjacent" cells are those horizontally or vertically neighboring.
 * The same letter cell may not be used more than once.
 *
 * For example,
 * Given board =
 * [
 *   ['A','B','C','E'],
 *   ['S','F','C','S'],
 *   ['A','D','E','E']
 * ]
 * word = "ABCCED", -> returns true,
 * word = "SEE",    -> returns true,
 * word = "ABCB",   -> returns false.
 */
public class WordSearch_079 {
    public boolean exist(char[][] board, String word) {
        if(board == null || board.length == 0 || word == null) return false;
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[0].length; ++j) {
                if (search(board, word, 0, i , j)) return true;
            }
        }
        return false;
    }

    private boolean search(char[][] board, String word, int index, int i, int j) {
        if (index == word.length()) return true;
        if (i < 0 || i > board.length - 1 || j < 0 || j > board[0].length - 1) return false;
        char ch = board[i][j];
        if (ch == '\0' || word.charAt(index) != ch) return false;

        board[i][j] = '\0';
        boolean exist = search(board, word, index + 1, i - 1, j) ||
                        search(board, word, index + 1, i + 1, j) ||
                        search(board, word, index + 1, i, j - 1) ||
                        search(board, word, index + 1, i, j + 1);
        board[i][j] = ch;
        return exist;
    }
}
