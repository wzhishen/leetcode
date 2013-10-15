public class Solution {
    // Implement atoi to convert a string to an integer.

    // Hint: Carefully consider all possible input cases. If you want a challenge, please do not see below and ask yourself what are the possible input cases.

    // Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). You are responsible to gather all the input requirements up front.

    // spoilers alert... click to show requirements for atoi.

    // Requirements for atoi:
    // The function first discards as many whitespace characters as necessary until the first non-whitespace character is found. Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible, and interprets them as a numerical value.

    // The string can contain additional characters after those that form the integral number, which are ignored and have no effect on the behavior of this function.

    // If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.

    // If no valid conversion could be performed, a zero value is returned. If the correct value is out of the range of representable values, INT_MAX (2147483647) or INT_MIN (-2147483648) is returned.
    
    public int atoi(String str) {
        if (str == null) return 0;
        str = str.trim();
        str += " ";
        int length = 0;
        int end = 0;
        boolean neg = false;
        boolean op = false;
        for (int i = 0; i < str.length(); ++i) {
            char ch = str.charAt(i);
            if (op && (ch == '+' || ch == '-')) {
                break;
            }
            else if (!Character.isDigit(ch) && ch != '+' && ch != '-') {
                end = i - 1;
                break;
            }
            else if (ch == '+') {
                op = true;
            }
            else if (ch == '-') {
                neg = true;
                op = true;
            }
            else if (Character.isDigit(ch)) {
                ++length;
            }
        }
        
        long base = neg ? -1 : 1;
        long sum = 0;
        for (int i = end; i >= end - length + 1; --i) {
            sum += (str.charAt(i) - 48) * base;
            if (sum > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            else if (sum < Integer.MIN_VALUE) return Integer.MIN_VALUE;
            base *= 10;
        }
        return (int) sum;
    }
}