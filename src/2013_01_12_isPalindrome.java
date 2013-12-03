public class Solution {
    // Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

    // For example,
    // "A man, a plan, a canal: Panama" is a palindrome.
    // "race a car" is not a palindrome.

    // Note:
    // Have you consider that the string might be empty? This is a good question to ask during an interview.

    // For the purpose of this problem, we define empty string as valid palindrome.
    
    public boolean isPalindrome(String s) {
        if (s == null) return false;
        s = s.toLowerCase();
        int head = 0;
        int tail = s.length() - 1;
        while (head < tail) {
            while (!Character.isLetterOrDigit(s.charAt(head))) {
                ++head;
                if (head > tail) return true;
            }
            while (!Character.isLetterOrDigit(s.charAt(tail))) --tail;
            if (s.charAt(head) != s.charAt(tail)) return false;
            ++head;
            --tail;
        }
        return true;
    }
}