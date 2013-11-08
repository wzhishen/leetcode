public class Solution {
    
    // use trie: O(n) time
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        TrieNode n = new TrieNode();
        for (String str : strs) {
            if (str.isEmpty()) return "";
            addWord(str, n);
        }
        if (n.children.keySet().size() > 1) return "";
        StringBuffer sb = new StringBuffer();
        char letter = n.children.keySet().iterator().next();
        while (n.children.containsKey(letter)) {
            sb.append(letter);
            n = n.children.get(letter);
            if (n.children.keySet().size() > 1) break;
            if (n.isWord) break;
            letter = n.children.keySet().iterator().next();
        }
        return sb.toString();
    }
    
    public void addWord(String s, TrieNode n) {
        if (n == null) return;
        char[] letters = s.toCharArray();
        for (char letter : letters) {
            if (!n.children.containsKey(letter)) {
                n.children.put(letter, new TrieNode(letter));
            }
            n = n.children.get(letter);
        }
        n.isWord = true;
    }
    
    class TrieNode {
        char ch;
        boolean isWord;
        HashMap<Character, TrieNode> children;
        public TrieNode(char ch) { 
            this.ch = ch;
            isWord = false;
            children = new HashMap<Character, TrieNode>(); 
        }
        public TrieNode() { this('\0'); }
    }
    
    // brute force: O(n*m) time
    public String longestCommonPrefixBF(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; ++i) {
            int j = 0;
            while (j < Math.min(prefix.length(), strs[i].length())) {
                if (prefix.charAt(j) != strs[i].charAt(j)) break;
                ++j;
            }
            prefix = prefix.substring(0, j);
        }
        return prefix;
    }
}