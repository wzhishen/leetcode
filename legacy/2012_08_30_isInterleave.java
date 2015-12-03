public class Solution {
    // Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.

    // For example,
    // Given:
    // s1 = "aabcc",
    // s2 = "dbbca",

    // When s3 = "aadbbcbcac", return true.
    // When s3 = "aadbbbaccc", return false.
    
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1 == null || s2 == null || s3 == null) return false;
        char[] chars1 = (s1 + s2).toCharArray();
        char[] chars2 = s3.toCharArray();
        Arrays.sort(chars1);
        Arrays.sort(chars2);
        if (!new String(chars1).equals(new String(chars2))) return false;
        return isInterleaveHelper(s1, s2, s3, new HashMap<String, Boolean>());
    }
    
    // recursion with memoization
    private boolean isInterleaveHelper(String s1, String s2, String s3, HashMap<String, Boolean> cache) {
        String key = s1 + "#" + s2 + "#" + s3;
        if (cache.containsKey(key)) return cache.get(key);
        if (s1.isEmpty() ) return s2.equals(s3);
        else if (s2.isEmpty() ) return s1.equals(s3);
        boolean r1 = false; boolean r2 = false;
        if (s3.charAt(0) == s1.charAt(0)) 
            r1 = isInterleaveHelper(s1.substring(1), s2, s3.substring(1), cache);
        if (s3.charAt(0) == s2.charAt(0)) 
            r2 = isInterleaveHelper(s1, s2.substring(1), s3.substring(1), cache);
        boolean res = r1 || r2;
        cache.put(key, res);
        return res;
    }
}