public class Solution {
    // A message containing letters from A-Z is being encoded to numbers using the following mapping:

    // 'A' -> 1
    // 'B' -> 2
    // ...
    // 'Z' -> 26
    // Given an encoded message containing digits, determine the total number of ways to decode it.

    // For example,
    // Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).

    // The number of ways decoding "12" is 2.
    
     public int numDecodings(String s) {
        if (s == null || s.isEmpty()) return 0;
        return numDecodings(s, new HashMap<String, Integer>());
    }
    
    private int numDecodings(String s, HashMap<String, Integer> cache) {
        if (cache.containsKey(s)) return cache.get(s);
        if (s.isEmpty()) return 1;
        if (s.length() == 1) {
            if (s.charAt(0) == '0') return 0;
            else return 1;
        }
        int cnt = 0;
        char one = s.charAt(0);
        char two = s.charAt(1);
        if (one != '0') cnt += numDecodings(s.substring(1), cache);
        if (one == '1' || (one == '2' && two <= '6')) cnt += numDecodings(s.substring(2), cache);
        cache.put(s, cnt);
        return cnt;
    }
}