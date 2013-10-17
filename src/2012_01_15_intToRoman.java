public class Solution {
    // Given an integer, convert it to a roman numeral.

    // Input is guaranteed to be within the range from 1 to 3999.
    
    // digits = [(1000, 'M'), (900, 'CM'), (500, 'D'), (400, 'CD' ),
    //         (100, 'C'), (90, 'XC'), (50, 'L'), (40, 'XL'),
    //         (10, 'X'), (9, 'IX'), (5, 'V'), (4, 'IV'), (1, 'I')]
    public String intToRoman(int num) {
        if (num < 1 || num > 3999) return "ERROR";
        
        ArrayList<Pair> digits = new ArrayList<Pair>();
        digits.add(new Pair(1000, "M"));digits.add(new Pair(900, "CM"));digits.add(new Pair(500, "D"));
        digits.add(new Pair(400, "CD"));digits.add(new Pair(100, "C"));digits.add(new Pair(90, "XC"));
        digits.add(new Pair(50, "L"));digits.add(new Pair(40, "XL"));digits.add(new Pair(10, "X"));
        digits.add(new Pair(9, "IX"));digits.add(new Pair(5, "V"));digits.add(new Pair(4, "IV"));
        digits.add(new Pair(1, "I"));
        
        StringBuffer sb = new StringBuffer();
        while (digits.size() > 0) {
            Pair top = digits.get(0);
            if (num >= top.val) {
                num -= top.val;
                sb.append(top.roman);
            }
            else {
                digits.remove(top);
            }
        }
        return sb.toString();
    }
    
    class Pair {
        int val; String roman;
        public Pair(int n, String r) {val = n; roman = r;}
    }
}