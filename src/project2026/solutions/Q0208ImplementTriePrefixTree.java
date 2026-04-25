package project2026.solutions;

import java.util.HashMap;

/*
https://leetcode.com/problems/implement-trie-prefix-tree/description/

A trie (pronounced as "try") or prefix tree is a tree data structure used to efficiently store and retrieve keys in a dataset of strings. There are various applications of this data structure, such as autocomplete and spellchecker.

Implement the Trie class:

Trie() Initializes the trie object.
void insert(String word) Inserts the string word into the trie.
boolean search(String word) Returns true if the string word is in the trie (i.e., was inserted before), and false otherwise.
boolean startsWith(String prefix) Returns true if there is a previously inserted string word that has the prefix prefix, and false otherwise.


Example 1:

Input
["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
[[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
Output
[null, null, true, false, true, null, true]

Explanation
Trie trie = new Trie();
trie.insert("apple");
trie.search("apple");   // return True
trie.search("app");     // return False
trie.startsWith("app"); // return True
trie.insert("app");
trie.search("app");     // return True


Constraints:

1 <= word.length, prefix.length <= 2000
word and prefix consist only of lowercase English letters.
At most 3 * 104 calls in total will be made to insert, search, and startsWith.

 */
public class Q0208ImplementTriePrefixTree /* Trie */ {
    private Node root;

    public Q0208ImplementTriePrefixTree() /* Trie */ {
        root = new Node('\0');
    }

    public void insert(String word) {
        Node p = root;
        for (char ch : word.toCharArray()) {
            if (!p.children.containsKey(ch)) {
                p.children.put(ch, new Node(ch));
            }
            p = p.children.get(ch);
        }
        p.isWord = true;
    }

    public boolean search(String word) {
        Node p = root;
        for (char ch : word.toCharArray()) {
            if (!p.children.containsKey(ch)) {
                return false;
            }
            p = p.children.get(ch);
        }
        return p.isWord;
    }

    public boolean startsWith(String prefix) {
        Node p = root;
        for (char ch : prefix.toCharArray()) {
            if (!p.children.containsKey(ch)) {
                return false;
            }
            p = p.children.get(ch);
        }
        return true;
    }

    class Node {
        char ch; boolean isWord; HashMap<Character, Node> children;
        public Node(char c) { ch = c; isWord = false; children = new HashMap<>(); }
    }
}

/*
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */