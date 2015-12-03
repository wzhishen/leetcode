public class Solution {
    public ArrayList<String> letterCombinations(String digits) {
        // Given a digit string, return all possible letter combinations that the number could represent.

        // A mapping of digit to letters (just like on the telephone buttons) is given below.
        
        // Input:Digit string "23"
        // Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
        // Note:
        // Although the above answer is in lexicographical order, your answer could be in any order you want.

        if (digits == null) return null;
        ArrayList<String> ret = new ArrayList<String>();
        if (digits.isEmpty()) {
            ret.add("");
            return ret;
        }
        ArrayList<String> last = letterCombinations(digits.substring(1));
        for (String lastStr : last) {
            for (char letter : numToLetters(digits.charAt(0) - 48)) {
                ret.add(letter + lastStr);
            }
        }
        return ret;
    }
    
    private Set<Character> numToLetters(int n) {
        Set<Character> ret = new HashSet<Character>();
        switch (n) {
            case 2: ret.add('a'); ret.add('b'); ret.add('c');               break;
            case 3: ret.add('d'); ret.add('e'); ret.add('f');               break;
            case 4: ret.add('g'); ret.add('h'); ret.add('i');               break;
            case 5: ret.add('j'); ret.add('k'); ret.add('l');               break;
            case 6: ret.add('m'); ret.add('n'); ret.add('o');               break;
            case 7: ret.add('p'); ret.add('q'); ret.add('r'); ret.add('s'); break;
            case 8: ret.add('t'); ret.add('u'); ret.add('v');               break;
            case 9: ret.add('w'); ret.add('x'); ret.add('y'); ret.add('z'); break;
        }
        return ret;
    }
}