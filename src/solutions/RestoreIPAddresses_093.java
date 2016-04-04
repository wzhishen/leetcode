package solutions;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/restore-ip-addresses/
 *
 * Given a string containing only digits, restore it by returning all possible
 * valid IP address combinations.
 *
 * For example:
 * Given "25525511135",
 * return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
 */
public class RestoreIPAddresses_093 {
    /* What is a valid IP address?
     * A valid IP address contains 4 blocks, each ranging from 0 to 255.
     * A block can't start with a 0 if it's not 0.
     */
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<String>();
        if (s == null || s.length() < 4 || s.length() > 12) return result;
        restore(result, new ArrayList<String>(), s, 0);
        return result;
    }

    private void restore(List<String> result, List<String> address, String s, int index) {
        if (address.size() == 4 && index == s.length()) {
            StringBuilder ip = new StringBuilder();
            for (String n : address) ip.append(n).append('.');
            result.add(ip.substring(0, ip.length() - 1));
        } else {
            for (int i = index; i < s.length() && i < index + 3; ++i) {
                String n = s.substring(index, i + 1);
                if (isValid(n)) {
                    address.add(n);
                    restore(result, address, s, i + 1);
                    address.remove(address.size() - 1);
                }
            }
        }
    }
   
    private boolean isValid(String n) {
        if (n.length() == 1) return true;
        if (n.length() == 2 && n.charAt(0) != '0') return true;
        if (n.length() == 3 && n.charAt(0) != '0' && Integer.parseInt(n) <= 255) return true;
        return false;
    }
}
