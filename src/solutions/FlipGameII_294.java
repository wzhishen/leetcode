package solutions;

import java.util.HashMap;

/**
 * https://leetcode.com/problems/flip-game-ii/
 *
 * You are playing the following Flip Game with your friend: Given a
 * string that contains only these two characters: + and -, you and
 * your friend take turns to flip two consecutive "++" into "--". The
 * game ends when a person can no longer make a move and therefore
 * the other person will be the winner.
 * Write a function to determine if the starting player can guarantee
 * a win.
 *
 * For example, given s = "++++", return true. The starting player
 * can guarantee a win by flipping the middle "++" to become "+--+".
 *
 * Follow up:
 * Derive your algorithm's runtime complexity.
 */
public class FlipGameII_294 {
    /* Time complexity analysis ref:
     * http://www.meetqun.com/thread-11570-1-1.html
     * http://stackoverflow.com/questions/34254085/how-to-analyze-time-complexity-here
     * https://leetcode.com/discuss/64291/share-my-java-backtracking-solution
     */
    public boolean canWin(String s) {
        if (s == null) return false;
        return canWinHelper(s, new HashMap<String, Boolean>());
    }

    // memoization: exponential time
    private boolean canWinHelper(String s, HashMap<String, Boolean> map) {
        if (map.containsKey(s)) return map.get(s);
        boolean res = false;
        for (int i = 0; i < s.length() - 1; ++i) {
            if (s.charAt(i) == '+' && s.charAt(i + 1) == '+') {
                if (!canWinHelper(s.substring(0, i) + "--" + s.substring(i + 2), map)) {
                    res = true;
                    break;
                }
            }
        }
        map.put(s, res);
        return res;
    }

    // naive DFS: factorial time
    private boolean canWinHelper(String s) {
        for (int i = 0; i < s.length() - 1; ++i) {
            if (s.charAt(i) == '+' && s.charAt(i + 1) == '+') {
                if (!canWinHelper(s.substring(0, i) + "--" + s.substring(i + 2))) return true;
            }
        }
        return false;
    }
}
