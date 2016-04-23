package solutions;

import java.util.HashMap;

/**
 * https://leetcode.com/problems/unique-word-abbreviation/
 *
 * An abbreviation of a word follows the form <first letter><number><last letter>.
 * Below are some examples of word abbreviations:
 *
 * a) it                      --> it    (no abbreviation)
 *
 *      1
 * b) d|o|g                   --> d1g
 *
 *               1    1  1
 *      1---5----0----5--8
 * c) i|nternationalizatio|n  --> i18n
 *
 *               1
 *      1---5----0
 * d) l|ocalizatio|n          --> l10n
 * Assume you have a dictionary and given a word, find whether its abbreviation is
 * unique in the dictionary. A word's abbreviation is unique if no other word from
 * the dictionary has the same abbreviation.
 *
 * Example:
 * Given dictionary = [ "deer", "door", "cake", "card" ]
 *
 * isUnique("dear") -> false
 * isUnique("cart") -> true
 * isUnique("cane") -> false
 * isUnique("make") -> true
 */
public class UniqueWordAbbreviation_288 {

    public class ValidWordAbbr {
        final String DUPLICATE = "DUPLICATE_VALUE";
        HashMap<String, String> map = new HashMap<String, String>();

        public ValidWordAbbr(String[] dictionary) {
            if (dictionary == null) return;

            for (String word : dictionary) {
                String abbr = compress(word);
                if (map.containsKey(abbr)) {
                    if (!map.get(abbr).equals(word)) map.put(abbr, DUPLICATE);
                } else {
                    map.put(abbr, word);
                }
            }
        }

        public boolean isUnique(String word) {
            if (word == null) return false;

            String abbr = compress(word);
            if (!map.containsKey(abbr)) return true;
            if (map.get(abbr).equals(word)) return true;
            return false;
        }

        private String compress(String word) {
            int len = word.length();
            return len > 2 ? "" + word.charAt(0) + (len - 2) + word.charAt(len - 1) : word;
        }
    }


    // Your ValidWordAbbr object will be instantiated and called as such:
    // ValidWordAbbr vwa = new ValidWordAbbr(dictionary);
    // vwa.isUnique("Word");
    // vwa.isUnique("anotherWord");
}
