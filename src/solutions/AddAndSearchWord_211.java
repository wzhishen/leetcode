package solutions;

import java.util.HashMap;

/**
 * https://leetcode.com/problems/add-and-search-word-data-structure-design/
 *
 * Design a data structure that supports the following two operations:
 * void addWord(word)
 * bool search(word)
 *
 * search(word) can search a literal word or a regular expression string
 * containing only letters a-z or .. A . means it can represent any one
 * letter.
 *
 * For example:
 * addWord("bad")
 * addWord("dad")
 * addWord("mad")
 * search("pad") -> false
 * search("bad") -> true
 * search(".ad") -> true
 * search("b..") -> true
 *
 * Note:
 * You may assume that all words are consist of lowercase letters a-z.
 */
public class AddAndSearchWord_211 {

    public class WordDictionary {
        class Node {
            char ch; boolean isWord;
            HashMap<Character, Node> map;
            public Node(char c) {
                ch = c; isWord = false; map = new HashMap<Character, Node>();
            }
        }
        private Node root = new Node('\0');

        // Adds a word into the data structure.
        public void addWord(String word) {
            if (word == null) return;
            Node n = root;
            for (int i = 0; i < word.length(); ++i) {
                char ch = word.charAt(i);
                if (!n.map.containsKey(ch)) {
                    n.map.put(ch, new Node(ch));
                }
                n = n.map.get(ch);
            }
            n.isWord = true;
        }

        // Returns if the word is in the data structure. A word could
        // contain the dot character '.' to represent any one letter.
        public boolean search(String word) {
            if (word == null) return false;
            return search(word, root, 0);
        }

        private boolean search(String word, Node n, int index) {
            if (index == word.length()) {
                return n.isWord;
            } else {
                char ch = word.charAt(index);
                if (ch == '.') {
                    for (char k : n.map.keySet()) {
                        if (search(word, n.map.get(k), index + 1)) return true;
                    }
                    return false;
                } else if (n.map.containsKey(ch)) {
                    return search(word, n.map.get(ch), index + 1);
                } else {
                    return false;
                }
            }
        }
    }

    // Your WordDictionary object will be instantiated and called as such:
    // WordDictionary wordDictionary = new WordDictionary();
    // wordDictionary.addWord("word");
    // wordDictionary.search("pattern");
}
