public class Solution {
    // Given an array of strings, return all groups of strings that are anagrams.

    // Note: All inputs will be in lower-case.
    
    public ArrayList<String> anagrams(String[] strs) {
        if (strs == null) return null;
        HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
        ArrayList<String> ret = new ArrayList<String>();
        for (String s : strs) {
            String key = sort(s);
            if (map.containsKey(key)) {
                map.get(key).add(s);
            }
            else {
                ArrayList<String> list = new ArrayList<String>();
                list.add(s);
                map.put(key, list);
            }
        }
        for (String key : map.keySet()) {
            if (map.get(key).size() > 1) {
                ret.addAll(map.get(key));
            }
        }
        return ret;
    }
    
    private String sort(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}