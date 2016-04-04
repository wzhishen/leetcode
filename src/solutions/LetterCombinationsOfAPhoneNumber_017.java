package solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 *
 * Given a digit string, return all possible letter combinations that the
 * number could represent.
 * A mapping of digit to letters (just like on the telephone buttons) is
 * given below.
 *
 * Input: Digit string "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * Note:
 * Although the above answer is in lexicographical order, your answer could
 * be in any order you want.
 */
public class LetterCombinationsOfAPhoneNumber_017 {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<String>();
        if (digits == null || digits.isEmpty()) return result;
        letterCombinations(map(), result, "", digits, 0);
        return result;
    }

    private void letterCombinations(HashMap<Character, char[]> map, List<String> result, String s, String digits, int index) {
        if (index == digits.length()) {
            result.add(s);
        } else {
            for (char letter : map.get(digits.charAt(index))) {
                letterCombinations(map, result, s + letter, digits, index + 1);
            }
        }
    }

    private HashMap<Character, char[]> map() {
        HashMap<Character, char[]> map = new HashMap<Character, char[]>();
        map.put('2', new char[] {'a', 'b', 'c'});
        map.put('3', new char[] {'d', 'e', 'f'});
        map.put('4', new char[] {'g', 'h', 'i'});
        map.put('5', new char[] {'j', 'k', 'l'});
        map.put('6', new char[] {'m', 'n', 'o'});
        map.put('7', new char[] {'p', 'q', 'r', 's'});
        map.put('8', new char[] {'t', 'u', 'v'});
        map.put('9', new char[] {'w', 'x', 'y', 'z'});
        return map;
    }
}
