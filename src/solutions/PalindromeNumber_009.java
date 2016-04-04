package solutions;

/**
 * https://leetcode.com/problems/palindrome-number/
 *
 * Determine whether an integer is a palindrome. Do this without extra space.
 *
 * Some hints:
 * Could negative integers be palindromes? (ie, -1)
 * If you are thinking of converting the integer to string, note the restriction
 * of using extra space.
 * You could also try reversing an integer. However, if you have solved the problem
 * "Reverse Integer", you know that the reversed integer might overflow. How would
 * you handle such case?
 * There is a more generic way of solving this problem.
 */
public class PalindromeNumber_009 {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        int div = 1;
        while (x / div >= 10) div *= 10;
        int mul = 1;
        while (div > mul) {
            if ((x / div) % 10 != (x / mul) % 10) return false;
            div /= 10;
            mul *= 10;
        }
        return true;
    }
}
