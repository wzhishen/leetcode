public class Solution {
    // Given two words (start and end), and a dictionary, find the length of shortest transformation sequence from start to end, such that:

    // Only one letter can be changed at a time
    // Each intermediate word must exist in the dictionary
    // For example,

    // Given:
    // start = "hit"
    // end = "cog"
    // dict = ["hot","dot","dog","lot","log"]
    // As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
    // return its length 5.

    // Note:
    // Return 0 if there is no such transformation sequence.
    // All words have the same length.
    // All words contain only lowercase alphabetic characters.
    
    public int ladderLength(String start, String end, HashSet<String> dict) {
        if (start == null || end == null || dict == null) return 0;
        if (start.isEmpty() || end.isEmpty() || dict.isEmpty()) return 0;
        start = start.toLowerCase();
        end = end.toLowerCase();
        LinkedList<String> q = new LinkedList<String>();
        HashSet<String> visited = new HashSet<String>();
        HashMap<String, String> backtractMap = new HashMap<String, String>();
        visited.add(start);
        q.add(start);
        while (!q.isEmpty()) {
            String w = q.removeFirst();
            for (String s : getAdjWords(w, dict)) {
                if (!visited.contains(s)) {
                    visited.add(s);
                    backtractMap.put(s, w);
                    if (s.equals(end)) {
                        int cnt = 1;
                        while (backtractMap.containsKey(s)) {
                            s = backtractMap.get(s);
                            ++cnt;
                        }
                        return cnt;
                    }
                    else {
                        q.add(s);
                    }
                }
            }
        }
        return 0;
    }
    
    private ArrayList<String> getAdjWords(String s, HashSet<String> dict) {
        ArrayList<String> ret = new ArrayList<String>();
        for (int i = 0; i < s.length(); ++i) {
            StringBuffer sb = new StringBuffer(s);
            for (char ch = 'a'; ch <= 'z'; ++ch) {
                if (sb.charAt(i) != ch) {
                    sb.setCharAt(i, ch);
                    if (dict.contains(sb.toString())) { // check word existence here!
                        ret.add(sb.toString());
                    }
                }
            }
        }
        return ret;
    }
}