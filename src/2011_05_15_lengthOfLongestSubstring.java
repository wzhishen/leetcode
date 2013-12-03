public class Solution {
    // Given a string, find the length of the longest substring without repeating characters. For example, the longest substring 
    // without repeating letters for "abcabcbb" is "abc", which the length is 3. For "bbbbb" the longest substring is "b", with 
    // the length of 1.

    // use a hashtable, two-pointer: O(n) time
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty()) return 0;
        int i = 0;
        int j = 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int maxlen = 0;
        while (j < s.length()) {
            char ch = s.charAt(j);
            if (map.containsKey(ch)) {
                if (s.substring(i, j).length() > maxlen) {
                    maxlen = s.substring(i, j).length();
                }
                while (i < map.get(ch)) {
                    map.remove(s.charAt(i));
                    ++i;
                }
                ++i;
            }
            map.put(ch, j);
            ++j;
        }
        if (s.substring(i, j).length() > maxlen) {
            maxlen = s.substring(i, j).length();
        }
        return maxlen;
    }
    
    // brute force, O(n^2) time
    public int lengthOfLongestSubstringBF(String s) {
        if (s == null || s.isEmpty()) return 0;
        HashSet<Character> set = new HashSet<Character>();
        int maxlen = 0;
        for (int i = 0; i < s.length(); ++i) {
            int len = 0;
            set.clear();
            for (int j = i; j < s.length(); ++j) {
                char ch = s.charAt(j);
                if (!set.contains(ch)) {
                    set.add(ch);
                    ++len;
                }
                else {
                    break;
                }
            }
            if (len > maxlen) maxlen = len;
        }
        return maxlen;
    }
}