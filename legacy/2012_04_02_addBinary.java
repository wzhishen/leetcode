public class Solution {
    // Given two binary strings, return their sum (also a binary string).

    // For example,
    // a = "11"
    // b = "1"
    // Return "100".
    
    public String addBinary(String a, String b) {
        if (a == null || b == null || a.isEmpty() || b.isEmpty()) return null;
        StringBuffer sb = new StringBuffer();
        int pa = a.length() - 1;
        int pb = b.length() - 1;
        int carry = 0;
        while (pa >= 0 || pb >= 0 || carry > 0) {
            int vala = pa >= 0 ? a.charAt(pa)-48 : 0;
            int valb = pb >= 0 ? b.charAt(pb)-48 : 0;
            int sum = vala + valb + carry;
            int digit = sum % 2;
            carry = sum / 2;
            sb.insert(0, digit); //StringBuffer supports insert(int index, int n)
            if (pa >= 0) --pa;
            if (pb >= 0) --pb;
        }
        return sb.toString();
    }
}