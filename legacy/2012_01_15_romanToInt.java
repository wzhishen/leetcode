public class Solution {
    // Given a roman numeral, convert it to an integer.

    // Input is guaranteed to be within the range from 1 to 3999.
    
    public int romanToInt(String s) {
        if (s == null) return -1;
        
        ArrayList<Pair> digits = new ArrayList<Pair>();
        digits.add(new Pair(1, "I"));digits.add(new Pair(4, "IV"));digits.add(new Pair(5, "V"));
        digits.add(new Pair(9, "IX"));digits.add(new Pair(10, "X"));digits.add(new Pair(40, "XL"));
        digits.add(new Pair(50, "L"));digits.add(new Pair(90, "XC"));digits.add(new Pair(100, "C"));
        digits.add(new Pair(400, "CD"));digits.add(new Pair(500, "D"));digits.add(new Pair(900, "CM"));
        digits.add(new Pair(1000, "M"));
        
        int num = 0;
        while (!s.isEmpty()) {
            for (Pair p : digits) {
                if (s.endsWith(p.roman)) {
                    num += p.val;
                    s = s.substring(0, s.lastIndexOf(p.roman));
                }
            }
        }
        return num;
    }
    
    class Pair {
        int val; String roman;
        public Pair(int n, String r) {val = n; roman = r;}
    }
}