package solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * https://leetcode.com/problems/word-search-ii/
 *
 * Given a 2D board and a list of words from the dictionary, find all words
 * in the board.
 * Each word must be constructed from letters of sequentially adjacent cell,
 * where "adjacent" cells are those horizontally or vertically neighboring.
 * The same letter cell may not be used more than once in a word.
 *
 * For example,
 * Given words = ["oath","pea","eat","rain"] and board =
 * [
 *   ['o','a','a','n'],
 *   ['e','t','a','e'],
 *   ['i','h','k','r'],
 *   ['i','f','l','v']
 * ]
 * Return ["eat","oath"].
 *
 * Note:
 * You may assume that all inputs are consist of lowercase letters a-z.
 *
 * Hint:
 * You would need to optimize your backtracking to pass the larger test.
 * Could you stop backtracking earlier?
 * If the current candidate does not exist in all words' prefix, you could
 * stop backtracking immediately. What kind of data structure could answer
 * such query efficiently? Does a hash table work? Why or why not? How about
 * a Trie? If you would like to learn how to implement a basic trie, please
 * work on this problem: Implement Trie (Prefix Tree) first.
 */
public class WordSearchII_212 {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<String>();
        if(board == null || board.length == 0 || words == null || words.length == 0) return result;

        TrieNode root = new TrieNode('\0');
        for (String word : words) addWord(root, word);

        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[0].length; ++j) {
                findWords(board, root, i, j, "", result);
            }
        }
        return result;
    }

    private void findWords(char[][] board, TrieNode n, int i, int j, String word, List<String> result) {
        if (i < 0 || i > board.length - 1 || j < 0 || j > board[0].length - 1) return;
        char ch = board[i][j];
        if (ch == '\0' || !n.map.containsKey(ch)) return;

        board[i][j] = '\0'; // mark visited
        n = n.map.get(ch);
        if (n.isWord) {
            result.add(word + ch);
            n.isWord = false; // avoid adding duplicate result
        }
        findWords(board, n, i - 1, j, word + ch, result);
        findWords(board, n, i + 1, j, word + ch, result);
        findWords(board, n, i, j - 1, word + ch, result);
        findWords(board, n, i, j + 1, word + ch, result);
        board[i][j] = ch;
    }

    class TrieNode {
        char ch;
        boolean isWord;
        HashMap<Character, TrieNode> map;
        public TrieNode(char c) {
            ch = c; isWord = false; map = new HashMap<Character, TrieNode>();
        }
    }

    public void addWord(TrieNode n, String word) {
        for (int i = 0; i < word.length(); ++i) {
            char ch = word.charAt(i);
            if (!n.map.containsKey(ch)) {
                n.map.put(ch, new TrieNode(ch));
            }
            n = n.map.get(ch);
        }
        n.isWord = true;
    }
}
