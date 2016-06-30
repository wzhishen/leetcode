package solutions;

/**
 * https://leetcode.com/problems/implement-trie-prefix-tree/
 *
 * Implement a trie with insert, search, and startsWith methods.
 *
 * Note:
 * You may assume that all inputs are consist of lowercase letters a-z.
 */
public class ImplementTrie_208 {

    class TrieNode {
        // Initialize your data structure here.
        public TrieNode() {
            map = new TrieNode[26];
            isWord = false;
        }
        TrieNode[] map;
        boolean isWord;
    }

    public class Trie {
        private TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        // Inserts a word into the trie.
        public void insert(String word) {
            if (word == null) return;
            TrieNode n = root;
            for (int i = 0; i < word.length(); ++i) {
                char ch = word.charAt(i);
                int index = ch - ('a' - '\0');
                if (n.map[index] == null) {
                    n.map[index] = new TrieNode();
                }
                n = n.map[index];
            }
            n.isWord = true;
        }

        // Returns if the word is in the trie.
        public boolean search(String word) {
            return find(word, true);
        }

        // Returns if there is any word in the trie
        // that starts with the given prefix.
        public boolean startsWith(String prefix) {
            return find(prefix, false);
        }

        private boolean find(String prefix, boolean checkIsWord) {
            if (prefix == null) return false;
            TrieNode n = root;
            for (int i = 0; i < prefix.length(); ++i) {
                char ch = prefix.charAt(i);
                int index = ch - ('a' - '\0');
                if (n.map[index] == null) {
                    return false;
                }
                 n = n.map[index];
            }
            return checkIsWord ? n.isWord : true;
        }
    }

    // Your Trie object will be instantiated and called as such:
    // Trie trie = new Trie();
    // trie.insert("somestring");
    // trie.search("key");
}
