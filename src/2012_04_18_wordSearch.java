public class Solution {
    public boolean exist(char[][] board, String word) {
        // Given a 2D board and a word, find if the word exists in the grid.

        // The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

        // For example,
        // Given board =

        // [
        //   ["ABCE"],
        //   ["SFCS"],
        //   ["ADEE"]
        // ]
        // word = "ABCCED", -> returns true,
        // word = "SEE", -> returns true,
        // word = "ABCB", -> returns false.
        
        if (board == null || board.length == 0 || word == null || word.isEmpty()) 
            return false;
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[0].length; ++j) {
                if (hasWord(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    private boolean hasWord(char[][] board, String word, int i, int j, int index) {
        if (index == word.length())
            return true;
        if (i < 0 || j < 0 || i > board.length - 1 || j > board[0].length - 1) 
            return false;
        if (board[i][j] != word.charAt(index))
            return false;
        char ch = board[i][j];
        board[i][j] = '*'; // mark read
        boolean res = 
            hasWord(board, word, i + 1, j, index + 1) ||
            hasWord(board, word, i, j + 1, index + 1) ||
            hasWord(board, word, i - 1, j, index + 1) ||
            hasWord(board, word, i, j - 1, index + 1);
        board[i][j] = ch;
        return res;
    }
}