public class Solution {
    // Given a string s consists of upper/lower-case alphabets and 
    // empty space characters ' ', return the length of last word 
    // in the string.

    // If the last word does not exist, return 0.

    // Note: A word is defined as a character sequence consists of 
    // non-space characters only.

    // For example, 
    // Given s = "Hello World",
    // return 5.

    // O(n) time
    public int lengthOfLastWord(String s) {
        if (s == null || s.isEmpty()) return 0;
        int tail = s.length() - 1;
        while (s.charAt(tail) == ' ') {
            if (--tail < 0) return 0;
        }
        int cnt = 0;
        while (s.charAt(tail) != ' ') {
            ++cnt;
            if (--tail < 0) return cnt;
        }
        return cnt;
    }
    
    // trivial
    public int lengthOfLastWordTrivial(String s) {
        if (s == null || s.isEmpty()) return 0;
        String[] words = s.split(" ");
        return words.length == 0 ? 0 : words[words.length - 1].length();
    }
}