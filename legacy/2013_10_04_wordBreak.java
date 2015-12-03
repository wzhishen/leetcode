public class Solution {
    // Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

    // For example, given
    // s = "leetcode",
    // dict = ["leet", "code"].

    // Return true because "leetcode" can be segmented as "leet code".
    
    public boolean wordBreak(String s, Set<String> dict) {
        return wordBreak(s, dict, new HashMap<String, Boolean>());
    }
    
    // recursion with memoization
    private boolean wordBreak(String s, Set<String> dict, HashMap<String, Boolean> cache) {
        if (s == null || dict == null || s.isEmpty() || dict.isEmpty()) return false;
        if (cache.containsKey(s)) return cache.get(s);
        if (dict.contains(s)) return true;
        for (int i = 1; i < s.length(); ++i) {
            if (wordBreak(s.substring(0, i), dict, cache) && wordBreak(s.substring(i), dict, cache)) {
                cache.put(s, true);
                return true;
            }
        }
        cache.put(s, false);
        return false;
    }
    
}